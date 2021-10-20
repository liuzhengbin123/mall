package com.lzb.bemall.config;

import com.lzb.bemall.interceptor.CheckToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName: BeMall
 * @Package: com.lzb.bemall.config
 * @ClassName: interceptorConfig
 * @Author: LZB
 * @Description: 拦截器配置类
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private CheckToken checkToken;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(checkToken)
                .addPathPatterns("/shopcart/**")
                .addPathPatterns("/orders/**")
                .excludePathPatterns("/user/**");

    }
}
