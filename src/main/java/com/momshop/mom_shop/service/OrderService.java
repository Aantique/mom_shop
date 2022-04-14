package com.momshop.mom_shop.service;


import com.github.pagehelper.PageInfo;
import com.momshop.mom_shop.base.model.OrderInfo;
import com.momshop.mom_shop.domain.OrderCondition;
import com.momshop.mom_shop.domain.OrderDO;
import com.momshop.mom_shop.domain.TimeFrame;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.annotation.Order;

import java.util.List;

/**
 * @Author Antique
 * @Date 2022/1/18 18:24
 * @Version 1.0
 */

public interface OrderService {

    /**
     * 添加订单
     * @param order
     * @return
     */
    boolean addOrder(OrderInfo order);

    /**
     * update
     * @param orderInfo
     * @return
     */
    boolean updateOrder(OrderInfo orderInfo);

    /**
     * 删除订单
     * @param order
     * @return
     */
    boolean deleteOrder(OrderDO order);

    /**
     * get list
     * @param orderCondition
     * @return
     */
    PageInfo<OrderDO> getOrderList(OrderCondition orderCondition);

    /**
     * id get order
     * @param id
     * @return
     */
    OrderInfo getOrderInfoById(Integer id);

    /**
     * 获取时间段内的订单
     * @param timeFrame
     * @return
     */
    List<OrderInfo> getOrderInfoByTime(TimeFrame timeFrame);



}
