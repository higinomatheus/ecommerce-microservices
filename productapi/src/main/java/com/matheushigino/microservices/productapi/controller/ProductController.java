package com.matheushigino.microservices.productapi.controller;

import com.matheushigino.microservices.productapi.dto.ProductDTO;
import com.matheushigino.microservices.productapi.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> getProducts(){
        return productService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO newProduct(@Valid @RequestBody ProductDTO productDTO){
        return productService.save(productDTO);
    }
}
