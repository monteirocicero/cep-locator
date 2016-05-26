package com.cicero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Docket newsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("com.cicero").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.any()).paths(Predicates.not(PathSelectors.regex("/error.*"))).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("CEP Locator").description("Spring Boot REST with Swagger")
				.termsOfServiceUrl("http://swagger.io/terms/").contact("Cícero Monteiro")
				.license("Apache License Version 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("2.0").build();
	}


}
