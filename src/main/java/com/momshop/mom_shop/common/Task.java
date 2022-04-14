package com.momshop.mom_shop.common;

import com.momshop.mom_shop.base.dao.mapper.DailyIncomeMapper;
import com.momshop.mom_shop.base.dao.mapper.OrderInfoMapper;
import com.momshop.mom_shop.base.model.DailyIncome;
import com.momshop.mom_shop.base.model.OrderInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.beans.FeatureDescriptor;
import java.math.BigDecimal;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author Antique
 * @Date 2022/3/2 14:41
 * @Version 1.0
 */
@Slf4j
@Component
public class Task {

    @Resource
    private OrderInfoMapper orderInfoMapper;
    @Resource
    private DailyIncomeMapper dailyIncomeMapper;

    @Scheduled(cron = "0 0 21 * * *")
    public void setDailyIncome(){
        Date date = new Date();
        Example example = new Example(OrderInfo.class);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.roll(Calendar.HOUR_OF_DAY,21);
        example.createCriteria()
                .andLessThanOrEqualTo("createTime",date)
                        .andGreaterThanOrEqualTo("createTime",calendar.getTime());
        List<OrderInfo> orderInfos = orderInfoMapper.selectByExample(example);
        Optional<BigDecimal> reduce = orderInfos.stream().map(OrderInfo::getAmount).reduce(BigDecimal::add);
        DailyIncome dailyIncome = new DailyIncome();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        dailyIncome.setIncome(reduce.orElse(new BigDecimal(0)));
        dailyIncome.setDate(sdf.format(date));
        if (dailyIncomeMapper.insert(dailyIncome) > 0){
            log.info("set daily income success , income:{}",reduce.orElse(new BigDecimal(0)));
        }
    }
}
