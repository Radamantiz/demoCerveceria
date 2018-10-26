package com.develop.beer2js.controller;
import com.develop.beer2js.exception.ResourceNotFoundException;
import com.develop.beer2js.model.Variety;
import com.develop.beer2js.repository.ProviderRepository;
import com.develop.beer2js.repository.VarietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class VarietyController {

    @Autowired
    private VarietyRepository varietyRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @GetMapping("/providers/{providerId}/varieties")
    public Page<Variety> getAllVarietysByProviderId(@PathVariable (value = "providerId") Long providerId,
                                                Pageable pageable) {
        return varietyRepository.findByProviderId(providerId, pageable);
    }

    @PostMapping("/providers/{providerId}/varieties")
    public Variety createVariety(@PathVariable (value = "providerId") Long providerId,
                                 @Valid @RequestBody Variety variety) {
        return providerRepository.findById(providerId).map(provider -> {
            variety.setProvider(provider);
            return varietyRepository.save(variety);
        }).orElseThrow(() -> new ResourceNotFoundException("Provider","id",providerId));
    }

    @PutMapping("/providers/{providerId}/varieties/{varietyId}")
    public Variety updateVariety(@PathVariable (value = "providerId") Long providerId,
                                 @PathVariable (value = "varietyId") Long varietyId,
                                 @Valid @RequestBody Variety varietyRequest) {
        if(!providerRepository.existsById(providerId)) {
            throw new ResourceNotFoundException("Provider", "id", providerId);
        }

        return varietyRepository.findById(varietyId).map(variety -> {
            variety.setName(varietyRequest.getName());
            variety.setProvider(varietyRequest.getProvider());
            variety.setActive(varietyRequest.isActive());
            return varietyRepository.save(variety);
        }).orElseThrow(() -> new ResourceNotFoundException("VarityId ","id",varietyId));
    }

    @DeleteMapping("/providers/{providerId}/varieties/{varietyId}")
    public ResponseEntity<?> deleteVariety(@PathVariable (value = "providerId") Long providerId,
                                           @PathVariable (value = "varietyId") Long varietyId) {
        if(!providerRepository.existsById(providerId)) {
            throw new ResourceNotFoundException("Provider", "id", providerId);
        }

        return varietyRepository.findById(varietyId).map(variety -> {
            varietyRepository.delete(variety);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("VarityId ","id",varietyId));
    }
}