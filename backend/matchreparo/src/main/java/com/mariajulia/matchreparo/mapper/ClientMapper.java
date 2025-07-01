package com.mariajulia.matchreparo.mapper;

import com.mariajulia.matchreparo.dto.request.ClientRequest;
import com.mariajulia.matchreparo.dto.response.ClientResponse;
import com.mariajulia.matchreparo.entity.Client;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ClientMapper {

    public static Client toClient(ClientRequest clientRequest){
        return Client.builder()
                .name(clientRequest.name())
                .email(clientRequest.email())
                .password(clientRequest.password())
                .description(clientRequest.description())
                .cpf(clientRequest.cpf())
                .dataBirth(clientRequest.dataBirth())
                .build();
    }

    public static ClientResponse toClientResponse(Client client){
        return ClientResponse.builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .password(client.getPassword())
                .description(client.getDescription())
                .cpf(client.getCpf())
                .dataBirth(client.getDataBirth())
                .build();
    }

}
