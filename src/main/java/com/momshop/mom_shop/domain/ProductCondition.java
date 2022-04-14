package com.momshop.mom_shop.domain;

import lombok.Data;

/**
 * @Author Antique
 * @Date 2022/2/21 22:26
 * @Version 1.0
 */
@Data
public class ProductCondition {
    private Integer brandId;
    private Integer categoryId;
    private Integer pageNum;
    private Integer pageSize;
    private String name;
    private String keyword;
}
