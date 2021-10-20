package com.lzb.bemall.dao;

import com.lzb.bemall.entity.IndexImg;
import com.lzb.bemall.generate.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author user
 */
@Repository
public interface IndexImgMapper extends GeneralDAO<IndexImg> {
    //查询轮播图信息：查询status=1 且安照seq进行排序

    /**
     * 查询轮播图
     * @return
     */
    public List<IndexImg> listIndexImgs();

}