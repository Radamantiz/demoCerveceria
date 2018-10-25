package com.develop.beer2js.controller;

import com.develop.beer2js.model.Provider;
import com.develop.beer2js.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}
