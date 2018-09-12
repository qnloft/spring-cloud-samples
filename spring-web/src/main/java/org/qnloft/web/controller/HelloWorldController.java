package org.qnloft.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : R&M www.rmworking.com/blog
 *         2018/9/12 22:08
 *         spring-cloud
 *         org.qnloft.web.controller
 */
@RestController
@RequestMapping
public class HelloWorldController {

    @RequestMapping("/index")
    public String index(){

        return "hello world!!";
    }
}
