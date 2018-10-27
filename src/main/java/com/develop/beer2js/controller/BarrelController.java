package com.develop.beer2js.controller;

import com.develop.beer2js.exception.ResourceNotFoundException;
import com.develop.beer2js.model.Barrel;
import com.develop.beer2js.model.BarrelDTO;
import com.develop.beer2js.repository.BarrelRepository;
import com.develop.beer2js.repository.VarietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
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
                barrel.setCapacity(requestBarrel.getCapacity());
                return barrelRepository.save(barrel);
            }).orElseThrow(() -> new ResourceNotFoundException("Variety", "variety_id", varietyId));
    }
    @GetMapping("/barrels/{barrel_id}")
    public Barrel getBarrelById(@PathVariable(value = "barrel_id") Long barrel_id){
        return barrelRepository.findById(barrel_id)
                .orElseThrow(()->new ResourceNotFoundException("Barrel", "barrel_id", barrel_id));
    }

    @PutMapping("/barrels/{barrel_id}")
    public Barrel updateBarrel(@PathVariable(value = "barrel_id") Long barrel_id, @Valid @RequestBody BarrelDTO updatedBarrel){

        return barrelRepository.findById(barrel_id).map(barrel -> {
            barrel.setCharge(updatedBarrel.getCharge());
            barrel.setTapped(updatedBarrel.isTapped());
            return barrelRepository.save(barrel);
        }).orElseThrow(() -> new ResourceNotFoundException("Barrel", "barrel_id", barrel_id));
    }


}
