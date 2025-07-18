package com.mariajulia.matchreparo.controller;

import com.mariajulia.matchreparo.dto.request.ClientRequest;
import com.mariajulia.matchreparo.dto.request.ServiceProviderRequest;
import com.mariajulia.matchreparo.dto.response.ClientResponse;
import com.mariajulia.matchreparo.dto.response.ServiceProviderResponse;
import com.mariajulia.matchreparo.entity.Client;
import com.mariajulia.matchreparo.entity.ServiceProvider;
import com.mariajulia.matchreparo.mapper.ClientMapper;
import com.mariajulia.matchreparo.mapper.ServiceProviderMapper;
import com.mariajulia.matchreparo.service.ClientService;
import com.mariajulia.matchreparo.service.ServiceProviderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matchreparo/auth")
public class AuthController {

    private final ClientService clientService;

    private final ServiceProviderService serviceProviderService;

    public AuthController(ClientService clientService, ServiceProviderService serviceProviderService) {
        this.clientService = clientService;
        this.serviceProviderService = serviceProviderService;
    }

    @PostMapping("/client")
    public ResponseEntity<ClientResponse> create(@Valid @RequestBody ClientRequest clientRequest) {
        Client client = clientService.create(ClientMapper.toClient(clientRequest));
        ClientResponse clientResponse = ClientMapper.toClientResponse(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientResponse);
    }

    @PostMapping("/service-provider")
    public ResponseEntity<ServiceProviderResponse> create(@Valid @RequestBody ServiceProviderRequest serviceProviderRequest) {
        ServiceProvider serviceProvider = ServiceProviderMapper.toServiceProvider(serviceProviderRequest);
        ServiceProvider serviceProviderCreated = serviceProviderService.create(serviceProvider);
        ServiceProviderResponse serviceProviderResponse = ServiceProviderMapper.toServiceProviderResponse(serviceProviderCreated);

        return ResponseEntity.status(HttpStatus.CREATED).body(serviceProviderResponse);
    }
}
