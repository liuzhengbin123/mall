package com.lzb.bemall.service.impl;

import com.lzb.bemall.dao.CategoryMapper;
import com.lzb.bemall.dao.ProductMapper;
import com.lzb.bemall.entity.CategoryVo;
import com.lzb.bemall.entity.ProductVo;
import com.lzb.bemall.service.CategoryService;
import com.lzb.bemall.vo.RestStatus;
import com.lzb.bemall.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: BeMall
 * @Package: com.lzb.bemall.service.impl
 * @ClassName: CategoryServiceImpl
 * @Author: LZB
 * @Description: 商品分类实现类
 */

@Service
public class CategoryServiceImpl implements CategoryService {
        @Autowired
        private CategoryMapper categoryMapper;
        @Autowired
        private ProductMapper productMapper;
    @Override
    public ResultVo listCategory() {
        List<CategoryVo> categoryVos = categoryMapper.selectAllByCategory();
        ResultVo success = new ResultVo(RestStatus.OK, "success", categoryVos);

        return success;
    }

    @Override
    public ResultVo listFirstProduct() {
        List<ProductVo> firstLevelProduct = productMapper.getAllProduct();
        ResultVo success = new ResultVo(RestStatus.OK, "success", firstLevelProduct);
        return success;
    }


    @Override
    public ResultVo listFirstLevelCategories() {
        List<CategoryVo> categoryVos = categoryMapper.selectFirstLevelCategories();
        ResultVo success = new ResultVo(RestStatus.OK, "success", categoryVos);
        return success;
    }
}
