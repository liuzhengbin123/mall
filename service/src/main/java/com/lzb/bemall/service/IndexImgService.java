package com.lzb.bemall.service;

import com.lzb.bemall.vo.ResultVo;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: BeMall
 * @Package: com.lzb.bemall.service
 * @ClassName: IndexImgService
 * @Author: LZB
 * @Description: 轮播图接口
 */
@Repository
public interface IndexImgService {

    /**
     * 封装轮播图接口
     * @return
     */
    public ResultVo listIndexImages();
}
