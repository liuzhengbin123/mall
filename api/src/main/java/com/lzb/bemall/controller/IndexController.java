package com.lzb.bemall.controller;

import com.lzb.bemall.service.CategoryService;
import com.lzb.bemall.service.IndexImgService;
import com.lzb.bemall.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: BeMall
 * @Package: com.lzb.bemall.controller
 * @ClassName: IndexController
 * @Author: LZB
 * @Description: 轮播图控制器
 */

@RestController
@CrossOrigin
@RequestMapping("/index")
@Api(value = "提供首页数据显示接口", tags = "首页管理")
public class IndexController {
    @Autowired
    private IndexImgService indexImgService;
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/indeximg")
    @ApiOperation("首页轮播图接口")
    public ResultVo listIndexImg() {
        ResultVo resultVo = indexImgService.listIndexImages();
        return resultVo;
    }

    @GetMapping("/category-list")
    @ApiOperation("商品分类接口")
    public ResultVo listCategory(){
        ResultVo resultVo = categoryService.listCategory();
        return resultVo;
    }

    @GetMapping("/list-recommends")
    @ApiOperation("获得商品推荐数据")
    public ResultVo listRecommendsProduct(){
        return categoryService.listFirstProduct();
    }

    @GetMapping("/list-category-recommends")
    @ApiOperation("分类推荐商品接口")
    public ResultVo listRecommendsProductByCategory(){
        return categoryService.listFirstLevelCategories()   ;
    }

}
