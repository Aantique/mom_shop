package com.momshop.mom_shop.common.aspect;

import com.momshop.mom_shop.base.dao.mapper.OperationMapper;
import com.momshop.mom_shop.base.model.Operation;
import com.momshop.mom_shop.base.model.OrderInfo;
import com.momshop.mom_shop.common.Contant;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @Author Antique
 * @Date 2022/2/18 12:14
 * @Version 1.0*/
@Aspect
@Component
@Slf4j
public class DataLogAsp {

    @Resource
    OperationMapper operationMapper;

    @Pointcut("execution(* com.momshop.mom_shop.base.dao.SkuDao.*(..))")
    public void skuRecord(){}

    @Pointcut("execution(* com.momshop.mom_shop.base.dao.OrderDao.*(..))")
    public void orderRecord(){}

    @Around(value = "skuRecord() || orderRecord()")
    public Object operateLog(ProceedingJoinPoint joinPoint) throws Throwable {
        String name = joinPoint.getSignature().getName();
        Operation operation = new Operation();
        operation.setOperation(name);
        String lowerCase = name.toLowerCase();
        if (lowerCase.contains(Contant.RecordeOpera.UPDATE) && lowerCase.contains(Contant.RecordeOpera.STOCK)){
            Integer id = (Integer) joinPoint.getArgs()[0];
            Integer stock = (Integer) joinPoint.getArgs()[1];
            boolean addOrSub = (boolean) joinPoint.getArgs()[2];
            if (addOrSub){
                operation.setResult("库存编号: " + id + "库存" + Contant.RecordeOpera.SUB + stock);
            }else {
                operation.setResult("库存编号:" + id + "库存" + Contant.RecordeOpera.ADD + stock);
            }
        }else if (lowerCase.contains(Contant.RecordeOpera.UPDATE) && lowerCase.contains("order")){
            OrderInfo order = (OrderInfo) joinPoint.getArgs()[0];
            operation.setResult("修改订单号:" + order.getId());
        }else if (lowerCase.contains(Contant.RecordeOpera.DELETE)){
            Integer id = (Integer) joinPoint.getArgs()[0];
            operation.setResult("删除单号: " + id);
        }
        operation.setCreateTime(new Date());
        if ( operation.getResult()!=null && operationMapper.insert(operation)>0){
            return joinPoint.proceed();
        }
        return joinPoint.proceed();
    }
}
