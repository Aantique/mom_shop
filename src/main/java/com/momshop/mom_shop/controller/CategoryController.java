package com.momshop.mom_shop.controller;

import com.github.pagehelper.Page;
import com.momshop.mom_shop.base.model.Category;
import com.momshop.mom_shop.common.api.CommonPage;
import com.momshop.mom_shop.common.api.CommonResult;
import com.momshop.mom_shop.common.helper.ResultHelper;
import com.momshop.mom_shop.domain.CateAndAttr;
import com.momshop.mom_shop.service.CategoryService;
import com.momshop.mom_shop.service.ProductAttrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Antique
 * @Date 2022/2/21 21:24
 * @Version 1.0
 */
@Api(tags = "分类")
@RestController
@RequestMapping(value = "/cate")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @Resource
    private ProductAttrService attrService;

    @ApiOperation("获得分类列表")
    @GetMapping(value = "getCategories")
    @ResponseBody
    public CommonResult<List<Category>> getCategories(){
        return CommonResult.success(categoryService.getCategories(),"success");
    }

    @ApiOperation("获得分类列表分页")
    @GetMapping(value = "getCategoriesByPage")
    @ResponseBody
    public CommonResult<CommonPage<Category>> getCategoriesByPage(@RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                            @RequestParam(required = false, defaultValue = "5") Integer pageSize){
        return CommonResult.success(CommonPage.restPage(categoryService.getCategoriesByPage(pageNum, pageSize)),"success");
    }


    @ApiOperation("根据Id获得分类")
    @GetMapping(value = "getCateById/{id}")
    @ResponseBody
    public CommonResult<Category> getCateById(@PathVariable Integer id){
        return CommonResult.success(categoryService.getCateById(id),"success");
    }

    @ApiOperation("根据Id删除分类")
    @GetMapping(value = "deleteCateById/{id}")
    @ResponseBody
    public CommonResult deleteCateById(@PathVariable Integer id){
        return CommonResult.success(categoryService.deleteCategoryById(id),"success");
    }

    @ApiOperation("根据Id更新")
    @PostMapping(value = "updateCateById")
    @ResponseBody
    public CommonResult updateCateById(@RequestBody CateAndAttr cateAndAttr){
        return ResultHelper.checkData(attrService.updateAttrs(cateAndAttr));
    }

    @ApiOperation("添加分类")
    @PostMapping(value = "addCateAndAttr")
    @ResponseBody
    public CommonResult addCateAndAttr(@RequestBody CateAndAttr cateAndAttr){
        return ResultHelper.checkData(categoryService.addCateAndAttr(cateAndAttr));
    }
}
