package com.momshop.mom_shop.common.helper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

/**
 * @Author Antique
 * @Date 2022/1/24 22:17
 * @Version 1.0
 */
public class DaoHelper {

    public static boolean dataIsNull(Class<?> entityClass, String property, Object value, Mapper<?> mapper){
        return mapper.selectOneByExample(setEqualsExample(entityClass,property,value)) ==null;
    }

    public static Example setEqualsExample(Class<?> entityClass, String property, Object value){
        Example example = new Example(entityClass);
         example.createCriteria().andEqualTo(property,value);
         return example;
    }

    public static Example setLikeExample(Class<?> entityClass, String property, Object value){
        Example example = new Example(entityClass);
        example.createCriteria().andLike(property,(String) value);
        return example;
    }

}
