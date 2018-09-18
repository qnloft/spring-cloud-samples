package org.qnloft.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @author : R&M www.rmworking.com/blog
 *         2018/9/18 11:15
 *         spring-cloud
 *         org.qnloft.gateway
 */
//@EnableEurekaClient
@SpringBootApplication
public class GateWayApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(GateWayApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("WEB", r -> r.path("/web/{segment}")
                        .filters(f -> f.setPath("/{segment}"))
                        .uri("http://127.0.0.1:8661"))
                .build();
    }
}
