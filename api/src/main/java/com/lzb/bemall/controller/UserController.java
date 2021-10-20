package com.lzb.bemall.controller;


import com.lzb.bemall.entity.Users;
import com.lzb.bemall.service.UserService;
import com.lzb.bemall.utils.Base64Utils;
import com.lzb.bemall.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @ProjectName: BeMall
 * @Package: com.lzb.bemall.controller
 * @ClassName: UserController
 * @Author: LZB
 * @Description: 用户控制层
 */

@RestController
@RequestMapping("/user")
@Api(value = "提供用户登录和注册的接口", tags = "用户管理")
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;
    @ApiOperation("用户登录接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "String", name = "username", value = "用户登录账号", required = true),
            @ApiImplicitParam(paramType = "String", name = "password", value = "用户登录密码", required = true)
    })
   @GetMapping("/login")
    public ResultVo login(@RequestParam("username") String name, @RequestParam(value = "password") String pwd) {
        ResultVo resultVo = userService.checkLogin(name, pwd);
        //如果登录验证成功，则需要生成令牌token（token就是按照特定规则生成的字符串）
        return resultVo;
    }

    @ApiOperation("用户注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "String", name = "username", value = "用户注册账号", required = true),
            @ApiImplicitParam(paramType = "String", name = "password", value = "用户注册密码", required = true)
    })
   @PostMapping("/register")
    public ResultVo register(@RequestBody Users user) {
        ResultVo resultVo = userService.userRegister(user.getUsername(), user.getPassword());
        return resultVo;
    }
}
