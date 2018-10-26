package com.develop.beer2js.controller;

import com.develop.beer2js.model.Barrel;
import com.develop.beer2js.repository.BarrelRepository;
import com.develop.beer2js.repository.ProviderRepository;
import com.develop.beer2js.repository.VarietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BarrelController {
    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private VarietyRepository varietyRepository;
    @Autowired
    private BarrelRepository barrelRepository;

    @GetMapping("/barrels")
    public List<Barrel> getAllBarrels(){
        return barrelRepository.findAll();
    }
    //en construcción
}
