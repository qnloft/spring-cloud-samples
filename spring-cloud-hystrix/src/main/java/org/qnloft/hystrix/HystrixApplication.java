package org.qnloft.hystrix;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author : R&M www.rmworking.com/blog
 *         2018/9/26 10:38
 *         spring-cloud
 *         org.qnloft.hystrix
 */
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
public class HystrixApplication{

    /**
     * 注入发起rest请求的bean
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 将HystrixMetricsStreamServlet注册到Servlet，否则会出现访问hystrix.stream 404问题
     * @return
     */
    @Bean
    public ServletRegistrationBean<HystrixMetricsStreamServlet> getHystrixStreamServlet(){

        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }
}
