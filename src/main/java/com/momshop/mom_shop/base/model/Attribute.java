package com.momshop.mom_shop.base.model;

import javax.persistence.*;

@Table(name = "attribute")
public class Attribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "input_list")
    private String inputList;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return input_list
     */
    public String getInputList() {
        return inputList;
    }

    /**
     * @param inputList
     */
    public void setInputList(String inputList) {
        this.inputList = inputList;
    }
}