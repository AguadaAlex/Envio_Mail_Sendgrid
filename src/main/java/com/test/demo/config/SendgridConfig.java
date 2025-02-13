package com.test.demo.config;

import com.sendgrid.SendGrid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendgridConfig {

    //SE CAPTURA LA API KEY DE PROPERTIES Y SE INSTANCIA OBJETO CON DICHO VALOR
    @Value("${sendgrid.key}")
    private String key;

    @Bean
    public SendGrid getSendgrid(){
        return new SendGrid(key);
    }
}
