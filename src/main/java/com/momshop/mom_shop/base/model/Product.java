package com.momshop.mom_shop.base.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    /**
     * 没有收录的品牌为0
     */
    @Column(name = "brand_id")
    private Integer brandId;

    /**
     * 没有分类的默认0
     */
    @Column(name = "category_id")
    private Integer categoryId;

    private BigDecimal price;

    /**
     * 默认会员价90%
     */
    @Column(name = "promotion_price")
    private BigDecimal promotionPrice;

    /**
     * 默认名字开头大小写字母
     */
    @Column(name = "key_words")
    private String keyWords;

    /**
     * 销量
     */
    private Integer sales;

    @Column(name = "brand_name")
    private String brandName;

    /**
     * 0上架,1缺货,2即将缺货
     */
    private Integer status;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取没有收录的品牌为0
     *
     * @return brand_id - 没有收录的品牌为0
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * 设置没有收录的品牌为0
     *
     * @param brandId 没有收录的品牌为0
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * 获取没有分类的默认0
     *
     * @return category_id - 没有分类的默认0
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * 设置没有分类的默认0
     *
     * @param categoryId 没有分类的默认0
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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
     * 获取默认会员价90%
     *
     * @return promotion_price - 默认会员价90%
     */
    public BigDecimal getPromotionPrice() {
        return promotionPrice;
    }

    /**
     * 设置默认会员价90%
     *
     * @param promotionPrice 默认会员价90%
     */
    public void setPromotionPrice(BigDecimal promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    /**
     * 获取默认名字开头大小写字母
     *
     * @return key_words - 默认名字开头大小写字母
     */
    public String getKeyWords() {
        return keyWords;
    }

    /**
     * 设置默认名字开头大小写字母
     *
     * @param keyWords 默认名字开头大小写字母
     */
    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    /**
     * 获取销量
     *
     * @return sales - 销量
     */
    public Integer getSales() {
        return sales;
    }

    /**
     * 设置销量
     *
     * @param sales 销量
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }

    /**
     * @return brand_name
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * @param brandName
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * 获取0上架,1缺货,2即将缺货
     *
     * @return status - 0上架,1缺货,2即将缺货
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0上架,1缺货,2即将缺货
     *
     * @param status 0上架,1缺货,2即将缺货
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return category_name
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}