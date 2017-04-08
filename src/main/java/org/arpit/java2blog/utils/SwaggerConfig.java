/*
 * Copyright The Nielsen Company. All Rights Reserved.
 * This software is the proprietary information of Nielsen.
 * Use is subject to license terms.
 */

package org.arpit.java2blog.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket newsApi() {
		String junit = System.getProperty("junit");
		boolean isJunit = junit == null ? false : junit.equals("true") ? true : false;

		
		return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.arpit.java2blog.controller"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(new ApiInfoBuilder().title("bet Management").description("Bet services").build());
	}


}