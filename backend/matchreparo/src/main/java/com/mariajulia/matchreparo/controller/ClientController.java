package com.mariajulia.matchreparo.controller;

import com.mariajulia.matchreparo.dto.request.ClientRequest;
import com.mariajulia.matchreparo.dto.response.ClientResponse;
import com.mariajulia.matchreparo.entity.Client;
import com.mariajulia.matchreparo.mapper.ClientMapper;
import com.mariajulia.matchreparo.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matchreparo/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientResponse> create(@Valid @RequestBody ClientRequest clientRequest){
        Client client = clientService.create(ClientMapper.toClient(clientRequest));
        ClientResponse clientResponse = ClientMapper.toClientResponse(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(clientResponse);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> findAll() {
        List<ClientResponse> clients = clientService.findAll()
                .stream()
                .map(ClientMapper::toClientResponse)
                .toList();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> findById(@PathVariable Long id) {
        return clientService.findById(id)
                .map(client -> ResponseEntity.ok(ClientMapper.toClientResponse(client)))
                .orElse(ResponseEntity.notFound().build());
    }
}
