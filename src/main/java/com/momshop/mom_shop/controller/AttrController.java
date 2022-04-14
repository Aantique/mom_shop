package com.momshop.mom_shop.controller;

import com.momshop.mom_shop.base.model.Attribute;
import com.momshop.mom_shop.common.api.CommonResult;
import com.momshop.mom_shop.common.helper.ResultHelper;
import com.momshop.mom_shop.domain.AttributeDO;
import com.momshop.mom_shop.service.ProductAttrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Author Antique
 * @Date 2022/2/10 15:55
 * @Version 1.0
 */
@RestController
@Api(tags = "attrController")
@RequestMapping("/attr")
public class AttrController {

    @Resource
    private ProductAttrService attrService;

    @ApiOperation("增加属性")
    @PostMapping(value = "addAttr")
    @ResponseBody
    public CommonResult addAttr(@RequestBody  List<Attribute> attributes){
        return ResultHelper.checkData(attrService.addAttributes(attributes));
    }

    @ApiOperation("获得全部属性")
    @GetMapping(value = "getAttrs")
    @ResponseBody
    public CommonResult getAttrs(){
        return CommonResult.success(attrService.getAttrs(),"success");
    }

    /*@ApiOperation("批量更新或者插入属性")
    @PostMapping(value = "updateAttrs")
    @ResponseBody
    public CommonResult updateAttrs(@RequestBody List<Attribute> attributes){
        attributes.forEach(attr-> attr.setInputList(attr.getInputList().replace("，",",")));
        return ResultHelper.checkData(attrService.updateAttrs(attributes));
    }*/

    @ApiOperation("删除属性")
    @PostMapping(value = "deleteAttr")
    @ResponseBody
    public CommonResult deleteAttr(@RequestParam Integer id){
        return ResultHelper.checkData(attrService.deleteAttribute(id));
    }

    @ApiOperation("根据id获得属性")
    @GetMapping(value = "getAttrList")
    @ResponseBody
    public CommonResult<List<AttributeDO>> getAttrList(@RequestParam String ids){
        //System.out.println(ids);
        String s = ids.replaceAll(" ", "");
        //System.out.println(s);
        String[] split = s.split(",");
        List<Integer> idList = new ArrayList<>();
        Arrays.asList(split).forEach(i-> idList.add(Integer.parseInt(i)));
        List<AttributeDO> attributeDOS = new ArrayList<>();
        Optional.ofNullable(attrService.getAttrList(idList)).ifPresent(attrs-> attrs.forEach(attr->{
            List<String> list = new ArrayList<>(List.of(attr.getInputList().split(",")));
            AttributeDO attributeDO = new AttributeDO();
            attributeDO.setId(attr.getId());
            attributeDO.setName(attr.getName());
            attributeDO.setInputList(list);
            attributeDOS.add(attributeDO);
        }));
        //System.out.println(attributeDOS);
        return CommonResult.success(attributeDOS,"success");
    }
}
