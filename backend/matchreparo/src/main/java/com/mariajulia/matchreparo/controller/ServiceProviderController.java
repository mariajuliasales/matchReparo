package com.mariajulia.matchreparo.controller;

import com.mariajulia.matchreparo.dto.request.ServiceProviderRequest;
import com.mariajulia.matchreparo.dto.response.ServiceProviderResponse;
import com.mariajulia.matchreparo.entity.ServiceProvider;
import com.mariajulia.matchreparo.mapper.ServiceProviderMapper;
import com.mariajulia.matchreparo.service.ServiceProviderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("matchreparo/service-providers")
public class ServiceProviderController {

    public final ServiceProviderService serviceProviderService;

    public ServiceProviderController(ServiceProviderService serviceProviderService) {
        this.serviceProviderService = serviceProviderService;
    }

    @GetMapping
    public ResponseEntity<List<ServiceProviderResponse>> findAll() {
        List<ServiceProvider> serviceProviders = serviceProviderService.findAll();
        List<ServiceProviderResponse> serviceProviderResponses = serviceProviders.stream()
                .map(ServiceProviderMapper::toServiceProviderResponse)
                .toList();

        return ResponseEntity.ok(serviceProviderResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceProviderResponse> findById(@PathVariable Long id) {
        return serviceProviderService.findById(id)
                .map(serviceProvider -> ResponseEntity.ok(ServiceProviderMapper.toServiceProviderResponse(serviceProvider)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceProviderResponse> update(@PathVariable Long id, @Valid @RequestBody ServiceProviderRequest serviceProviderRequest) {
        ServiceProvider serviceProvider = ServiceProviderMapper.toServiceProvider(serviceProviderRequest);
        return serviceProviderService.update(id, serviceProvider)
                .map(updatedServiceProvider -> ResponseEntity.ok(ServiceProviderMapper.toServiceProviderResponse(updatedServiceProvider)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        serviceProviderService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
