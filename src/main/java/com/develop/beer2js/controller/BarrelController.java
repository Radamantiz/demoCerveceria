package com.develop.beer2js.controller;

import com.develop.beer2js.exception.ResourceNotFoundException;
import com.develop.beer2js.model.Barrel;
import com.develop.beer2js.model.BarrelDTO;
import com.develop.beer2js.repository.BarrelRepository;
import com.develop.beer2js.repository.VarietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BarrelController {

    @Autowired
    private VarietyRepository varietyRepository;
    @Autowired
    private BarrelRepository barrelRepository;

    @GetMapping("/barrels")
    public List<Barrel> getAllBarrels(){
        return barrelRepository.findAll();
    }

    @PostMapping("/barrels")
    public Barrel createBarrel(@Valid @RequestBody BarrelDTO requestBarrel){
            Barrel barrel = new Barrel();
            Long varietyId = requestBarrel.getVariety_id();
            return varietyRepository.findById(varietyId).map(variety -> {
                barrel.setVariety(variety);
                barrel.setTapped(false);
                barrel.setCharge(requestBarrel.getCharge());
                return barrelRepository.save(barrel);
            }).orElseThrow(() -> new ResourceNotFoundException("Variety", "variety_id", varietyId));
    }
    //en construcción
}
