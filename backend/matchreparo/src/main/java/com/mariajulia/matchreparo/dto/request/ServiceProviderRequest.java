package com.mariajulia.matchreparo.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ServiceProviderRequest(@NotBlank(message = "Nome não pode ser vazio.")
                                     String name,

                                     @NotBlank(message = "Email não pode ser vazio.")
                                     @Email(message = "Email deve ser válido.")
                                     String email,

                                     @NotBlank(message = "Senha não pode ser vazia.")
                                     String password,

                                     @NotBlank(message = "Descrição não pode ser vazia.")
                                     String description,

                                     @NotBlank(message = "CPF não pode ser vazio.")
                                     @Pattern(
                                             regexp = "^(\\d{14}|\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2})$",
                                             message = "CNPJ deve estar no formato 00000000000000 ou 00.000.000/0000-00"
                                     )
                                     String cnpj) {
}
