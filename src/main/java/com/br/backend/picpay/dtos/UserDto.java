package com.br.backend.picpay.dtos;

import com.br.backend.picpay.annotations.Info;
import com.br.backend.picpay.domain.user.UserType;

import java.math.BigDecimal;

@Info(author = "Jean Paul | jeanpaulwebb@gmail.com", date = "25/08/2023")
public record UserDto(
        String firstName,
        String lastName,
        String document,
        BigDecimal balance,
        String email, String password,
        UserType type
) {
}
