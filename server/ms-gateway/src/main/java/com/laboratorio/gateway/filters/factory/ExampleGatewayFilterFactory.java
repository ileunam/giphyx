package com.laboratorio.gateway.filters.factory;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class ExampleGatewayFilterFactory extends AbstractGatewayFilterFactory<ExampleGatewayFilterFactory.Configuration> {
    public ExampleGatewayFilterFactory() {
        super(Configuration.class);
    }

    @Override
    public GatewayFilter apply(Configuration config) {
        return (exchange, chain) -> {
            log.info("executing pre gateway filter factory: {}", config.message);
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                Optional.ofNullable(config.cookieValue).ifPresent(cookie -> {
                    exchange.getResponse().addCookie(ResponseCookie.from(config.cookieName, cookie).build());
                });
                log.info("executing post gateway filter factory: {}", config.message);
            }));
        };
    }

    @Data
    public static class Configuration {
        private String message;
        private String cookieValue;
        private String cookieName;
    }

}
