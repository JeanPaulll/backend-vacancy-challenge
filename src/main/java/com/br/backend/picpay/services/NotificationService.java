package com.br.backend.picpay.services;

import com.br.backend.picpay.annotations.Info;
import com.br.backend.picpay.domain.user.User;
import com.br.backend.picpay.dtos.NotificationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Info(author = "Jean Paul | jeanpaulwebb@gmail.com", date = "25/08/2023")
@Service
public class NotificationService {
    @Autowired
    private Environment env;

    private RestTemplate restTemplate;

    public void send(User user, String message) throws Exception {
        String email = user.getEmail();
        String sendEmail = (String) env.getProperty("app.send_email");
        NotificationDto notificationDto = new NotificationDto(email, message);
        assert sendEmail != null;
        ResponseEntity<String> response = restTemplate.postForEntity(sendEmail, notificationDto, String.class);
        if (!(response.getStatusCode() == HttpStatus.OK)) {
            String messageErro = "Não foi possivel enviar a notificação!";
            System.out.println(messageErro);
            throw new Exception(messageErro);
        }
    }
}
