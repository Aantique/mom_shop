package com.momshop.mom_shop.domain;

import lombok.Data;

import java.util.List;

/**
 * @Author Antique 
 * @Date 2022/2/20 21:55
 * @Version 1.0
 */
@Data
public class ProductSkuAndAttr {

    private Integer id;

    private Integer sales;

    private List<SPData> spDataList;
}
