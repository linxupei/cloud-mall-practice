package com.qianxu.cloud.mall.practice.cartorder.controller;

import com.github.pagehelper.PageInfo;
import com.qianxu.cloud.mall.practice.cartorder.service.OrderService;
import com.qianxu.cloud.mall.practice.common.common.ApiRestResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/3/13 16:37
 * @describe
 */
@RestController
@RequiredArgsConstructor
public class OrderAdminController {

    private final OrderService orderService;

    @ApiOperation("管理员订单列表")
    @GetMapping({"/admin/order/list"})
    public ApiRestResponse listForAdmin(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo pageInfo = orderService.listForAdmin(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("支付订单")
    @GetMapping({"pay"})
    public ApiRestResponse pay(@RequestParam String orderNo) {
        orderService.pay(orderNo);
        return ApiRestResponse.success();
    }

    @ApiOperation("管理员发货")
    @PutMapping({"/admin/order/delivered"})
    public ApiRestResponse delivered(@RequestParam String orderNo) {
        orderService.delivered(orderNo);
        return ApiRestResponse.success();
    }

    @ApiOperation("完结订单")
    @PutMapping({"/order/finish"})
    public ApiRestResponse finish(@RequestParam String orderNo) {
        orderService.finish(orderNo);
        return ApiRestResponse.success();
    }
}
