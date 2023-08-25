package com.br.backend.picpay.services;

import com.br.backend.picpay.annotations.Info;
import com.br.backend.picpay.domain.transaction.Transaction;
import com.br.backend.picpay.domain.user.User;
import com.br.backend.picpay.dtos.TransactionDto;
import com.br.backend.picpay.repositories.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.env.Environment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

@Info(author = "Jean Paul | jeanpaulwebb@gmail.com", date = "25/08/2023")
@Service
public class TransactionService {
    @Autowired
    private UserService userService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private Environment env;

    private RestTemplate restTemplate;

    /**
     * @param transactionDto
     * @throws Exception
     */
    public void create(TransactionDto transactionDto) throws Exception {
        User payer = this.userService.findUserById(transactionDto.payerId());
        User payee = this.userService.findUserById(transactionDto.payeeId());
        userService.validationTransaction(payer, transactionDto.value());
        boolean isAuthorized = this.canAuthorize(payer, transactionDto.value());
        if (!isAuthorized) {
            throw new Exception("Transação não autorizada!");
        }
        execute(transactionDto, payee, payer);
        updateToBalance(transactionDto, payer, payee);
    }

    /**
     * @param transactionDto
     * @param payee
     * @param payer
     */
    private static void execute(TransactionDto transactionDto, User payee, User payer) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDto.value());
        transaction.setPayee(payee);
        transaction.setPayer(payer);
        transaction.setTimestamp(LocalDateTime.now());
    }

    /**
     * @param transactionDto
     * @param payer
     * @param payee
     */
    private static void updateToBalance(TransactionDto transactionDto, User payer, User payee) {
        payer.setBalance(payer.getBalance().subtract(transactionDto.value()));
        payee.setBalance(payee.getBalance().subtract(transactionDto.value()));
    }

    /**
     * @param payer
     * @param value
     * @return
     */
    public boolean canAuthorize(User payer, BigDecimal value) {
        String transferAuthorization = env.getProperty("app.transfer_authorization");
        assert transferAuthorization != null;
        ResponseEntity<Map> response = restTemplate.getForEntity(transferAuthorization, Map.class);
        return response.getStatusCode() == HttpStatus.OK && Objects.requireNonNull(response.getBody()).get("message") == "Autorizado";
    }
}
