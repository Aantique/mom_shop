package com.momshop.mom_shop.controller;

import com.momshop.mom_shop.base.model.Product;
import com.momshop.mom_shop.common.api.CommonPage;
import com.momshop.mom_shop.common.api.CommonResult;
import com.momshop.mom_shop.common.helper.ResultHelper;
import com.momshop.mom_shop.domain.ProductCondition;
import com.momshop.mom_shop.domain.ProductDO;
import com.momshop.mom_shop.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Antique
 * @Date 2022/2/10 14:10
 * @Version 1.0
 */
@RestController
@RequestMapping("/product")
@Api(tags = "ProductController")
public class ProductController {
    @Resource
    private ProductService productService;

    @ApiOperation("增加商品")
    @PostMapping(value = "add")
    @ResponseBody
    public CommonResult addProduct(@RequestBody ProductDO product){
        return ResultHelper.checkData(productService.addProduct(product));
    }

    @ApiOperation("修改商品")
    @PostMapping(value = "update")
    @ResponseBody
    public CommonResult updateProduct(@RequestBody ProductDO productDO){
        return ResultHelper.checkData(productService.updateProduct(productDO));
    }

    @ApiOperation("按关键字/品牌/分类获取商品")
    @PostMapping(value = "getProductsByCondition")
    @ResponseBody
    public CommonResult<CommonPage> getProductListByCondition(@RequestBody ProductCondition condition){
        return CommonResult.success(CommonPage.restPage(productService.getProductListByCondition(condition)),"success");
    }



    @ApiOperation("删除商品")
    @GetMapping(value = "deleteProduct/{id}")
    public CommonResult deleteProduct(@PathVariable Integer id){
        return ResultHelper.checkData(productService.deleteProduct(id));
    }

    @ApiOperation("获得商品列表")
    @GetMapping(value = "getProducts")
    @ResponseBody
    public CommonResult<CommonPage> getProductList(@RequestParam(required = false, defaultValue = "0") Integer pageNum
            , @RequestParam(required = false, defaultValue = "5") Integer pageSize){
        return CommonResult.success(CommonPage.restPage(productService.getProductList(pageNum,pageSize)),"success");
    }

    @ApiOperation("根据id获得商品")
    @GetMapping(value = "getProductById/{id}")
    @ResponseBody
    public CommonResult<Product> getProductById(@PathVariable Integer id){
        return CommonResult.success(productService.getProductById(id),"success");
    }



}
