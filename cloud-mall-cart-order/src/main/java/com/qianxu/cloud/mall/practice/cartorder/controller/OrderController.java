package com.qianxu.cloud.mall.practice.cartorder.controller;

import com.github.pagehelper.PageInfo;
import com.qianxu.cloud.mall.practice.cartorder.model.request.CreateOrderReq;
import com.qianxu.cloud.mall.practice.cartorder.model.vo.OrderVO;
import com.qianxu.cloud.mall.practice.cartorder.service.OrderService;
import com.qianxu.cloud.mall.practice.common.common.ApiRestResponse;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author 谦虚
 * @version 1.0
 * @date 2021/3/13 10:33
 * @describe 订单Controller
 */
@RestController
@RequestMapping({"/order"})
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @ApiOperation("创建订单")
    @PostMapping({"/create"})
    public ApiRestResponse create(@Valid @RequestBody CreateOrderReq createOrderReq) {
        String orderNo = orderService.create(createOrderReq);
        return ApiRestResponse.success(orderNo);
    }

    @ApiOperation("订单详情")
    @GetMapping({"/detail"})
    public ApiRestResponse detail(@RequestParam String orderNo) {
        OrderVO orderVO = orderService.detail(orderNo);
        return ApiRestResponse.success(orderVO);
    }

    @ApiOperation("前台订单列表")
    @GetMapping({"/list"})
    public ApiRestResponse list(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo pageInfo = orderService.listForCustomer(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("取消订单")
    @PutMapping({"/cancel"})
    public ApiRestResponse cancel(@RequestParam String orderNo) {
        orderService.cancel(orderNo);
        return ApiRestResponse.success();
    }

    @ApiOperation("生成二维码")
    @GetMapping({"/qrcode"})
    public ApiRestResponse qrcode(@RequestParam String orderNo) {
        String pndAddress = orderService.qrcode(orderNo);
        return ApiRestResponse.success(pndAddress);
    }


}
