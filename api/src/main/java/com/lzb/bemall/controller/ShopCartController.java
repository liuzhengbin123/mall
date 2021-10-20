package com.lzb.bemall.controller;

import com.lzb.bemall.utils.Base64Utils;
import com.lzb.bemall.vo.RestStatus;
import com.lzb.bemall.vo.ResultVo;
import io.jsonwebtoken.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: BeMall
 * @Package: com.lzb.bemall.controller
 * @ClassName: ShopCartController
 * @Author: LZB
 * @Description: 购物车控制器
 */

@RestController
@CrossOrigin
@RequestMapping("/shopcart")
@Api(value = "提供购物车业务相关接口",tags = "购物车管理")
public class ShopCartController {


    @ApiOperation("购物车列表接口")
    @GetMapping("/list")
    @ApiImplicitParam(dataType = "String",name = "token",value = "授权令牌",required = true)
    public ResultVo listCarts(String token){
        //1.获取token

        //2.校验token
        if(token==null){
            return new ResultVo(RestStatus.NO,"请先登录",null);
        }
        //验证token
        JwtParser parser=Jwts.parser();
        parser.setSigningKey("liu123456");  //解析token的SignKey必须和生成时设置的密码一致

        //如果token正确（密码正确，有效期内）则正常执行，否则抛出异常
        try {
            Jws<Claims> claimsJws = parser.parseClaimsJws(token);
            Claims body = claimsJws.getBody();
            String subject = body.getSubject(); //获取生成token设置的subject
            return new ResultVo(RestStatus.OK,"success",null);
        } catch (ExpiredJwtException e) {
            return new ResultVo(RestStatus.NO,"登录过期，请重新登录",null);
        }
    }
}
