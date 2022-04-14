package com.momshop.mom_shop.service;

import com.momshop.mom_shop.base.model.Attribute;
import com.momshop.mom_shop.base.model.Sku;
import com.momshop.mom_shop.domain.AttributeDO;
import com.momshop.mom_shop.domain.CateAndAttr;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Antique
 * @Date 2022/1/18 22:27
 * @Version 1.0
 */
@Service
public interface ProductAttrService {
    /**
     * add attribute
     * @param attributes
     * @return
     */
    boolean addAttributes(List<Attribute> attributes);

    /**
     * delete attribute
     * @param id
     * @return
     */
    boolean deleteAttribute(Integer id);

    /**
     * get Attrs
     * @param ids
     * @return
     */
    List<Attribute> getAttrList(List<Integer> ids);

    /**
     * update
     * @param cateAndAttr
     * @return
     */
    Boolean updateAttrs(CateAndAttr cateAndAttr);

    List<Attribute> getAttrs();
}
