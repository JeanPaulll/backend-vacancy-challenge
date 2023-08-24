package com.br.backend.picpay.services;

import com.br.backend.picpay.domain.user.User;
import com.br.backend.picpay.domain.user.UserType;
import com.br.backend.picpay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    /**
     * @param payer
     * @param amount
     * @throws Exception
     */
    public void validationTransaction(User payer, BigDecimal amount) throws Exception {
        if (payer.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuário do tipo logista não está autorizado a realizar transação!");
        }
        if ((payer.getBalance().compareTo(amount)) < 0) {
            throw new Exception("Usuário não tem saldo suficiente!");
        }
    }

    /**
     * @param id
     * @return
     * @throws Exception
     */
    public User findUserById(Long id) throws Exception {
        return repository.findUserById(id).orElseThrow(() -> new Exception("Usuário não encontrato"));
    }

    /**
     * @param user
     * @return
     */
    public User saveUser(User user) {
        return repository.save(user);
    }
}
