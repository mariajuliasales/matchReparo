package com.mariajulia.matchreparo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")
public class Client extends User {

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataBirth;

}
