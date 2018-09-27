package org.qnloft.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author : R&M www.rmworking.com/blog
 *         2018/9/26 15:30
 *         spring-cloud
 *         org.qnloft.hystrix.service
 */
@Service
public class RestWebService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback" ,commandKey = "helloKey")
    public String restHelloWorldService() {
        // 如果让线程等待3s会发生什么呢？？
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return restTemplate.getForEntity("http://127.0.0.1:8661/index", String.class).getBody();
    }

    public String helloFallback() {
        return "访问web服务出错";
    }
}
