package com.br.backend.picpay.repositories;

import com.br.backend.picpay.annotations.Info;
import com.br.backend.picpay.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

@Info(author = "Jean Paul | jeanpaulwebb@gmail.com", date = "24/08/2023")
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
