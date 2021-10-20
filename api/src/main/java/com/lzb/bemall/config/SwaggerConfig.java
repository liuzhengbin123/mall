package com.lzb.bemall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @ProjectName: BeMall
 * @Package: com.lzb.bemall.config
 * @ClassName: SwaggerConfig
 * @Author: LZB
 * @Description: Swagger配置类
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /*swagger会帮助我们生成接口文档
    * 1.配置生成的文档信息
    * 2.配置生成规则
    * */

    /**
     *   Docket封装接口文档信息
    */
    @Bean
    public Docket getDocket(){
        //指定文档风格
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("商城后端接口说明")
                .description("描述了后端接口规范。。。")
                .version("v2.0.1")
                .contact(new Contact("LZB","www.lzb.com","1875981861@qq.com"));
        ApiInfo apiInfo = apiInfoBuilder.build();
        //指定生成文档的封面信息：文档标题、版本、作者
        docket.apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lzb.bemall.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

}
