package com.example.conf;

import com.example.model.Greeting;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecondConf {

    @Bean
    public Greeting greetingSecond() {
        return new Greeting(13, "Mayaro12");
    }
}
