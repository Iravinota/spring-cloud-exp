package com.ws.exp.spring.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CallServiceApplication
 *
 * @author Eric at 2020-02-24_11:00
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class CallServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CallServiceApplication.class, args);
    }

    @Autowired
    private HelloServiceInterface helloServiceInterface;

    @RequestMapping("/hi")
    public String hello() {
        return helloServiceInterface.sayHiHahaha();
    }

    @RequestMapping("/haha")
    public String haha() {
        return "Haha from call-service";
    }
}
