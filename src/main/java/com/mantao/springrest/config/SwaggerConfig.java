package com.mantao.springrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Manito on 2019/3/7.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mantao.springrest.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    // Swagger Document METADATA
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Learning Spring")
                .version("1.0.0")
                .license("MIT")
                .licenseUrl("https://github.com/HideMode/LearningSpringRest/blob/master/LICENSE")
                .build();
    }

    // TODO: OAuth-security integration
}
