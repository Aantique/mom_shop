package com.momshop.mom_shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.momshop.mom_shop.base.dao.ProductDao;
import com.momshop.mom_shop.base.dao.SkuDao;
import com.momshop.mom_shop.base.model.Product;
import com.momshop.mom_shop.base.model.Sku;
import com.momshop.mom_shop.common.helper.StockHelper;
import com.momshop.mom_shop.domain.SkuDO;
import com.momshop.mom_shop.service.SkuService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Antique
 * @Date 2022/2/10 16:33
 * @Version 1.0
 */
@Service
public class SkuServiceImpl implements SkuService {

    @Resource
    private SkuDao skuDao;

    @Resource
    private ProductDao productDao;

    private Sku converterSku(SkuDO skuDO){
        Sku sku = new Sku();
        /*List<Map<String,String>> mapList = new ArrayList<>();
        data.forEach(spData -> {
            Map<String,String> map = new HashMap<>();
            map.put(spData.getKey(),spData.getValue());
            mapList.add(map);
        });*/
        sku.setSpData(JSON.toJSONString(skuDO.getSpData()));
        System.out.println(JSON.toJSONString(skuDO.getSpData()));
        BeanUtils.copyProperties(skuDO,sku);
        return sku;
    }

    @Override
    public boolean addSku(SkuDO skuDO) {
        return skuDao.addSku(converterSku(skuDO));
    }

    @Override
    public boolean deleteSku(Integer id) {
        return skuDao.deleteSku(id);
    }

    @Override
    public List<Sku> getSkuByProductId(Integer id) {
        return skuDao.getSkusByProduct(id);
    }

    @Override
    public Sku getSkuById(Integer id) {
        return skuDao.getSkuById(id);
    }

    @Override
    public boolean updateSkus(List<Sku> skus) {
        if (!skus.isEmpty() && skuDao.updateSkus(skus)){
            Product product = new Product();
            product.setId(skus.get(0).getProductId());
            Integer reduce = skus.stream().map(Sku::getStock).reduce(0, Integer::sum);
            return productDao.updateStatus(StockHelper.computeStatus(product, reduce));
        }
        return false;
    }

    @Override
    public boolean addOrUpdateSkus(List<Sku> skus,Integer id) {
        return skuDao.addOrUpdateSkus(skus,id);
    }

    @Override
    public boolean addSkus(List<Sku> skus) {
        if (!skus.isEmpty() && skuDao.addSkus(skus)){
            Product product = new Product();
            product.setId(skus.get(0).getProductId());
            Integer reduce = skus.stream().map(Sku::getStock).reduce(0, Integer::sum);
            return productDao.updateStatus(StockHelper.computeStatus(product,reduce));
        }
        return false;
    }
}
