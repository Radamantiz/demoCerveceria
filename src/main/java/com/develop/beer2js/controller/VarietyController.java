package com.develop.beer2js.controller;
import com.develop.beer2js.exception.ResourceNotFoundException;
import com.develop.beer2js.model.Variety;
import com.develop.beer2js.model.VarietyDTO;
import com.develop.beer2js.repository.ColorRepository;
import com.develop.beer2js.repository.ProviderRepository;
import com.develop.beer2js.repository.VarietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class VarietyController {

    @Autowired
    private VarietyRepository varietyRepository;
    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private ColorRepository colorRepository;
    @GetMapping("/varieties")
    public List<Variety> getVaritys(){
        return varietyRepository.findAll();
    }

    @PostMapping("/varieties")
    public Variety addVarity(@Valid @RequestBody VarietyDTO requestVariety){

        return providerRepository.findById(requestVariety.getProvider_id()).map(provider -> {
            return colorRepository.findById(requestVariety.getColor_id()).map(color -> {
                Variety variety = new Variety();
                variety.setName(requestVariety.getName());
                variety.setActive(requestVariety.isActive());
                variety.setPint_price(requestVariety.getPint_price());
                variety.setHalf_pint_price(requestVariety.getHalf_pint_price());
                variety.setBottle_price(requestVariety.getBottle_price());
                variety.setIbu(requestVariety.getIbu());
                variety.setAlcohol_percentage(requestVariety.getAlcohol_percentage());
                variety.setProvider(provider);
                variety.setColor(color);
                return varietyRepository.save(variety);
            }).orElseThrow(()-> new ResourceNotFoundException("Color", "color_id",requestVariety.getColor_id()));
        }).orElseThrow(()-> new ResourceNotFoundException("Provider", "provider_id", requestVariety.getProvider_id()));
    }

    @GetMapping("/varieties/{varietyId}")
    public Variety getVarityById(@PathVariable(value = "varietyId") Long varietyId){
        return varietyRepository.findById(varietyId)
                .orElseThrow(() -> new ResourceNotFoundException("variety", "variety_id",varietyId));
    }
    @PutMapping("/varieties/{varietyId}")
    public Variety updateVarity(@PathVariable(value = "varietyId") Long varietyId, @Valid @RequestBody VarietyDTO varietyDetails){

        return varietyRepository.findById(varietyId).map(variety -> {
            variety.setActive(varietyDetails.isActive());
            variety.setName(varietyDetails.getName());
            variety.setAlcohol_percentage(varietyDetails.getAlcohol_percentage());
            variety.setPint_price(varietyDetails.getPint_price());
            variety.setHalf_pint_price(varietyDetails.getHalf_pint_price());
            variety.setIbu(varietyDetails.getIbu());
            return varietyRepository.save(variety);
        }).orElseThrow(()-> new ResourceNotFoundException("Variety", "variety_id:", varietyId));
    }
    @DeleteMapping("/varieties/{varietyId}")
    public ResponseEntity<?> deleteVarity(@PathVariable(value = "varietyId") Long varietyId){

       return varietyRepository.findById(varietyId).map(variety -> {
            varietyRepository.delete(variety);
           return ResponseEntity.ok().build();
       }).orElseThrow(()-> new ResourceNotFoundException("Variety", "variety_id", varietyId));
    }
}