package com.momshop.mom_shop.controller;

import com.momshop.mom_shop.base.model.Sku;
import com.momshop.mom_shop.common.api.CommonPage;
import com.momshop.mom_shop.common.api.CommonResult;
import com.momshop.mom_shop.common.helper.ResultHelper;
import com.momshop.mom_shop.domain.SkuDO;
import com.momshop.mom_shop.service.SkuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Antique
 * @Date 2022/2/17 21:26
 * @Version 1.0
 */
@RestController
@Api(tags = "SkuController")
@RequestMapping("/sku")
public class SkuController {

    @Resource
    SkuService skuService;

    @ApiOperation("增加sku")
    @PostMapping(value = "add")
    @ResponseBody
    public CommonResult addSku(@RequestBody SkuDO skuDO){
        return ResultHelper.checkData(skuService.addSku(skuDO));
    }

    @ApiOperation("删除sku")
    @GetMapping(value = "delete/{id}")
    public CommonResult deleteSku(@PathVariable Integer id){
        return ResultHelper.checkData(skuService.deleteSku(id));
    }

    @ApiOperation("通过商品id查看商品库存")
    @GetMapping(value = "getByProductId/{id}")
    @ResponseBody
    public CommonResult<List<Sku>> getSkuByProductId(@PathVariable Integer id){
        return CommonResult.success((skuService.getSkuByProductId(id)),"success");
    }

    @ApiOperation("通过id查看sku")
    @GetMapping(value = "getById/{id}")
    @ResponseBody
    public CommonResult<Sku> getSkuById(@PathVariable Integer id){
        return CommonResult.success(skuService.getSkuById(id),"success");
    }

    @ApiOperation("批量更新skus")
    @PostMapping(value = "updateSkus")
    @ResponseBody
    public CommonResult updateSkus(@RequestBody List<Sku> skus){
        return  ResultHelper.checkData(skuService.updateSkus(skus));
    }

    @ApiOperation("批量添加skus")
    @PostMapping(value = "addSkus")
    @ResponseBody
    public CommonResult addSkus(@RequestBody List<Sku> skus){
        return  ResultHelper.checkData(skuService.addSkus(skus));
    }


}
