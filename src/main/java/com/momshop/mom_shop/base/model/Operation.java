package com.momshop.mom_shop.base.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 结果
     */
    private String result;

    /**
     * 对数据库的操作
     */
    private String operation;

    @Column(name = "create_time")
    private Date createTime;

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
     * 获取结果
     *
     * @return result - 结果
     */
    public String getResult() {
        return result;
    }

    /**
     * 设置结果
     *
     * @param result 结果
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * 获取对数据库的操作
     *
     * @return operation - 对数据库的操作
     */
    public String getOperation() {
        return operation;
    }

    /**
     * 设置对数据库的操作
     *
     * @param operation 对数据库的操作
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}