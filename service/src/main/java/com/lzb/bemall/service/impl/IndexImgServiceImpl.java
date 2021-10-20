package com.lzb.bemall.service.impl;

import com.lzb.bemall.dao.IndexImgMapper;
import com.lzb.bemall.entity.IndexImg;
import com.lzb.bemall.service.IndexImgService;
import com.lzb.bemall.vo.RestStatus;
import com.lzb.bemall.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: BeMall
 * @Package: com.lzb.bemall.service.impl
 * @ClassName: IndexImgServiceImpl
 * @Author: LZB
 * @Description: 实现轮播图接口
 */

@Service
public class IndexImgServiceImpl implements IndexImgService {

    @Autowired
    private IndexImgMapper indexImgMapper;

    @Override
    public ResultVo listIndexImages() {
        List<IndexImg> indexImgs = indexImgMapper.listIndexImgs();
        if (indexImgs.size()==0){
            return new ResultVo(RestStatus.NO,"fail",null);
        }else {
            return new ResultVo(RestStatus.OK, "success", indexImgs);
        }
    }
}
