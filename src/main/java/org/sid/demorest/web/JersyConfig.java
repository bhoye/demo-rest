package org.sid.demorest.web;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class JersyConfig {
    @Bean
    public ResourceConfig resourceConfig(){
       ResourceConfig resourceConfig= new ResourceConfig();
       resourceConfig.register(BanqueRestJarRSService.class);
       return resourceConfig;
    }
}
