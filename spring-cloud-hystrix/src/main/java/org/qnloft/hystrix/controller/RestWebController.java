package org.qnloft.hystrix.controller;

import org.qnloft.hystrix.service.RestWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : R&M www.rmworking.com/blog
 *         2018/9/26 15:30
 *         spring-cloud
 *         org.qnloft.hystrix.controller
 */
@RestController
public class RestWebController {

    @Autowired
    private RestWebService restWebService;

    @RequestMapping(value = "hello" , method = RequestMethod.GET)
    public String getHelloWorld(){
        return restWebService.restHelloWorldService();
    }
}
