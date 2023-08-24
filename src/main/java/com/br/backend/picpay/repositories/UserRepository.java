package com.br.backend.picpay.repositories;

import com.br.backend.picpay.annotations.Info;
import com.br.backend.picpay.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Info(author = "Jean Paul | jeanpaulwebb@gmail.com", date = "24/08/2023")
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByDocument(String document);
    Optional<User> findUserById(Long id);
    Optional<User> findUserByEmail(String email);
}
