package com.develop.beer2js.controller;

import com.develop.beer2js.exception.ResourceNotFoundException;
import com.develop.beer2js.model.SalePoint;
import com.develop.beer2js.repository.SalePointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SalePointController {

    @Autowired
    private SalePointRepository salePointRepository;

    @GetMapping("/salepoints")
    public List<SalePoint> getSalesPoint(){
        return salePointRepository.findAll();
    }

    @GetMapping("/salepoints/{salepoint_id}")
    public SalePoint getSalePointById(@PathVariable("salepoint_id") Long salepoint_id){
        return  salePointRepository.findById(salepoint_id).orElseThrow(()->
              new ResourceNotFoundException("salepoint","salepoint_id",salepoint_id));

    }

    @PostMapping("/salepoints")
    public SalePoint addSalePoint(@Valid @RequestBody SalePoint salePoint){
        return salePointRepository.save(salePoint);
    }

    @PutMapping("/salepoints/{salepoint_id}")
    public SalePoint updateSalePoint(@PathVariable ("salepoint_id") Long salePoint_id,
                                     @RequestBody SalePoint salePointInformation)
    {
        return salePointRepository.findById(salePoint_id)
                .map(salepoint -> {
                    salepoint.setAddress(salePointInformation.getAddress());
                    salepoint.setManager_name(salePointInformation.getManager_name());
                    salepoint.setPhone_number(salePointInformation.getPhone_number());
                    salepoint.setName(salePointInformation.getName());
                    return salePointRepository.save(salepoint);
                        }
                ).orElseThrow(()-> new ResourceNotFoundException("SalePoint", "salepoint_id",salePoint_id));
    }

    @DeleteMapping("/salepoints/{salepoint_id}")
    public SalePoint deleteSalePoint(@PathVariable ("salepoint_id") Long salePoint_id){
       return salePointRepository.findById(salePoint_id).map(salePoint -> {
           salePoint.setDeleted(true);
           return salePointRepository.save(salePoint);
       }).orElseThrow(()-> new ResourceNotFoundException("SalePoint", "salepoint_id",salePoint_id));
    }

}
