package com.lzb.bemall.service.impl;


import com.lzb.bemall.dao.UsersMapper;

import com.lzb.bemall.entity.Users;
import com.lzb.bemall.service.UserService;
import com.lzb.bemall.utils.Base64Utils;
import com.lzb.bemall.utils.MD5Utils;
import com.lzb.bemall.vo.RestStatus;
import com.lzb.bemall.vo.ResultVo;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;


import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @ProjectName: BeMall
 * @Package: com.lzb.bemall.service.impl
 * @ClassName: UserServiceImpl
 * @Author: LZB
 * @Description: 接口实现方法
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;


    @Override
    public ResultVo checkLogin(String name, String password) {
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",name);
        List<Users> users = usersMapper.selectByExample(example);
        if (users.size() == 0) {
            return new ResultVo(RestStatus.NO,"登陆失败，用户名不存在",null);
        }else{
            String mdsPwd = MD5Utils.md5(password);
            if(mdsPwd.equals(users.get(0).getPassword())){
               //如果登录验证成功，则需要生成令牌token（token就是按照特定规则生成的字符串）
                //使用jwt规则生成token字符串
                JwtBuilder builder = Jwts.builder();
                HashMap<String, Object> map = new HashMap<>();
                String token = builder.setSubject(name)    //主题，就是token中携带的数据
                        .setIssuedAt(new Date())    //设置token的生成时间
                        .setId(users.get(0).getUserId().toString())
                        .setClaims(map)           //map中可以存放用户的角色权限信息
                        .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)) //设置token过期时间
                        .signWith(SignatureAlgorithm.HS256, "liu123456")   //设置加密方式和密码
                        .compact();
                return new ResultVo(RestStatus.OK,token,users.get(0));
            }else{
                return new ResultVo(RestStatus.NO,"登陆失败，用户名或密码错误！",null);
            }

        }
    }
    @Transactional(rollbackFor=Exception.class)
    @Override
    public ResultVo userRegister(String name, String pwd) {
        synchronized (this) {
            //1.根据用户查询，这个用户是否已经被注册
            Example example = new Example(Users.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("username",name);
            List<Users> users = usersMapper.selectByExample(example);

            //2.如果没有被注册则进行保存操作
            if (users.size()== 0) {
                String md5Pwd = MD5Utils.md5(pwd);
               Users user = new Users();
                user.setUsername(name);
                user.setPassword(md5Pwd);
                user.setUserImg("/img/default.png");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());
                int i = usersMapper.insert(user);
                if (i > 0) {
                    return new ResultVo(RestStatus.OK, "注册成功", null);
                } else {
                    return new ResultVo(RestStatus.NO, "注册失败", null);
                }

            } else {
                return new ResultVo(RestStatus.NO, "用户名已经被注册", null);
            }
        }
    }
}
