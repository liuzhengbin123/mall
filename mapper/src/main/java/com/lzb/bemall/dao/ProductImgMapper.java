package com.lzb.bemall.dao;

import com.lzb.bemall.entity.ProductImg;
import com.lzb.bemall.generate.GeneralDAO;

import java.util.List;

public interface ProductImgMapper extends GeneralDAO<ProductImg> {
    public List<ProductImg> selectProductImgByProductId(int productId);
}