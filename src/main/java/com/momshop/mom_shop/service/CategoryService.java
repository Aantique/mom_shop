package com.momshop.mom_shop.service;

import com.momshop.mom_shop.base.model.Category;
import com.momshop.mom_shop.domain.CateAndAttr;

import java.util.List;

/**
 * @Author Antique
 * @Date 2022/2/21 21:22
 * @Version 1.0
 */
public interface CategoryService {

    /**
     * add
     * @param cateAndAttr
     * @return
     */
    boolean addCateAndAttr(CateAndAttr cateAndAttr);

    /**
     * get all
     * @return
     */
    List<Category> getCategories();

    /**
     * get by id
     * @param id
     * @return
     */
    Category getCateById(Integer id);


    /**
     * get by page
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Category> getCategoriesByPage(Integer pageNum,Integer pageSize);

    /**
     * delete
     * @param id
     * @return
     */
    boolean deleteCategoryById(Integer id);

    /**
     * update
     * @param category
     * @return
     */
    boolean updateCategory(Category category);
}
