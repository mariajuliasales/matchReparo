package com.mariajulia.matchreparo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "service_provider")
public class ServiceProvider extends User {

    @Column(nullable = false, unique = true, length = 14)
    private String cnpj;

}
