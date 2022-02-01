package com.laboratorio.gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class GenericGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("Executing pre filter");
        exchange.getRequest().mutate().headers(header -> {
            header.add("token", "kfKLJDlkjsjjf2flks");
        });

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            log.info("Executing post filter");
            Optional.ofNullable(exchange.getRequest().getHeaders().getFirst("token")).ifPresent(value -> {
                exchange.getResponse().getHeaders().add("token", value);
            });
            exchange.getResponse().getCookies().add("color", ResponseCookie.from("color", "red").build());
            //exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
        }));
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
