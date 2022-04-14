package com.momshop.mom_shop.controller;

import com.momshop.mom_shop.base.model.Brand;
import com.momshop.mom_shop.common.api.CommonPage;
import com.momshop.mom_shop.common.api.CommonResult;
import com.momshop.mom_shop.common.helper.ResultHelper;
import com.momshop.mom_shop.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Antique
 * @Date 2022/2/17 22:40
 * @Version 1.0
 */
@Api(tags = "brand")
@RestController()
@RequestMapping("/brand")
public class BrandController {

    @Resource
    BrandService brandService;

    @ApiOperation("删除brand")
    @GetMapping(value = "delete/{id}")
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable Integer id){
        return ResultHelper.checkData(brandService.deleteBrand(id));
    }

    @ApiOperation("添加brand")
    @PostMapping(value = "add")
    @ResponseBody
    public CommonResult addBrand(@RequestBody Brand brand){
        return ResultHelper.checkData(brandService.addBrand(brand));
    }

    @ApiOperation("更新brand")
    @PostMapping(value = "update")
    @ResponseBody
    public CommonResult updateBrand(@RequestBody Brand brand){
        return ResultHelper.checkData(brandService.updateBrand(brand));
    }


    @ApiOperation("按页获得品牌列表")
    @PostMapping(value = "getBrandsByPage")
    @ResponseBody
    public CommonResult<CommonPage> getBrandsByPage(@RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                               @RequestParam(required = false, defaultValue = "5") Integer pageSize){
        return CommonResult.success(CommonPage.restPage(brandService.getBrandsByPage(pageNum,pageSize)),"success");
    }

    @ApiOperation("获得品牌列表")
    @GetMapping(value = "getBrands")
    @ResponseBody
    public CommonResult getBrands(){
        return CommonResult.success(brandService.getBrands(),"success");
    }
}
