package com.jq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;



import springfox.documentation.builders.OAuthBuilder;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationCodeGrant;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.service.TokenEndpoint;
import springfox.documentation.service.TokenRequestEndpoint;

import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;

import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.service.SecurityReference;

import java.util.*;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
   // @Bean
   // public Docket createRestApi() {
   //     return new Docket(DocumentationType.SWAGGER_2)
   //             .pathMapping("/")
   //             .select()
   //             .apis(RequestHandlerSelectors.basePackage("com.jq.controller"))
  //             .paths(PathSelectors.any())
  //              .build().apiInfo(new ApiInfoBuilder()
  //                     .title("JQ API Information")
  //                      .description("")
  //                      .version("1.0")
  //                      .contact(new Contact("Author","","48458192@qq.com"))
  //                      .license("The Apache License")
                        //.licenseUrl("http://www.baidu.com")
  //                      .build());
  //  }
    
  @Bean
    public Docket createRestApi() {
 
       // return new Docket(DocumentationType.SWAGGER_2)
       //         .apiInfo(apiInfo())
       //         .select()
       //         .apis(RequestHandlerSelectors.basePackage("com.jq.controller"))
       //        .paths(PathSelectors.any())
       //         .build()
       //         .securitySchemes(securitySchemes())
       //         .securityContexts(securityContexts());
                
                
                return new Docket(DocumentationType.SWAGGER_2).
                useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jq.controller"))
                .paths(PathSelectors.regex("^(?!auth).*$"))
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                ;

    }
 
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("JQ API Information")
                .description("")
                .termsOfServiceUrl("")
                .version("1.0")
                .build();
    }
 
    private List<ApiKey> securitySchemes() {
        List<ApiKey> apiKeys = new ArrayList<>();
        apiKeys.add(new ApiKey("Authorization", "Authorization", "header"));
        //apiKeys.add(new ApiKey("x-auth-token", "x-auth-token", "header"));
        return apiKeys;
    }
 
    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^(?!auth).*$")).build());
        return securityContexts;
    }
 
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }

    
    
    
}

