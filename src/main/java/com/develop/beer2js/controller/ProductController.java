package com.develop.beer2js.controller;

import com.develop.beer2js.exception.ResourceNotFoundException;
import com.develop.beer2js.model.Product;
import com.develop.beer2js.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productRepository.findAll();
    }
    @PostMapping("/products")
    public Product addProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }
    @PutMapping("/products/{product_id}")
    public Product updateProduct(@PathVariable("product_id") Long product_id, @RequestBody Product productDetail){
        return productRepository.findById(product_id).map(product -> {
            product.setName(productDetail.getName());
            product.setPrice(productDetail.getPrice());
            return productRepository.save((product));
        }).orElseThrow(()-> new ResourceNotFoundException("Product","product_id",product_id));
    }
    @DeleteMapping("/products/{product_id}")
    public Product deleteProduct(@PathVariable("product_id") Long product_id){
        return productRepository.findById(product_id).map(product -> {
            product.setDeleted(true);
            return productRepository.save(product);
        }).orElseThrow(()->new ResourceNotFoundException("Product","product_id",product_id));
    }
}
