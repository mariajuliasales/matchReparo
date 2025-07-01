package com.mariajulia.matchreparo.controller;

import com.mariajulia.matchreparo.dto.request.ServiceProviderRequest;
import com.mariajulia.matchreparo.dto.response.ServiceProviderResponse;
import com.mariajulia.matchreparo.entity.ServiceProvider;
import com.mariajulia.matchreparo.mapper.ServiceProviderMapper;
import com.mariajulia.matchreparo.service.ServiceProviderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-providers")
public class ServiceProviderController {

    public final ServiceProviderService serviceProviderService;

    public ServiceProviderController(ServiceProviderService serviceProviderService) {
        this.serviceProviderService = serviceProviderService;
    }

    @PostMapping
    public ServiceProviderResponse save(@Valid @RequestBody ServiceProviderRequest serviceProviderRequest) {
        ServiceProvider serviceProvider = ServiceProviderMapper.toServiceProvider(serviceProviderRequest);
        return ServiceProviderMapper.toServiceProviderResponse(serviceProviderService.save(serviceProvider));
    }
}
