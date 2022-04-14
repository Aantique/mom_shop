package com.momshop.mom_shop.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

/**
 * @Author Antique
 * @Date 2022/2/24 0:18
 * @Version 1.0
 */
@Data
public class CategoryDo {
    private Integer id;


    private List<String> attrIds;


    private String name;

}
