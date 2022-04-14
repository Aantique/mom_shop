package com.momshop.mom_shop.base.dao;

import com.github.pagehelper.PageHelper;
import com.momshop.mom_shop.base.dao.mapper.SkuMapper;
import com.momshop.mom_shop.base.model.Sku;
import com.momshop.mom_shop.common.Contant;
import com.momshop.mom_shop.common.helper.DaoHelper;
import org.checkerframework.checker.units.qual.A;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author Antique
 * @Date 2022/2/10 16:10
 * @Version 1.0
 */
@Repository
public class SkuDao {
    @Resource
    private SkuMapper skuMapper;

    public boolean addSku(Sku sku){
        return skuMapper.insert(sku) > 0;
    }

    public boolean deleteSku(Integer id){
        return skuMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * addOrSub true则为添加，false则为减少
     * @param id
     * @param stock
     * @param addOrSub
     * @return
     */
    public boolean updateSkuStock(Integer id,Integer stock,boolean addOrSub){
        Sku sku = skuMapper.selectByPrimaryKey(id);
        if (addOrSub){
            sku.setStock(sku.getStock() - stock);
        }else {
            sku.setStock(sku.getStock() + stock);
        }
        return skuMapper.updateByExampleSelective(sku,DaoHelper.setEqualsExample(Sku.class,Contant.ModelAttr.ID,id))>0;
    }

    public Sku getSkuById(Integer id){
        return skuMapper.selectByPrimaryKey(id);
    }

    public List<Sku> getSkuList(){
        return skuMapper.selectAll();
    }

    public List<Sku> getSkusByProduct(Integer productId,Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return skuMapper.selectByExample(DaoHelper.setEqualsExample(Sku.class, Contant.ModelAttr.PRODUCTID,productId));
    }

    public List<Sku> getSkusByProduct(Integer productId){
        return skuMapper.selectByExample(DaoHelper.setEqualsExample(Sku.class, Contant.ModelAttr.PRODUCTID,productId));
    }

    public boolean updateSkus(List<Sku> skus){
        AtomicBoolean b = new AtomicBoolean(true);
        skus.forEach(sku -> b.set(skuMapper.updateByPrimaryKey(sku) > 0 && b.get()));
        return b.get();
    }

    public boolean addSkus(List<Sku> skus){
        AtomicBoolean b = new AtomicBoolean(true);
        skus.forEach(sku->b.set(skuMapper.insert(sku)>0&&b.get()));
        return b.get();
    }

    public boolean addOrUpdateSkus(List<Sku> skus,Integer id){
        if (!skus.isEmpty()){
            AtomicBoolean b = new AtomicBoolean(true);
            Example example = new Example(Sku.class);
            example.createCriteria().andEqualTo("productId",id);
            skuMapper.deleteByExample(example);
            skus.forEach(sku->{
                if (sku.getProductId()==null){
                    sku.setProductId(id);
                }
                b.set(b.get() && skuMapper.insert(sku)>0);
            });
            return b.get();
        }
        return false;
    }
}
