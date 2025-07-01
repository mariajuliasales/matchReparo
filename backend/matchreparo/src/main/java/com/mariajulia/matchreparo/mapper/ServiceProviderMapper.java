package com.mariajulia.matchreparo.mapper;

import com.mariajulia.matchreparo.dto.request.ServiceProviderRequest;
import com.mariajulia.matchreparo.dto.response.ServiceProviderResponse;
import com.mariajulia.matchreparo.entity.ServiceProvider;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ServiceProviderMapper {

    public static ServiceProvider toServiceProvider(ServiceProviderRequest serviceProviderRequest){
        return ServiceProvider.builder()
                .name(serviceProviderRequest.name())
                .email(serviceProviderRequest.email())
                .password(serviceProviderRequest.password())
                .description(serviceProviderRequest.description())
                .cnpj(serviceProviderRequest.cnpj())
                .build();
    }

    public static ServiceProviderResponse toServiceProviderResponse(ServiceProvider serviceProvider){
        return ServiceProviderResponse.builder()
                .id(serviceProvider.getId())
                .name(serviceProvider.getName())
                .email(serviceProvider.getEmail())
                .password(serviceProvider.getPassword())
                .description(serviceProvider.getDescription())
                .cnpj(serviceProvider.getCnpj())
                .build();
    }

}
