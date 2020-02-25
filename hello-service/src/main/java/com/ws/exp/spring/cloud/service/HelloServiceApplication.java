package com.ws.exp.spring.cloud.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloServiceApplication
 *
 * @author Eric at 2020-02-24_10:36
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class HelloServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloServiceApplication.class, args);
    }

    @Value("${server.port}")
    private int port;

    @RequestMapping("/hi")
    public String hello() {
        return "Hi, my port = " + port;
    }
}
