package com.example.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2

public class SpringFoxConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .apis(RequestHandlerSelectors.any())
//                or
                .apis(RequestHandlerSelectors.basePackage("com.example"))
//                .paths(PathSelectors.regex("(?!/error.*).*"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Mayank Greeting")
                .description("As I like to learn.")
                .termsOfServiceUrl("http://javainuse.com")
                .contact(getContact()).license("JavaInUse License")
                .licenseUrl("aroramayank2002@gmail.com")
                .version("1.0.0.0.0.0.0").build();
    }

    private Contact getContact(){
        return new Contact("Mayank", "https://www.linkedin.com/in/mayankarora1306/", "aroramayank2002@gmail.com");
    }

}
