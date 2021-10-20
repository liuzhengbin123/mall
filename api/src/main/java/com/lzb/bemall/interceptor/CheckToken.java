package com.lzb.bemall.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzb.bemall.vo.RestStatus;
import com.lzb.bemall.vo.ResultVo;
    import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ProjectName: BeMall
 * @Package: com.lzb.bemall.interceptor
 * @ClassName: CheckToken
 * @Author: LZB
 * @Description: 校验token
 */

@Component
public class CheckToken implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getParameter("token");
        if(token==null){
            //提示请先登录
            ResultVo resultVo = new ResultVo(RestStatus.NO, "请先登录", null);
            doResponse(response,resultVo);
        }else{
            try {
                //验证token
                JwtParser parser= Jwts.parser();
                parser.setSigningKey("liu123456");  //解析token的SignKey必须和生成时设置的密码一致
                Jws<Claims> claimsJws = parser.parseClaimsJws(token);
              return true;
            } catch (ExpiredJwtException e) {
                ResultVo resultVo = new ResultVo(RestStatus.NO, "登录过期，请重新登录！！！", null);
                doResponse(response,resultVo);
            }
        }
        return false;
    }
    private void doResponse(HttpServletResponse response,ResultVo resultVo) throws IOException {
        response.setContentType("application/json; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        String s = new ObjectMapper().writeValueAsString(resultVo);
        writer.print(s);
        writer.flush();
        writer.close();

    }
}
