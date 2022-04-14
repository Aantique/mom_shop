package com.momshop.mom_shop.common;

/**
 * @Author Antique
 * @Date 2022/2/10 13:26
 * @Version 1.0
 */
public interface Contant {
    interface PayMethod{
        int ONLINE = 0;
        int CASH = 1;
    }

    interface ModelAttr{
        String ID = "id";
        String KEYWORD = "keyWords";
        String PRODUCTID = "productId";
        String BRANDID = "brandId";
        String CATEGORYID = "categoryId";
    }

    interface RecordeOpera{
        String UPDATE = "update";
        String DELETE = "delete";
        String STOCK = "stock";
        String ADD = "+";
        String SUB  = "-";
    }

    interface Stock{
        Integer DANGER = 5;
    }

    interface Status{
       Integer SOLD_OUT=1;
       Integer SAFE=0;
       Integer DANGER=2;
    }
}
