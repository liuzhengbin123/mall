package com.lzb.bemall.service;

import com.lzb.bemall.vo.ResultVo;

/**
 * @ProjectName: BeMall
 * @Package: com.lzb.bemall.service.impl
 * @ClassName: CategoryService
 * @Author: LZB
 * @Description: 商品分类接口
 */
public interface CategoryService {
    /**
     * 查询所有目录(包含三个级别)
     * @return
     */
    public ResultVo listCategory();


    /**
     * 查询一级类别
     * @return
     */
    public ResultVo  listFirstProduct();


    /**
     * 查询所有一级分类，同时查询当前一级分类下销量最高的6个商品
     * @return
     */
    public  ResultVo listFirstLevelCategories();
}
