# Learning Spring
> Follow the [Baeldung](https://www.baeldung.com)'s Spring Rest tutorial to start this project.



## Prerequisites

1. IDE - IntellJ iDEA community
2. JDK 8+
3. Spring Boot [v2.1.3](https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/htmlsingle/)

4. [lombok](https://projectlombok.org/setup/maven)

   > **Never write `public int getFoo() {return foo;}` again.**

## Folder structure

```
├── com.mantao.springrest
	├── Application.class  Entry point
	├── config             JavaBased Configuration Class
	├── controller
	├── entity
	├── service
	├── dto
	├── util
```



## Initialization with spring boot

> Bootstrap your application with [Spring Initializr](https://start.spring.io/).



### Add `spring-boot-starter-web` dependencies

> Follow [Spring Web MVC](https://docs.spring.io/spring/docs/5.1.5.RELEASE/spring-framework-reference/web.html#mvc) to configure the mvc

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

#### Declaration

> 开启Spring MVC功能，扫描指定包下的Component

```xml
@Configuration
@EnableWebMvc
@ComponentScan("com.mantao.springrest.controller")
public class WebConfig {

    // ...
}
```

### fastjson

```xml
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.13</version>
</dependency>
```

#### [在 Spring MVC 中集成 Fastjson](https://github.com/alibaba/fastjson/wiki/%E5%9C%A8-Spring-%E4%B8%AD%E9%9B%86%E6%88%90-Fastjson)

> 如果你使用 Spring MVC 来构建 Web 应用并对性能有较高的要求的话，可以使用 Fastjson 提供的`FastJsonHttpMessageConverter` 来替换 Spring MVC 默认的 `HttpMessageConverter` 以提高 `@RestController @ResponseBody @RequestBody` 注解的 JSON序列化速度

```java
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //自定义配置...
        //FastJsonConfig config = new FastJsonConfig();
        //config.set ...
        //converter.setFastJsonConfig(config);
        converters.add(0, converter);
    }
}
```



### [Swagger](https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api)

> Use the **Springfox** implementation of the Swagger 2 specification.



### [Externalized Configuration](https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/htmlsingle/#boot-features-external-config)

> 配置相关的设置
>
> You also need to list the properties classes to register in the `@EnableConfigurationProperties` annotation, as shown in the following example:

1. @ConfigurationProperties vs @Value

   > 从配置文件中读取属性
   >
   > 下面示例匹配***file.upload-dir | file.upload_dir | file.uploadDir | FILE_UPLOAD_DIR***属性（**Relaxed Binding**）
   >
   > `ConfigurationProperties`不支持SpEL，支持**Relaxed Binding**和**[Meta-data Support](https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/htmlsingle/#configuration-metadata-format)**
   >
   > `@Value`支持SpEL

   ```java
   @ConfigurationProperties(prefix = "file")
   public class FileStorageProperties {
   
       private String uploadDir;
   
       public String getUploadDir() {
           return uploadDir;
       }
   
       public void setUploadDir(String uploadDir) {
           this.uploadDir = uploadDir;
       }
   }
   
   @Component
   public class MyBean {
   
       @Value("${name}")
       private String name;
   
       // ...
   
   }
   ```

2. @EnableConfigurationProperties

   > 将配置类注册为Bean; Bean名称为*file-com.XX.FileStorageProperties*
   >
   > Need to list the properties classes to register in the `@EnableConfigurationProperties` annotation，and the bean has a conventional name: `<prefix>-<fqn>` where `<prefix>` is the environment key prefix specified in the `@ConfigurationProperties` annotation and `<fqn>` is the fully qualified name of the bean. 

   ```java
   
   @Configuration
   @EnableConfigurationProperties(FileStorageProperties.class)
   public class MyConfiguration {
   }
   
   ```

   

## 异常处理

> 使用`@ExceptionHandler ` `@ControllerAdvice`全局处理异常
>
> The*@ControllerAdvice* annotation allows us to **consolidate our multiple, scattered @ExceptionHandlers from before into a single, global error handling component**.



## Security



## Testing







## Spring Features

### AOP



### The Spring Expression Language(SpEL)

> A powerful expression language that supports querying and manipulating an object graph at runtime.
>
> `${...}` is the property placeholder syntax. It can only be used to dereference properties.
>
> `#{...}` is [SpEL syntax](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/expressions.html), which is far more capable and complex. It can also handle property placeholders, and a lot more besides.





### Events and Listners



### Reactive Paradigm From Spring 5