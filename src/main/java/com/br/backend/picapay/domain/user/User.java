package com.br.backend.picapay.domain.user;

import com.br.backend.picapay.annotations.Info;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Info(author = "Jean Paul", date = "24/08/2023")
@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserType userType;
}
