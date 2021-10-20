package com.lzb.bemall.service;

import com.lzb.bemall.vo.ResultVo;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: BeMall
 * @Package: com.lzb.bemall.service
 * @ClassName: UserService
 * @Author: LZB
 * @Description: 用户服务
 */

@Repository
public interface UserService {
    /**
     * 检测登陆是否成功
     * @param name
     * @param password
     * @return
     */
    public ResultVo checkLogin(String name, String password);

    /**
     * 用户注册
     * @param name
     * @param pwd
     * @return
     */
    public ResultVo userRegister(String name,String pwd);

}
