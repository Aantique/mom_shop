package com.momshop.mom_shop.domain;

import lombok.Data;

import java.util.List;

/**
 * @Author Antique
 * @Date 2022/1/18 18:34
 * @Version 1.0
 */
@Data
public class AttributeDO {

    private Integer id;
    private String name;
    private List<String> inputList;
}
