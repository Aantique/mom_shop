package com.momshop.mom_shop.common.helper;

import com.momshop.mom_shop.base.model.Product;
import com.momshop.mom_shop.common.Contant;

/**
 * @Author Antique
 * @Date 2022/2/24 14:20
 * @Version 1.0
 */
public class StockHelper {
    public static Product computeStatus(Product product,Integer stock){
        if (stock> Contant.Stock.DANGER){
            product.setStatus(Contant.Status.SAFE);
        }else if(stock> 0 && stock<=Contant.Stock.DANGER){
            product.setStatus(Contant.Status.DANGER);
        }else {
            product.setStatus(Contant.Status.SOLD_OUT);
        }
        return product;
    }
}
