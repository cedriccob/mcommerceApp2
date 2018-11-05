package com.clientui.configuration;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Configuration;

/**
 * Classe permettant de tracer les requêtes
 */
@Configuration
public class SleuthConfig {

    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }
}