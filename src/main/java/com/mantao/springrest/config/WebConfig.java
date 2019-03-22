package com.mantao.springrest.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.mantao.springrest.interceptor.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * Created by Manito on 2019/3/7.
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    RequestInterceptor requestInterceptor;

    // 使用 Fastjson 提供的FastJsonHttpMessageConverter 来替换 Spring MVC 默认的 HttpMessageConverter
    // 以提高 @RestController @ResponseBody @RequestBody 注解的 JSON序列化速度
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converters.add(0, converter);
    }

    // Swagger UI静态资源目录
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Add swagger ui resources
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(requestInterceptor);
    }
}
