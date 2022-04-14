package com.momshop.mom_shop.base.dao;

import com.github.pagehelper.PageHelper;
import com.momshop.mom_shop.base.dao.mapper.ProductMapper;
import com.momshop.mom_shop.base.model.OrderInfo;
import com.momshop.mom_shop.base.model.Product;
import com.momshop.mom_shop.common.Contant;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.momshop.mom_shop.common.helper.DaoHelper.*;

/**
 * @Author Antique
 * @Date 2022/2/10 13:23
 * @Version 1.0
 */
@Repository
public class ProductDao {

    @Resource
    private ProductMapper productMapper;


    public boolean updateProduct(Product product) {
        return productMapper.updateByPrimaryKey(product) > 0;
    }

    public boolean updateStatus(Product product){
        return productMapper.updateByPrimaryKeySelective(product)>0;
    }

    public Integer addProduct(Product product){
        if (productMapper.insert(product)>0){
            return product.getId();
        }
        return 0;
    }

    public boolean deleteProduct(Integer id) {
        return productMapper.deleteByPrimaryKey(id) > 0;
    }

    public Product getProductById(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    public List<Product> getProductByCondition(Product product, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Example example = new Example(Product.class);
        Example.Criteria criteria = example.createCriteria();
        if (!Objects.isNull(product.getCategoryId())) {
            criteria.andEqualTo("categoryId", product.getCategoryId());
        } else if (!Objects.isNull(product.getBrandId())) {
            criteria.andEqualTo("brandId", product.getBrandId());
        } else if (!Objects.isNull(product.getName()) && !product.getName().isEmpty()) {
            criteria.andLike("name", product.getName());
        } else if (!Objects.isNull(product.getKeyWords()) && !product.getKeyWords().isEmpty()) {
            criteria.andLike("keyWords", product.getKeyWords());
        } else {
            return productMapper.selectAll();
        }
        return productMapper.selectByExample(example);
    }

    public List<Product> getProductList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return productMapper.selectAll();
    }


}
