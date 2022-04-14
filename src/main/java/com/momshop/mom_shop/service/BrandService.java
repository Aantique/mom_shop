package com.momshop.mom_shop.service;

import com.momshop.mom_shop.base.model.Brand;

import java.util.List;

/**
 * @Author Antique
 * @Date 2022/2/17 22:28
 * @Version 1.0
 */
public interface BrandService {

    /**
     * add
     * @param brand
     * @return
     */
    boolean addBrand(Brand brand);

    /**
     * delete
     * @param id
     * @return
     */
    boolean deleteBrand(Integer id);


    /**
     * update
     * @param brand
     * @return
     */
    boolean updateBrand(Brand brand);

    /**
     * get brand
     * @param id
     * @return
     */
    Brand getBrandById(Integer id);

    /**
     * get list
     * @return
     */
    List<Brand> getBrandsByPage(Integer pageNum, Integer pageSize);

    /**
     * get all
     * @return
     */
    List<Brand> getBrands();

}
