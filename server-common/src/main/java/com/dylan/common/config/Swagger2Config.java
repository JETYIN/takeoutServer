package com.dylan.common.config;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 当前类作为文档描述接口config类
 */
@Configuration
@EnableSwagger2
@Slf4j

public class Swagger2Config {//fixme 以下为必须配置单元项

    private String SWAGER_TITLE = "Dylan Swager2 API";
    private String SWAGER_DESCRIPTION = "https://github.com/JETYIN";
    private String SWAGER_TERMS = "https://github.com/JETYIN";
    private String SWAGER_VERSION = "1.0.0";
    private String SWAGER_CONTACT_URL = "https://github.com/JETYIN";
    private String SWAGER_CONTACT_NAME = "Dylan";
    private String SWAGER_CONTACT_EMAIL = "494699974@qq.com";


    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenBuilder = new ParameterBuilder();
        List<Parameter> parameterList = new ArrayList<>();
        tokenBuilder.name("Authorization")
                .defaultValue("去其他请求中获取heard中token参数")
                .description("令牌")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true).build();
        parameterList.add(tokenBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)//文档类型
                .apiInfo(apiInfo())//fixme 获取下面的配置类
                .select()//构建api选择器
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//fixme api选择器，在controller层中提供给外部的api接口注解@ApiOperation:即可生成文档,使用示例;@ApiOperation(httpMethod = "POST", value = "分页查询可靠消息")
                .paths(PathSelectors.any())//api选择器选择包路径下任何api显示在文档中

                .build()
                //配置鉴权信息
                //.securitySchemes(securitySchemes())//fixme 具有OAuth安全API的Swagger UI
                //.securityContexts(securityContexts())//fixme 在swagger2-ui界面需要键入需求的密码才可以访问
                .globalOperationParameters(parameterList)
                .enable(true);
    }


    public ApiInfo apiInfo() {//fixme 个人项目信息
        return new ApiInfoBuilder()
                .title(SWAGER_TITLE)
                .description(SWAGER_DESCRIPTION)
                .termsOfServiceUrl(SWAGER_TERMS)
                .contact(new Contact(SWAGER_CONTACT_NAME, SWAGER_CONTACT_URL, SWAGER_CONTACT_EMAIL))
                .version(SWAGER_VERSION)
                .build();
    }

    private List<ApiKey> securitySchemes() {
        return new ArrayList(Collections.singleton(new ApiKey("Authorization", "Authorization", "header")));
    }
    private List<SecurityContext> securityContexts() {
        return new ArrayList(
                Collections.singleton(SecurityContext.builder()
                        .securityReferences(defaultAuth())
                        .forPaths(PathSelectors.regex("^(?!auth).*$"))//fixme url为auth的页面需要输入设置的密码
                        .build())
        );
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return new ArrayList(Collections.singleton(new SecurityReference("Authorization", authorizationScopes)));
    }



}
