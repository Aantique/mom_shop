package com.momshop.mom_shop.base.dao;

import com.momshop.mom_shop.base.dao.mapper.AttributeMapper;
import com.momshop.mom_shop.base.model.Attribute;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Antique
 * @Date 2022/2/10 15:05
 * @Version 1.0
 */
@Repository
public class ProductAttrDao {

    @Resource
    private AttributeMapper attributeMapper;

    public Integer addAttr(Attribute attribute){
        attributeMapper.insert(attribute);
        return  attribute.getId();
    }

    public boolean deleteAttr(Integer id){
        return attributeMapper.deleteByPrimaryKey(id) > 0;
    }

    public List<Attribute> getAttrsById(List<Integer> ids){
        Example example = new Example(Attribute.class);
        example.createCriteria().andIn("id",ids);
        return attributeMapper.selectByExample(example);
    }

    public boolean updateAttrById(Attribute attribute){
        return attributeMapper.updateByPrimaryKey(attribute)>0;
    }

    public List<Attribute> getAttrs(){
        return attributeMapper.selectAll();
    }

}
