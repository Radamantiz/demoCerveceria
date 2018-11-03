package com.develop.beer2js.controller;

import com.develop.beer2js.exception.ResourceNotFoundException;
import com.develop.beer2js.model.Color;
import com.develop.beer2js.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ColorController {
    @Autowired
     private ColorRepository colorRepository;

    @GetMapping("/colors")
    public List<Color> getColors(){
        return  colorRepository.findAll();
    }
    @GetMapping("/colors/{color_id)")
    public Color getColorById(@PathParam(value = "color_id") long color_id) {
        return colorRepository.findById(color_id)
                .orElseThrow(()-> new ResourceNotFoundException("Color","color_id",color_id));               

    }
    @PostMapping("/colors")
    public Color addColor(@Valid @RequestBody Color color){
        return colorRepository.save(color);
    }

    @DeleteMapping("/colors/{color_id)")
    public Color deleteColor(@PathParam(value = "color_id") long color_id){
        return colorRepository.findById(color_id).map(color -> {
            color.setDeleted(true);
            return  colorRepository.save(color);
        }).orElseThrow(()-> new ResourceNotFoundException("Color","color_id",color_id));
    }
}
