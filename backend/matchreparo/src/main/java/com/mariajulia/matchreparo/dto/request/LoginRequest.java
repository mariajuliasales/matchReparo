package com.mariajulia.matchreparo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest(@NotBlank(message = "Email não pode ser vazio.") @Email(message = "Email deve ser válido.")
                           String email,

                           @NotBlank(message = "Senha não pode ser vazia.")
                           String password) {
}
