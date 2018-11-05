package com.clientui.configuration;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Configuration;

/**
 * classe de configuration du client Feign
 */
@Configuration
public class FeignConfig {

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    /**
     * fonction qui permet de controler l'accès à l'application(si username et password définis dans application.properties)
     * @return
     */
    /*
    @Bean
    public BasicAuthRequestInterceptor mBasicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }*/

}
