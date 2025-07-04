package com.mariajulia.matchreparo.controller;

import com.mariajulia.matchreparo.dto.request.ServiceProviderRequest;
import com.mariajulia.matchreparo.dto.response.ServiceProviderResponse;
import com.mariajulia.matchreparo.entity.ServiceProvider;
import com.mariajulia.matchreparo.mapper.ServiceProviderMapper;
import com.mariajulia.matchreparo.service.ServiceProviderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    public ResponseEntity<ServiceProviderResponse> create(@Valid @RequestBody ServiceProviderRequest serviceProviderRequest) {
        ServiceProvider serviceProvider = ServiceProviderMapper.toServiceProvider(serviceProviderRequest);
        ServiceProvider serviceProviderCreated = serviceProviderService.create(serviceProvider);
        ServiceProviderResponse serviceProviderResponse = ServiceProviderMapper.toServiceProviderResponse(serviceProviderCreated);

        return ResponseEntity.status(HttpStatus.CREATED).body(serviceProviderResponse);
    }

    @GetMapping
    public ResponseEntity<List<ServiceProviderResponse>> findAll() {
        List<ServiceProvider> serviceProviders = serviceProviderService.findAll();
        List<ServiceProviderResponse> serviceProviderResponses = serviceProviders.stream()
                .map(ServiceProviderMapper::toServiceProviderResponse)
                .toList();

        return ResponseEntity.ok(serviceProviderResponses);
    }

}
