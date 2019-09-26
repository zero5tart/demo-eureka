package com.hello.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@EnableAutoConfiguration
@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));
    @Autowired
    private DiscoveryClient client;
    @RequestMapping(value = "/hello")
    public String index(){

        ServiceInstance instance = (ServiceInstance) client.getInstances("");
        logger.info("/hello, host:" + instance.getHost()+", service_id:"+ instance.getServiceId());

        return "Hello World!";
    }
}
