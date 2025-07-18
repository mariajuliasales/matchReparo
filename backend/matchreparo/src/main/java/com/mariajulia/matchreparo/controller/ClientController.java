package com.mariajulia.matchreparo.controller;

import com.mariajulia.matchreparo.dto.request.ClientRequest;
import com.mariajulia.matchreparo.dto.response.ClientResponse;
import com.mariajulia.matchreparo.mapper.ClientMapper;
import com.mariajulia.matchreparo.service.ClientService;
import jakarta.validation.Valid;
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

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> update(@PathVariable Long id, @Valid @RequestBody ClientRequest clientRequest) {
        return clientService.update(id, ClientMapper.toClient(clientRequest))
                .map(client -> ResponseEntity.ok(ClientMapper.toClientResponse(client)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
