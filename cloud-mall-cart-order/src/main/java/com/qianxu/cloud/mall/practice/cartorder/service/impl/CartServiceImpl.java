package com.qianxu.cloud.mall.practice.cartorder.service.impl;


import com.qianxu.cloud.mall.practice.cartorder.feign.ProductFeignClient;
import com.qianxu.cloud.mall.practice.cartorder.model.dao.CartMapper;
import com.qianxu.cloud.mall.practice.cartorder.model.pojo.Cart;
import com.qianxu.cloud.mall.practice.cartorder.model.vo.CartVO;
import com.qianxu.cloud.mall.practice.cartorder.service.CartService;
import com.qianxu.cloud.mall.practice.categoryproduct.model.pojo.Product;
import com.qianxu.cloud.mall.practice.common.common.Constant;
import com.qianxu.cloud.mall.practice.common.exception.QianxuMallException;
import com.qianxu.cloud.mall.practice.common.exception.QianxuMallExceptionEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/3/12 15:33
 * @describe
 */
@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {


    private final ProductFeignClient productFeignClient;
    private final CartMapper cartMapper;

    @Override
    public List<CartVO> list(Integer userId) {
        List<CartVO> cartVOS = cartMapper.list(userId);
        for (CartVO cartVO : cartVOS) {
            cartVO.setTotalPrice(cartVO.getPrice() * cartVO.getQuantity());
        }
        return cartVOS;
    }

    @Override
    public List<CartVO> add(Integer userId, Integer productId, Integer count) {
        validProduct(productId, count);
        Cart cart = cartMapper.selectCartByUserIdAndProductId(userId, productId);
        if (cart == null) {
            //之前还没有加入购物车
            cart = new Cart();
            cart.setUserId(userId);
            cart.setProductId(productId);
            cart.setQuantity(count);
            cart.setSelected(Constant.CheckStatus.CHECKED);
            cartMapper.insertSelective(cart);
        } else {
            //已经在购物车中了, 数量相加
            Cart cartNew = new Cart();
            cartNew.setId(cart.getId());
            cartNew.setQuantity(cart.getQuantity() + count);
//            cartNew.setUserId(cart.getUserId());
//            cartNew.setProductId(cart.getProductId());
            cartNew.setSelected(Constant.CheckStatus.CHECKED);
            cartMapper.updateByPrimaryKeySelective(cartNew);
        }
        return this.list(userId);
    }

    /**
     * 判断商品是否可以加入购物车
     */
    private void validProduct(Integer productId, Integer count) {
        Product product = productFeignClient.detailForFeign(productId);
        //判断商品是否存在, 商品是否上架
        if (product == null || !product.getStatus().equals(Constant.SaleStatus.SALE)) {
            throw new QianxuMallException(QianxuMallExceptionEnum.NOT_SALE);
        }
        //判断商品库存
        if (count > product.getStock()) {
            throw new QianxuMallException(QianxuMallExceptionEnum.NOT_ENOUGH);
        }
    }

    @Override
    public List<CartVO> update(Integer userId, Integer productId, Integer count) {
        validProduct(productId, count);
        Cart cart = cartMapper.selectCartByUserIdAndProductId(userId, productId);
        if (cart == null) {
            throw new QianxuMallException(QianxuMallExceptionEnum.UPDATE_FAILED);
        } else {
            //在购物车中了, 数量相加
            Cart cartNew = new Cart();
            cartNew.setId(cart.getId());
            cartNew.setQuantity(count);
//            cartNew.setUserId(cart.getUserId());
//            cartNew.setProductId(cart.getProductId());
            cartNew.setSelected(Constant.CheckStatus.CHECKED);
            cartMapper.updateByPrimaryKeySelective(cartNew);
        }
        return this.list(userId);
    }

    @Override
    public List<CartVO> delete(Integer userId, Integer productId) {
        Cart cart = cartMapper.selectCartByUserIdAndProductId(userId, productId);
        if (cart == null) {
            //不在购物车中, 无法删除
            throw new QianxuMallException(QianxuMallExceptionEnum.DELETE_FAILED);
        } else {
            //在购物车中了, 直接删除
            cartMapper.deleteByPrimaryKey(cart.getId());
        }
        return this.list(userId);
    }

    @Override
    public List<CartVO> selectOrNot(Integer userId, Integer productId, Integer selected) {
        Cart cartOld = cartMapper.selectCartByUserIdAndProductId(userId, productId);
        if (cartOld == null) {
            throw new QianxuMallException(QianxuMallExceptionEnum.UPDATE_FAILED);
        } else {
            cartMapper.selectOrNot(userId, productId, selected);
        }
        return this.list(userId);
    }

    @Override
    public List<CartVO> selectAllOrNot(Integer userId, Integer selected) {
        cartMapper.selectOrNot(userId, null, selected);
        return this.list(userId);
    }

}
