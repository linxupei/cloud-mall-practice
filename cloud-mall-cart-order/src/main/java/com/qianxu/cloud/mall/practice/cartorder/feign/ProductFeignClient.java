package com.qianxu.cloud.mall.practice.cartorder.feign;

import com.qianxu.cloud.mall.practice.categoryproduct.model.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/4/1 22:02
 * @describe 商品FeignClient
 */
@FeignClient(value = "cloud-mall-category-product")
public interface ProductFeignClient {
    /**
     * 获取商品详情
     * @param id 商品id
     * @return 商品实例
     */
    @GetMapping("product/detailForFeign")
    public Product detailForFeign(@RequestParam Integer id);


    @PostMapping({"product/updateStock"})
    public void updateStock(@RequestParam Integer productId, @RequestParam Integer stock);
}
