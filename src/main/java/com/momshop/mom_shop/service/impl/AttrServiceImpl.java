package com.momshop.mom_shop.service.impl;

import com.google.common.base.Strings;
import com.momshop.mom_shop.base.dao.ProductAttrDao;
import com.momshop.mom_shop.base.model.Attribute;
import com.momshop.mom_shop.base.model.Category;
import com.momshop.mom_shop.domain.AttributeDO;
import com.momshop.mom_shop.domain.CateAndAttr;
import com.momshop.mom_shop.service.CategoryService;
import com.momshop.mom_shop.service.ProductAttrService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author Antique
 * @Date 2022/2/10 15:14
 * @Version 1.0
 */
@Service
public class AttrServiceImpl implements ProductAttrService {

    @Resource
    private ProductAttrDao attrDao;

    @Resource
    private CategoryService categoryService;

    private Attribute converterAttr(AttributeDO attributeDO){
        Attribute attribute = new Attribute();
        attribute.setId(attributeDO.getId());
        attribute.setName(attributeDO.getName());
        attribute.setInputList(String.join(",",attributeDO.getInputList()));
        return attribute;
    }



    @Override
    public boolean addAttributes(List<Attribute> attributes) {
        AtomicBoolean b = new AtomicBoolean(true);
        attributes.forEach(attribute -> b.set(attrDao.addAttr(attribute)>0 && b.get()));
        return b.get();
    }

    @Override
    public boolean deleteAttribute(Integer id) {
        return attrDao.deleteAttr(id);
    }

    @Override
    public List<Attribute> getAttrList(List<Integer> ids) {
        return attrDao.getAttrsById(ids);
    }

    @Override
    public Boolean updateAttrs(CateAndAttr cateAndAttr) {
        List<Attribute> attributes = cateAndAttr.getAttrs();
        AtomicBoolean b = new AtomicBoolean(true);
        Category category = cateAndAttr.getCategory();
        List<Integer> list = new ArrayList<>();
        attributes.forEach(attribute -> {
            attribute.setInputList(attribute.getInputList().replace("，",","));
            if (attribute.getId()!=null){
                b.set(attrDao.updateAttrById(attribute) && b.get());
            }else {
                b.set(attrDao.addAttr(attribute)>0 && b.get());
            }
            list.add(attribute.getId());
        });
        category.setAttrIds(list.toString().replace("[","").replace("]",""));
        b.set(categoryService.updateCategory(category) && b.get());
        return b.get();
    }

    @Override
    public List<Attribute> getAttrs() {
        return attrDao.getAttrs();
    }
}
