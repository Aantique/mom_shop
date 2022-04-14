package com.momshop.mom_shop.service;

import com.momshop.mom_shop.base.model.Product;
import com.momshop.mom_shop.domain.ProductCondition;
import com.momshop.mom_shop.domain.ProductDO;
import com.momshop.mom_shop.domain.ProductSkuAndAttr;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Antique
 * @Date 2022/1/18 22:24
 * @Version 1.0
 */
@Service
public interface ProductService {

    /**
     * add
     * @param productDO
     * @return
     */
    Boolean addProduct(ProductDO productDO);

    /**
     * pdate
     * @param product
     * @return
     */
    boolean updateProduct(ProductDO product);


    /**
     * get Product list
     * @param condition
     * @return
     */
    List<Product> getProductListByCondition(ProductCondition condition);

    /**
     * delete product
     * @param id
     * @return
     */
    boolean deleteProduct(Integer id);

    /**
     * get list
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Product> getProductList(Integer pageNum,Integer pageSize);

    /**
     * get by id
     * @param id
     * @return
     */
    Product getProductById(Integer id);

}
