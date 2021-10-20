package com.lzb.bemall.dao;

import com.lzb.bemall.entity.Product;
import com.lzb.bemall.entity.ProductVo;
import com.lzb.bemall.generate.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductMapper extends GeneralDAO<Product> {

    public List<ProductVo> getAllProduct();

//查询指定一级类别下销量最高的6个商品
    List<ProductVo> selectTop6ByCategory(int cid);
}