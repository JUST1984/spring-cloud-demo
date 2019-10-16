package com.just1984.spring.cloud.demo.gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: yixiezi1994@gmail.com
 * @date: 2019-10-15 20:45
 */
@Configuration
public class RouteLocatorConfiguration {

    @Bean
    public RouteLocator providerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes().route(predicateSpec -> predicateSpec
                .path("/provider/**")
                .filters(gatewayFilterSpec -> gatewayFilterSpec.addResponseHeader("name", "JUST1984"))
                .uri("lb://SPRING-CLOUD-DEMO-SERVICE-PROVIDER")).build();
    }

}
