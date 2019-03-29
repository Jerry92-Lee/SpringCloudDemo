package com.jerry.test.gateway;

import com.jerry.test.gateway.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jerry
 * @version 2019-03-14
 */
@SpringBootApplication
@RestController
public class GatewayTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayTestApplication.class, args);
    }

    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

//    @Bean
//    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory(){
//        return new RequestTimeGatewayFilterFactory();
//    }

//    @Bean
//    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r -> r.path("/customer/**")
//                        .filters(f -> f.filters(new RequestTimeFilter())
//                                .addResponseHeader("X-Response-Default-Foo", "Default-Bar"))
//                        .uri("http://httpbin.org:80/get")
//                        .order(0)
//                        .id("customer_filter_router")
//                )
//                .build();
//    }

//    @Bean
//    public RouteLocator myRoute(RouteLocatorBuilder builder) {
//        String httpUri = "http://httpbin.org:80";
//
//        return builder.routes()
//                // 通过path断言，如果请求 /get ，则通过filter在header中，添加了"hello":"world"信息
//                .route(p -> p
//                        .path("/get")
//                        .filters(f -> f.addRequestHeader("hello", "world"))
//                        .uri(httpUri))
//                // 通过host去断言，如果host格式包含 *.hystrix.com ，则通过filter重定向到 /fallback
//                .route(p -> p
//                        .host("*.hystrix.com")
//                        .filters(f -> f
//                                .hystrix(config -> config
//                                        .setName("mycmd")
//                                        .setFallbackUri("forward:/fallback")))
//                        .uri(httpUri))
//                .build();
//
////        curl --dump-header - --header 'Host: www.hystrix.com' http://localhost:8750/
//
//    }
//
//    @RequestMapping("/fallback")
//    public Mono<String> fallback() {
//        return Mono.just("fallback test ...");
//    }

}
