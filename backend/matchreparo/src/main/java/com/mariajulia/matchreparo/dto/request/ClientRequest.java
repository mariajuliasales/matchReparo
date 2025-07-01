package com.mariajulia.matchreparo.dto.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record ClientRequest(@NotBlank(message = "Nome não pode ser vazio.")
                            String name,

                            @NotBlank(message = "Email não pode ser vazio.") @Email(message = "Email deve ser válido.")
                            String email,

                            @NotBlank(message = "Senha não pode ser vazia.")
                            String password,

                            @NotBlank(message = "Descrição não pode ser vazia.")
                            String description,

                            @NotBlank(message = "CPF não pode ser vazio.") @Pattern(regexp = "^(\\d{11}|\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2})$", message = "CPF deve estar no formato 00000000000 ou 000.000.000-00")
                            String cpf,

                            @NotNull(message = "Data de nascimento não pode ser nula.") @Past(message = "Data de nascimento deve ser uma data passada.")
                            LocalDate dataBirth) {
}