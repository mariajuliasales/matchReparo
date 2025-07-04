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

    public Optional<ServiceProvider> update(Long id, ServiceProvider serviceProvider) {
        Optional<ServiceProvider> opt = serviceProviderRepository.findById(id);
        if (opt.isPresent()) {
            ServiceProvider existingServiceProvider = opt.get();
            existingServiceProvider.setName(serviceProvider.getName());
            existingServiceProvider.setEmail(serviceProvider.getEmail());
            existingServiceProvider.setPassword(serviceProvider.getPassword());
            existingServiceProvider.setDescription(serviceProvider.getDescription());
            existingServiceProvider.setCnpj(serviceProvider.getCnpj());
            return Optional.of(serviceProviderRepository.save(existingServiceProvider));
        }
        return Optional.empty();
    }

}
