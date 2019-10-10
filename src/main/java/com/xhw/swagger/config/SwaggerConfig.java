package com.xhw.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Auther: xhw
 * @Date: 2019-10-08 16:01
 * @Description: Swagger2配置类
 * 在与spring boot集成时，放在与Application.java同级的目录下。
 * 通过@Configuration注解，让Spring来加载该类配置。
 * 再通过@EnableSwagger2注解来启用Swagger2。
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 添加摘要信息(Docket)
     */
    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("Spring Boot中使用Swagger2构建RESTful APIs-API实时接口文档")
                        .description("用于实时查看、测试API")
                        .contact(new Contact("xhw", "https://blog.csdn.net/sanyaoxu_2/article/details/80555328", ""))
                        .version("版本号:1.0")
                        .build())
                .select()
                //API基础扫描路径
                .apis(RequestHandlerSelectors.basePackage("com.xhw.swagger.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
