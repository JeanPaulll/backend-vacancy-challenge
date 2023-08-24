package com.br.backend.picapay.domain.transaction;

import com.br.backend.picapay.annotations.Info;
import com.br.backend.picapay.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Info(author = "Jean Paul", date = "24/08/2023")
@Entity(name = "transactions")
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name="payer_id")
    private User payer;

    @ManyToOne
    @JoinColumn(name="payee_id")
    private User payee;

    private LocalDateTime timestamp;
}
