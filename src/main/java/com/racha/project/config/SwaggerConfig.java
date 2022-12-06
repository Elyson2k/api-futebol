package com.racha.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@Configuration
//@EnableSwagger2
//public class SwaggerConfig implements WebMvcConfigurer{
//
//	@Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(metaInfo());
//    }
//
//	private ApiInfo metaInfo() {
//    	return new ApiInfoBuilder()
//    			.title("API REST Futebol")
//    			.description("Uma api que serve para cadastrar partidas e seus jogadores em cada partida")
//    			.version("1.0.0")
//    			.contact(new Contact("Elyson Vinicius", "https://www.linkedin.com/in/elysonvnc2003/", "elysonviniciusdev@outlook.com"))
//    			.build();
//
//    }
//
//}
