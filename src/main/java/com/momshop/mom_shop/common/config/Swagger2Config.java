package com.momshop.mom_shop.common.config;

import com.momshop.mom_shop.common.SwaggerProperties;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Antique
 * @Date 2022/1/24 15:08
 * @Version 1.0
 */
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){
        SwaggerProperties swaggerProperties = SwaggerProperties.builder()
                .apiBasePackage("com.momshop.mom_shop.controller")
                .title("mom's shop")
                .description("mom's shop接口文档")
                .contactName("antique")
                .version("1.0")
                .enableSecurity(true)
                .build();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo(swaggerProperties))
                .select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getApiBasePackage()))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }


    private ApiInfo apiInfo(SwaggerProperties swaggerProperties) {
        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .contact(new Contact(swaggerProperties.getContactName(), swaggerProperties.getContactUrl(), swaggerProperties.getContactEmail()))
                .version(swaggerProperties.getVersion())
                .build();
    }

/*    private List<ApiKey> securitySchemes(){
        List<ApiKey> result = new ArrayList<>();
         ApiKey
    }*/
}
