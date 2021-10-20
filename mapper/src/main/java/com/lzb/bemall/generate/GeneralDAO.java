package com.lzb.bemall.generate;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @ProjectName: BeMall
 * @Package: com.lzb.bemall.generate
 * @ClassName: GeneralDAO
 * @Author: LZB
 * @Description:
 */
public interface GeneralDAO<T> extends Mapper<T>, MySqlMapper<T> {
}
