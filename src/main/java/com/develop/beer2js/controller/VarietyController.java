package com.develop.beer2js.controller;
import com.develop.beer2js.exception.ResourceNotFoundException;
import com.develop.beer2js.model.Variety;
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

    @GetMapping("/varieties")
    public List<Variety> getVaritys(){
        return varietyRepository.findAll();
    }
    @PostMapping("/varieties")
    public Variety addVarity(@Valid @RequestBody Variety variety){
        return varietyRepository.save(variety);
    }

    @GetMapping("/varieties/{varietyId}")
    public Variety getVarityById(@PathVariable(value = "varietyId") Long varietyId){
        return varietyRepository.findById(varietyId)
                .orElseThrow(() -> new ResourceNotFoundException("variety", "varietyId",varietyId));
    }
    @PutMapping("/varieties/{varietyId}")
    public Variety updateVarity(@PathVariable(value = "varietyId") Long varietyId, @Valid @RequestBody Variety varietyDetails){
        Variety variety = varietyRepository.findById(varietyId)
                .orElseThrow(() -> new ResourceNotFoundException("variety", "varietyId",varietyId));
        variety.setName(varietyDetails.getName());
        return varietyRepository.save(variety);
    }
    @DeleteMapping("/varieties/{varietyId}")
    public ResponseEntity<?> deleteVarity(@PathVariable(value = "varietyId") Long varietyId){
        Variety variety = varietyRepository.findById(varietyId)
                .orElseThrow(() -> new ResourceNotFoundException("variety", "varietyId",varietyId));
        varietyRepository.delete(variety);
        return ResponseEntity.ok().build();
    }
}