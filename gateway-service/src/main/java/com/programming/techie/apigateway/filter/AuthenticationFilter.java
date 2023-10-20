package com.programming.techie.apigateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired RouteValidator validator;

    @Autowired private RestTemplate template;

    public AuthenticationFilter(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(AuthenticationFilter.Config config) {
        return (((exchange, chain) -> {
            if (validator.isSecured.test(exchange.getRequest())){
                try {
                    template.getForObject("http://user-service/users/login",Boolean.class);
                }catch (Exception e){
                    throw new RuntimeException(e.getMessage());
                }
            }

            return chain.filter(exchange);
        }));
    }

    public static class Config{

}

}