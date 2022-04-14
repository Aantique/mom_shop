package com.momshop.mom_shop.base.dao;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.momshop.mom_shop.base.dao.mapper.DailyIncomeMapper;
import com.momshop.mom_shop.base.dao.mapper.OrderInfoMapper;
import com.momshop.mom_shop.base.dao.mapper.ProductMapper;
import com.momshop.mom_shop.base.model.DailyIncome;
import com.momshop.mom_shop.base.model.OrderInfo;
import com.momshop.mom_shop.domain.OrderCondition;
import com.momshop.mom_shop.domain.OrderDO;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author Antique
 * @Date 2022/1/24 20:23
 * @Version 1.0
 */
@Repository
public class OrderDao {

    @Resource
    private OrderInfoMapper orderInfoMapper;

    private Date parseToDate(String s){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        return formatter.parse(s, pos);
    }

    private Date addDate(String s){
        Date date = parseToDate(s);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY,23);
        calendar.add(Calendar.MINUTE,59);
        calendar.add(Calendar.MILLISECOND,59);
        return calendar.getTime();
    }

    public boolean addOrder(OrderInfo orderInfo) {

        return orderInfoMapper.insert(orderInfo) > 0;
    }

    public boolean updateOrder(OrderInfo orderInfo) {
        return orderInfoMapper.updateByPrimaryKey(orderInfo) > 0;
    }

    public boolean deleteOrder(Integer id) {
        return orderInfoMapper.deleteByPrimaryKey(id) > 0;
    }

    public PageInfo<OrderInfo> getOrderList(OrderCondition orderCondition) {
        PageHelper.startPage(orderCondition.getPageNum(), orderCondition.getPageSize());
        if (orderCondition.getName()!=null || orderCondition.getTime()!=null){
            Example example = new Example(OrderInfo.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("productName", orderCondition.getName());
            Optional.ofNullable(orderCondition.getTime()).ifPresent(time->{
                if (!time.isEmpty()){
                    criteria.andGreaterThanOrEqualTo("createTime",parseToDate(time.get(0)));
                    criteria.andLessThanOrEqualTo("createTime",addDate(time.get(1)));
                }
            });
           return new PageInfo<>(orderInfoMapper.selectByExample(example));
        }
        return new PageInfo<>(orderInfoMapper.selectAll());
    }

    public OrderInfo getOrderInfoById(Integer id) {
        return orderInfoMapper.selectByPrimaryKey(id);
    }

    public List<OrderInfo> getOrderInfoByTime(Date start, Date end) {
        Example example = new Example(OrderInfo.class);
        example.createCriteria().andBetween("updateTime", start, end);
        return orderInfoMapper.selectByExample(example);
    }


}
