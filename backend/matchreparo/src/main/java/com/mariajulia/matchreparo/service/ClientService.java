package com.mariajulia.matchreparo.service;

import com.mariajulia.matchreparo.entity.Client;
import com.mariajulia.matchreparo.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client create(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    public Optional<Client> update(Long id, Client client) {
        Optional<Client> opt = clientRepository.findById(id);
        if (opt.isPresent()) {
            Client existingClient = opt.get();
            existingClient.setName(client.getName());
            existingClient.setEmail(client.getEmail());
            existingClient.setPassword(client.getPassword());
            existingClient.setDescription(client.getDescription());
            existingClient.setCpf(client.getCpf());
            existingClient.setDataBirth(client.getDataBirth());
            return Optional.of(clientRepository.save(existingClient));
        }
        return Optional.empty();
    }

}
