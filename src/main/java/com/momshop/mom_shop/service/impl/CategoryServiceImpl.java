package com.momshop.mom_shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.momshop.mom_shop.base.dao.ProductAttrDao;
import com.momshop.mom_shop.base.dao.mapper.CategoryMapper;
import com.momshop.mom_shop.base.model.Attribute;
import com.momshop.mom_shop.base.model.Category;
import com.momshop.mom_shop.domain.CateAndAttr;
import com.momshop.mom_shop.domain.CategoryDo;
import com.momshop.mom_shop.service.CategoryService;
import com.momshop.mom_shop.service.ProductAttrService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Antique
 * @Date 2022/2/21 21:22
 * @Version 1.0
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private ProductAttrDao attrDao;

    @Override
    public boolean addCateAndAttr(CateAndAttr cateAndAttr) {
        List<Attribute> attrs = cateAndAttr.getAttrs();
        Category category = cateAndAttr.getCategory();
        List<Integer> integers = new ArrayList<>();
        if (!attrs.isEmpty()) {
            attrs.forEach(attribute -> {
                attribute.setInputList(attribute.getInputList().replaceAll("，",","));
                integers.add(attrDao.addAttr(attribute));
            });
            category.setAttrIds(integers.toString().replace("[", "").replace("]", ""));
        }
        return categoryMapper.insert(category) > 0;
    }

    @Override
    public List<Category> getCategories() {
        return categoryMapper.selectAll();
    }

    @Override
    public Category getCateById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Category> getCategoriesByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return categoryMapper.selectAll();
    }

    @Override
    public boolean deleteCategoryById(Integer id) {
        return categoryMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public boolean updateCategory(Category category) {
        return categoryMapper.updateByPrimaryKey(category)>0;
    }
}
