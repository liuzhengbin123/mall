package com.lzb.bemall.dao;

import com.lzb.bemall.entity.Category;
import com.lzb.bemall.entity.CategoryVo;
import com.lzb.bemall.generate.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryMapper extends GeneralDAO<Category> {

    public List<CategoryVo> selectAllByCategory();
    //2.子查询：根据parentId查询子分类
    public List<CategoryVo> selectAllByCategory2(int parentId);



    //查询第一级分类的商品
    public List<CategoryVo> selectFirstLevelCategories();
}