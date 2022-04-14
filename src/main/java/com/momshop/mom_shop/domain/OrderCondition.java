package com.momshop.mom_shop.domain;

import lombok.Data;

import java.util.List;

/**
 * @Author Antique
 * @Date 2022/2/26 21:40
 * @Version 1.0
 */
@Data
public class OrderCondition {
    private String name;
    private Integer pageNum;
    private Integer pageSize;
    private List<String> time;
}
