package com.momshop.mom_shop.domain;

import com.momshop.mom_shop.base.model.Product;
import com.momshop.mom_shop.base.model.Sku;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author Antique
 * @Date 2022/1/18 18:32
 * @Version 1.0
 */
@Data
public class ProductDO {
    private Product product;

    private List<Sku> skus;

}
