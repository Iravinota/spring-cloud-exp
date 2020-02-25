package com.ws.exp.spring.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * HelloService
 *
 * @author Eric at 2020-02-24_11:02
 */
@FeignClient(value = "hello-service")
public interface HelloServiceInterface {
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiHahaha();
}
