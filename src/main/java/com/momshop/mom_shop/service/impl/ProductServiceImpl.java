package com.momshop.mom_shop.service.impl;

import com.momshop.mom_shop.base.dao.ProductDao;
import com.momshop.mom_shop.base.dao.SkuDao;
import com.momshop.mom_shop.base.model.Product;
import com.momshop.mom_shop.base.model.Sku;
import com.momshop.mom_shop.common.Contant;
import com.momshop.mom_shop.common.helper.StockHelper;
import com.momshop.mom_shop.domain.ProductCondition;
import com.momshop.mom_shop.domain.ProductDO;
import com.momshop.mom_shop.domain.ProductSkuAndAttr;
import com.momshop.mom_shop.service.ProductService;
import com.momshop.mom_shop.service.SkuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Antique
 * @Date 2022/1/18 22:29
 * @Version 1.0
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao productDao;

    @Resource
    private SkuService skuService;


    @Override
    public Boolean addProduct(ProductDO productDO) {
        Product product = productDO.getProduct();
        product.setCreateTime(new Date());
        product.setUpdateTime(new Date());
        product.setSales(0);
        List<Sku> skus = productDO.getSkus();
        Integer reduce = skus.stream().map(Sku::getStock).reduce(0, Integer::sum);
        Integer integer = productDao.addProduct(StockHelper.computeStatus(product,reduce));
        if (integer>0){
            skus.forEach(sku -> sku.setProductId(integer));
        }
        return skuService.addSkus(skus);
    }

    @Override
    public boolean updateProduct(ProductDO productDO) {
        List<Sku> skus = productDO.getSkus();
        Product product = productDO.getProduct();
        Integer reduce = skus.stream().map(Sku::getStock).reduce(0, Integer::sum);
        if (productDao.updateProduct(StockHelper.computeStatus(product,reduce))){
            return skuService.addOrUpdateSkus(skus,product.getId());
        }
        return false;
    }

    @Override
    public List<Product> getProductListByCondition(ProductCondition condition) {
        Product product = new Product();
        product.setBrandId(condition.getBrandId());
        product.setCategoryId(condition.getCategoryId());
        product.setKeyWords(condition.getKeyword());
        product.setName(condition.getName());
        return  productDao.getProductByCondition(product,condition.getPageNum(), condition.getPageSize());
    }

    @Override
    public boolean deleteProduct(Integer id) {
        return productDao.deleteProduct(id);
    }

    @Override
    public List<Product> getProductList(Integer pageNum, Integer pageSize) {
        return productDao.getProductList(pageNum, pageSize);
    }

    @Override
    public Product getProductById(Integer id) {
        return productDao.getProductById(id);
    }
}
