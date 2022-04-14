package com.momshop.mom_shop.controller;

import com.momshop.mom_shop.base.model.DailyIncome;
import com.momshop.mom_shop.base.model.OrderInfo;
import com.momshop.mom_shop.common.api.CommonPage;
import com.momshop.mom_shop.common.api.CommonResult;
import com.momshop.mom_shop.common.helper.ResultHelper;
import com.momshop.mom_shop.domain.OrderCondition;
import com.momshop.mom_shop.domain.OrderDO;
import com.momshop.mom_shop.domain.TimeFrame;
import com.momshop.mom_shop.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author Antique
 * @Date 2022/1/19 20:55
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/order")
@Api(tags = "OrderController")
public class OrderController {

    @Resource
    private OrderService orderService;


    @ApiOperation("添加订单")
    @PostMapping(value = "addOrder")
    @ResponseBody
    public CommonResult addOrder(@RequestBody OrderInfo order){
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        return ResultHelper.checkData(orderService.addOrder(order));
    }

    @ApiOperation("更新订单")
    @PostMapping(value = "updateOrder")
    @ResponseBody
    public CommonResult updateOrder(@RequestBody OrderInfo order){
        order.setUpdateTime(new Date());
        return ResultHelper.checkData(orderService.updateOrder(order));
    }

    @ApiOperation("删除订单")
    @PostMapping(value = "deleteOrder")
    @ResponseBody
    public CommonResult deleteOrder(@RequestBody OrderDO order){
        return ResultHelper.checkData(orderService.deleteOrder(order));
    }

    @ApiOperation("根据订单id查询订单")
    @GetMapping(value = "getOrderInfoById")
    @ResponseBody
    public CommonResult getOrderInfoById(@RequestParam Integer id){
        OrderInfo orderInfo = orderService.getOrderInfoById(id);
        return ResultHelper.checkDataAndResponse(!Objects.isNull(orderInfo),orderInfo);
    }

    @ApiOperation("获取订单列表")
    @PostMapping(value = "getOrderList")
    @ResponseBody
    public CommonResult<CommonPage<OrderDO>> getOrderList(@RequestBody OrderCondition orderCondition){
        return CommonResult.success(CommonPage.restPage(orderService.getOrderList(orderCondition)),"success");
    }




}
