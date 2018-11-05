package com.clientui.configuration;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FeignConfig {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    public BasicAuthRequestInterceptor mBasicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }

}
