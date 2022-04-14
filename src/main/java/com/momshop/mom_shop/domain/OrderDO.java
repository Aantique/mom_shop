package com.momshop.mom_shop.domain;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author Antique
 * @Date 2022/1/18 18:22
 * @Version 1.0
 */
@Data
public class OrderDO {

    private Integer id;

    private Integer skuId;

    private Integer productId;

    private Integer paymentMethod;

    private BigDecimal amount;

    private String createTime;

    private String remark;

    private Integer quantity;

    private String productName;

    private String spData;

}
