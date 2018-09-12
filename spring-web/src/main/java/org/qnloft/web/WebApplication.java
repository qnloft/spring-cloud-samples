package org.qnloft.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author : R&M www.rmworking.com/blog
 *         2018/9/10 15:10
 *         spring-cloud
 *         org.qnloft.eureka
 */
@SpringBootApplication
@EnableEurekaClient
public class WebApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }

}
