package com.mariajulia.matchreparo.dto.response;

import lombok.Builder;

@Builder
public record ServiceProviderResponse(Long id,
                                      String name,
                                      String email,
                                      String password,
                                      String description,
                                      String cnpj) {
}
