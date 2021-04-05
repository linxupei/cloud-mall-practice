package com.qianxu.cloud.mall.practice.categoryproduct.service;

import com.qianxu.cloud.mall.practice.categoryproduct.model.pojo.Product;
import com.qianxu.cloud.mall.practice.categoryproduct.model.request.AddProductReq;
import com.qianxu.cloud.mall.practice.categoryproduct.model.request.ProductListReq;
import com.github.pagehelper.PageInfo;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/3/11 16:15
 * @describe 商品服务接口
 */
public interface ProductService {

    void add(AddProductReq addProductReq);

    void update(Product updateProduct);

    void delete(Integer id);

    void batchUpdateSellStatus(Integer[] ids, Integer sellStatus);

    PageInfo selectListForAdmin(Integer pageNum, Integer pageSize);

    Product detail(Integer id);

    PageInfo list(ProductListReq productListReq);

    void updateStock(Integer productId, Integer stock);
}
