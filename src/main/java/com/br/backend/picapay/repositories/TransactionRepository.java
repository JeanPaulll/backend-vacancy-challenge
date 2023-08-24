package com.br.backend.picapay.repositories;

import com.br.backend.picapay.annotations.Info;
import com.br.backend.picapay.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

@Info(author = "Jean Paul", date = "24/08/2023")
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
