package com.qianxu.cloud.mall.practice.categoryproduct.controller;

import com.github.pagehelper.PageInfo;
import com.qianxu.cloud.mall.practice.categoryproduct.model.pojo.Product;
import com.qianxu.cloud.mall.practice.categoryproduct.model.request.ProductListReq;
import com.qianxu.cloud.mall.practice.categoryproduct.service.ProductService;
import com.qianxu.cloud.mall.practice.common.common.ApiRestResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/3/11 22:11
 * @describe 前台商品controller
 */
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @ApiOperation("商品详情列表")
    @GetMapping("product/detail")
    public ApiRestResponse detail(Integer id) {
        Product product = productService.detail(id);
        return ApiRestResponse.success(product);
    }

    @ApiOperation("商品列表")
    @GetMapping("product/list")
    public ApiRestResponse list(ProductListReq productListReq) {
        PageInfo list = productService.list(productListReq);
        return ApiRestResponse.success(list);
    }

    @ApiOperation("商品详情列表")
    @GetMapping("product/detailForFeign")
    @ResponseBody
    public Product detailForFeign(@RequestParam Integer id) {
        Product product = productService.detail(id);
        return product;
    }

    @ApiOperation("更新商品库存")
    @PostMapping({"product/updateStock"})
    public void updateStock(@RequestParam Integer productId, @RequestParam Integer stock) {
        productService.updateStock(productId, stock);
    }

}
