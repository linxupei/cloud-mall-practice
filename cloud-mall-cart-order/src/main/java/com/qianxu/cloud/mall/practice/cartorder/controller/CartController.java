package com.qianxu.cloud.mall.practice.cartorder.controller;

import com.qianxu.cloud.mall.practice.cartorder.feign.UserFeignClient;
import com.qianxu.cloud.mall.practice.cartorder.model.vo.CartVO;
import com.qianxu.cloud.mall.practice.cartorder.service.CartService;
import com.qianxu.cloud.mall.practice.common.common.ApiRestResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.util.List;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/3/12 15:18
 * @describe
 */
@RestController
@RequestMapping({"/cart"})
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;
    private final UserFeignClient userFeignClient;

    @ApiOperation("获取用户列表")
    @GetMapping({"/list"})
    public ApiRestResponse list() {
        //内部获取用户id, 防止横向越权
        List<CartVO> cartVOS = cartService.list(userFeignClient.getUser().getId());
        return ApiRestResponse.success(cartVOS);
    }

    @ApiOperation("添加商品到购物车, 或改变商品数量")
    @PostMapping({"/add"})
    public ApiRestResponse add(@RequestParam Integer productId, @RequestParam Integer count) {
        List<CartVO> cartVOS = cartService.add(userFeignClient.getUser().getId(), productId, count);
        return ApiRestResponse.success(cartVOS);
    }

    @ApiOperation("更新购物车商品数量")
    @PutMapping({"/update"})
    public ApiRestResponse update(@RequestParam Integer productId, @RequestParam @Min(1) Integer count) {
        List<CartVO> cartVOS = cartService.update(userFeignClient.getUser().getId(), productId, count);
        return ApiRestResponse.success(cartVOS);
    }

    @ApiOperation("删除购物车商品")
    @DeleteMapping({"/delete"})
    public ApiRestResponse delete(@RequestParam Integer productId) {
        List<CartVO> cartVOS = cartService.delete(userFeignClient.getUser().getId(), productId);
        return ApiRestResponse.success(cartVOS);
    }

    @ApiOperation("选择/不选择购物车某商品")
    @PutMapping({"/select"})
    public ApiRestResponse select(@RequestParam Integer productId, @RequestParam Integer selected) {
        List<CartVO> cartVOS = cartService.selectOrNot(userFeignClient.getUser().getId(), productId, selected);
        return ApiRestResponse.success(cartVOS);
    }

    @ApiOperation("全选择/全不选择购物车某商品")
    @PutMapping({"/selectAll"})
    public ApiRestResponse selectAll(@RequestParam Integer selected) {
        List<CartVO> cartVOS = cartService.selectAllOrNot(userFeignClient.getUser().getId(), selected);
        return ApiRestResponse.success(cartVOS);
    }
}
