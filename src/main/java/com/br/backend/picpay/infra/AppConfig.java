package com.br.backend.picpay.infra;

import com.br.backend.picpay.annotations.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Info(author = "Jean Paul | jeanpaulwebb@gmail.com", date = "25/08/2023")
@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
