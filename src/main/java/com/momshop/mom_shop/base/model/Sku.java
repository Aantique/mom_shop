package com.momshop.mom_shop.base.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "sku")
public class Sku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    private BigDecimal price;

    @Column(name = "promotion_price")
    private BigDecimal promotionPrice;

    /**
     * 0是还有，1是售罄
     */
    private Integer staus;

    private Integer sales;

    private Integer stock;

    @Column(name = "sp_data")
    private String spData;

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
     * @return product_id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * @param productId
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return promotion_price
     */
    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    /**
     * @param promotionPrice
     */
    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    /**
     * 获取0是还有，1是售罄
     *
     * @return staus - 0是还有，1是售罄
     */
    public Integer getStaus() {
        return staus;
    }

    /**
     * 设置0是还有，1是售罄
     *
     * @param staus 0是还有，1是售罄
     */
    public void setStaus(Integer staus) {
        this.staus = staus;
    }

    /**
     * @return sales
     */
    public Integer getSales() {
        return sales;
    }

    /**
     * @param sales
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }

    /**
     * @return stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * @param stock
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * @return sp_data
     */
    public String getSpData() {
        return spData;
    }

    /**
     * @param spData
     */
    public void setSpData(String spData) {
        this.spData = spData;
    }
}