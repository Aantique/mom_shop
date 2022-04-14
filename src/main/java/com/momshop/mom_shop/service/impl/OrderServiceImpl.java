package com.momshop.mom_shop.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.momshop.mom_shop.base.dao.OrderDao;
import com.momshop.mom_shop.base.dao.SkuDao;
import com.momshop.mom_shop.base.model.OrderInfo;
import com.momshop.mom_shop.domain.OrderCondition;
import com.momshop.mom_shop.domain.OrderDO;
import com.momshop.mom_shop.domain.TimeFrame;
import com.momshop.mom_shop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

/**
 * @Author Antique
 * @Date 2022/1/18 18:24
 * @Version 1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private SkuDao skuDao;

    @Override
    public boolean addOrder(OrderInfo order) {
        return orderDao.addOrder(order) && skuDao.updateSkuStock(order.getSkuId(), order.getQuantity(),true);
    }

    @Override
    public boolean updateOrder(OrderInfo orderInfo) {
        return orderDao.updateOrder(orderInfo);
    }

    @Override
    public boolean deleteOrder(OrderDO order) {
        return orderDao.deleteOrder(order.getId()) && skuDao.updateSkuStock(order.getSkuId(), order.getQuantity(),false);
    }

    @Override
    public PageInfo<OrderDO> getOrderList(OrderCondition orderCondition) {
        PageInfo<OrderInfo> orderList = orderDao.getOrderList(orderCondition);
        List<OrderDO> orderDOS = new ArrayList<>();
        PageInfo<OrderDO> info = new PageInfo<>();
        BeanUtils.copyProperties(orderList,info);
        orderList.getList().forEach(order->{
            OrderDO orderDO = new OrderDO();
            BeanUtils.copyProperties(order,orderDO);
            SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
            sformat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            String s = sformat.format(order.getCreateTime());
            orderDO.setCreateTime(s);
            orderDOS.add(orderDO);
        });
        info.setList(orderDOS);
        return info;
    }

    @Override
    public OrderInfo getOrderInfoById(Integer id) {
        return orderDao.getOrderInfoById(id);
    }

    @Override
    public List<OrderInfo> getOrderInfoByTime(TimeFrame timeFrame) {
        return orderDao.getOrderInfoByTime(timeFrame.getStart(), timeFrame.getEnd());
    }

}
