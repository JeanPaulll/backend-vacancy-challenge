package com.br.backend.picpay.repositories;

import com.br.backend.picpay.annotations.Info;
import com.br.backend.picpay.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Info(author = "Jean Paul | jeanpaulwebb@gmail.com", date = "24/08/2023")
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * @param document
     * @return
     */
    Optional<User> findUserByDocument(String document);

    /**
     * @param id
     * @return
     */
    Optional<User> findUserById(Long id);

    /**
     * @param email
     * @return
     */
    Optional<User> findUserByEmail(String email);
}
