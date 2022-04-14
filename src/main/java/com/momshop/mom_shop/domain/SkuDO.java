package com.momshop.mom_shop.domain;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Antique
 * @Date 2022/2/10 16:21
 * @Version 1.0
 */
@Data
public class SkuDO {
    private Integer id;

    private Integer productId;

    private BigDecimal price;

    private BigDecimal promotionPrice;

    private Integer stock;

    private List<SPData> spData;
}
