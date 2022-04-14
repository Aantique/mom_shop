package com.momshop.mom_shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.momshop.mom_shop.base.dao.mapper.BrandMapper;
import com.momshop.mom_shop.base.model.Brand;
import com.momshop.mom_shop.service.BrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author Antique
 * @Date 2022/2/17 22:32
 * @Version 1.0
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    BrandMapper brandMapper;

    @Override
    public boolean addBrand(Brand brand) {
        return brandMapper.insert(brand)>0;
    }

    @Override
    public boolean deleteBrand(Integer id) {
        return brandMapper.deleteByPrimaryKey(id) >0 ;
    }

    @Override
    public boolean updateBrand(Brand brand) {
        return brandMapper.updateByPrimaryKey(brand)>0;
    }

    @Override
    public Brand getBrandById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Brand> getBrandsByPage(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        return brandMapper.selectAll();
    }

    @Override
    public List<Brand> getBrands() {
        return brandMapper.selectAll();
    }

}
