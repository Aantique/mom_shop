package com.momshop.mom_shop.common.helper;

import com.momshop.mom_shop.common.api.CommonResult;

import java.util.List;

/**
 * @Author Antique
 * @Date 2022/2/10 14:37
 * @Version 1.0
 */
public class ResultHelper {
    public static CommonResult checkData(boolean b){
        if (b){
            return CommonResult.success("success");
        }else {
            return CommonResult.failed();
        }
    }

    public static CommonResult<Object> checkDataAndResponse(boolean b, Object data){
        if (b){
            return CommonResult.success(data,"success");
        }else {
            return CommonResult.failed();
        }
    }
}
