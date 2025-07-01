package com.mariajulia.matchreparo.dto.response;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record ClientResponse(Long id,
                             String name,
                             String email,
                             String password,
                             String description,
                             String cpf,
                             LocalDate dataBirth) {
}
