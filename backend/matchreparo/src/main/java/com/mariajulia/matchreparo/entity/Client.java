package com.mariajulia.matchreparo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client extends User {

    @Column(nullable = false, unique = true , length = 11)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataBirth;

}
