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

    @GetMapping("/providers/{provider_id}")
    public Provider getProviderById(@PathVariable(value = "provider_id") Long providerId){
        return providerRepository.findById(providerId)
                .orElseThrow(() -> new ResourceNotFoundException("provider", "provider_id",providerId));
    }
    @PutMapping("/providers/{provider_id}")
    public Provider updateProvider(@PathVariable(value = "provider_id") Long providerId, @Valid @RequestBody Provider providerDetails){

      return providerRepository.findById(providerId).map(provider -> {
          provider.setName(providerDetails.getName());
          provider.setContactNumber(providerDetails.getContactNumber());
          provider.setContactRefName(providerDetails.getContactRefName());
          provider.setEmail(providerDetails.getEmail());
          return providerRepository.save(provider);
      }).orElseThrow(()-> new ResourceNotFoundException("Provider","provider_id",providerId));
    }

    @DeleteMapping("/providers/{provider_id}")
    public ResponseEntity<?> deleteProvider(@PathVariable(value = "provider_id") Long providerId){

        return providerRepository.findById(providerId).map(provider -> {
             providerRepository.delete(provider);
             return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException("Provider","provider_id",providerId));
    }

}
