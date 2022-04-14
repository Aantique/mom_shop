package com.momshop.mom_shop.service;

import com.momshop.mom_shop.base.model.Sku;
import com.momshop.mom_shop.domain.SkuDO;

import java.util.List;

/**
 * @Author Antique
 * @Date 2022/2/10 16:20
 * @Version 1.0
 */
public interface SkuService {

    /**
     * add
     * @param skuDO
     * @return
     */
    boolean addSku(SkuDO skuDO);

    /**
     * delete
     * @param id
     * @return
     */
    boolean deleteSku(Integer id);

    /**
     * get sku by product id
     * @param id
     * @return
     */
    List<Sku> getSkuByProductId(Integer id);

    /**
     * get sku by id
     * @param id
     * @return
     */
    Sku getSkuById(Integer id);

    /**
     * update skus
     * @param skus
     * @return
     */
    boolean updateSkus(List<Sku> skus);


    /**
     * addOrUpdateSkus
     * @param skus
     * @return
     */
    boolean addOrUpdateSkus(List<Sku> skus,Integer id);

    /**
     * add
     * @param skus
     * @return
     */
    boolean addSkus(List<Sku> skus);
}
