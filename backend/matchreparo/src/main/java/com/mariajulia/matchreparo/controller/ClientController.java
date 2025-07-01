package com.mariajulia.matchreparo.controller;

import com.mariajulia.matchreparo.dto.request.ClientRequest;
import com.mariajulia.matchreparo.dto.response.ClientResponse;
import com.mariajulia.matchreparo.mapper.ClientMapper;
import com.mariajulia.matchreparo.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ClientResponse save(@Valid @RequestBody ClientRequest clientRequest) {
        return ClientMapper.toClientResponse(clientService.saveClient(ClientMapper.toClient(clientRequest)));
    }
}
