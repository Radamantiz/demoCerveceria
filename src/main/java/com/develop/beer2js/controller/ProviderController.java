package com.develop.beer2js.controller;

import com.develop.beer2js.exception.ResourceNotFoundException;
import com.develop.beer2js.model.Provider;
import com.develop.beer2js.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProviderController {

    @Autowired
    ProviderRepository providerRepository;

    @GetMapping("/providers")
    public List<Provider> getProviders(){
        return providerRepository.findAll();
    }
    @PostMapping("/providers")
    public Provider addProvider(@Valid @RequestBody Provider provider){
        return providerRepository.save(provider);
    }

    @GetMapping("providers/{postId}")
    public Provider getProviderById(@PathVariable(value = "postId") Long providerId){
        return providerRepository.findById(providerId)
                .orElseThrow(() -> new ResourceNotFoundException("provider", "postId",providerId));
    }
    @PutMapping("/providers/{postId}")
    public Provider updateProvider(@PathVariable(value = "postId") Long providerId, @Valid @RequestBody Provider providerDetails){
        Provider provider = providerRepository.findById(providerId)
                .orElseThrow(() -> new ResourceNotFoundException("provider", "postId",providerId));
        provider.setName(providerDetails.getName());
        provider.setContactNumber(providerDetails.getContactNumber());
        provider.setContactRefName(providerDetails.getContactRefName());
        provider.setEmail(providerDetails.getEmail());
        Provider updateProvider = providerRepository.save(provider);
        return updateProvider;
    }
    @DeleteMapping("/providers/{postId}")
    public ResponseEntity<?> deleteProvider(@PathVariable(value = "postId") Long providerId){
        Provider provider = providerRepository.findById(providerId)
                .orElseThrow(() -> new ResourceNotFoundException("provider", "postId",providerId));
        providerRepository.delete(provider);
        return ResponseEntity.ok().build();
    }

}
