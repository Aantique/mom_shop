package com.momshop.mom_shop.domain;

import com.momshop.mom_shop.base.model.Attribute;
import com.momshop.mom_shop.base.model.Category;
import com.momshop.mom_shop.controller.CategoryController;
import lombok.Data;

import java.util.List;

/**
 * @Author Antique
 * @Date 2022/2/25 16:46
 * @Version 1.0
 */
@Data
public class CateAndAttr {
    private Category category;
    private List<Attribute> attrs;
}
