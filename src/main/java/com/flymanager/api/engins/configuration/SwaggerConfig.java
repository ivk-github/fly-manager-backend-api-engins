package com.flymanager.api.engins.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30)
				.apiInfo(apiInfo())
				.tags(new Tag("Engins", "Endpoints for CRUD operations on engins"))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.flymanager.api.engins"))
				.paths(PathSelectors.regex("/engins.*"))
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Fly Manager : Engins management API")
				.version("1.0")
			//	.description("Fly Manager Engins management API")
			//	.license("MIT License")
			//	.licenseUrl("https://opensource.org/licenses/MIT")
				.build();
	}
}
