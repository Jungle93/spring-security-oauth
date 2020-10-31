package com.github.jungle.learn.spring.oauth2.ressrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * description: ResourceServerApplication
 *
 * @author jungle
 * @version 1.0
 * @date 2020/10/30
 */
@SpringBootApplication
@EnableResourceServer
public class ResourceServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResourceServerApplication.class);
    }
}
