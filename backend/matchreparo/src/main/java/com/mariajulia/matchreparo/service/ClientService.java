package com.mariajulia.matchreparo.service;

import com.mariajulia.matchreparo.entity.Client;
import com.mariajulia.matchreparo.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }
}
