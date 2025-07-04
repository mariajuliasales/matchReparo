package com.mariajulia.matchreparo.service;

import com.mariajulia.matchreparo.entity.ServiceProvider;
import com.mariajulia.matchreparo.repository.ServiceProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProviderService {

    public final ServiceProviderRepository serviceProviderRepository;

    public ServiceProviderService(ServiceProviderRepository serviceProviderRepository) {
        this.serviceProviderRepository = serviceProviderRepository;
    }

    public ServiceProvider create(ServiceProvider serviceProvider) {
        return serviceProviderRepository.save(serviceProvider);
    }

    public List<ServiceProvider> findAll() {
        return serviceProviderRepository.findAll();
    }

    public Optional<ServiceProvider> findById(Long id) {
        return serviceProviderRepository.findById(id);
    }

}
