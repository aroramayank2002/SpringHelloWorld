package com.example.conf;

import com.example.model.Greeting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(SecondConf.class)
public class AppConfiguration {

    @Bean
    public Greeting greeting() {
        return new Greeting(12, "Mayaro");
    }
}
