package com.example.demo;

import com.example.controller.GreetingController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.URL;
import java.util.Arrays;
import java.util.Objects;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class DemoApplicationTests {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Autowired
    private GreetingController greetingController;

    @Autowired
    private ApplicationContext ctx;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void contextLoads() {
        Assert.assertNotNull(greetingController);
        log.info("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            log.info("Beans in test:" + beanName);
            break;
        }

        log.info("Total beans: " + beanNames.length);
    }

    @Test
    public void testGreeting() {
        ResponseEntity<String> response = template.getForEntity(base.toString() + "greeting",
                String.class);
        log.info("/greeting: " + response.getBody());
        log.info("Onj eq: " + Objects.equals(response.getBody(), "Greetings from Spring Boot!"));
//        assertThat(response.getBody(),is("{\"id\":1,\"content\":\"Hello, World!\"}"));
        Assert.assertEquals("{\"id\":1,\"content\":\"Hello, World!\"}", response.getBody());

    }

}
