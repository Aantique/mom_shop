package com.momshop.mom_shop.base.model;

import javax.persistence.*;

@Table(name = "category")
public class Category {
    /**
     * id
     */
    @Id
    private Integer id;

    @Column(name = "attrIds")
    private String attrIds;


    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttrIds() {
        return attrIds;
    }

    public void setAttrIds(String attrIds) {
        this.attrIds = attrIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}