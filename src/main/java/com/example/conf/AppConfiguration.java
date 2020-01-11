package com.example.conf;

import com.example.model.Greeting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

        @Bean
        public Greeting greeting() {
            return new Greeting(12, "Mayaro");
    }
}
