package com.matheushigino.microservices.productapi.controller;

import com.matheushigino.microservices.productapi.dto.CategoryDTO;
import com.matheushigino.microservices.productapi.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryDTO> getAll(){
        return categoryService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO newCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        return categoryService.save(categoryDTO);
    }

    @PatchMapping("/{id}")
    public CategoryDTO editCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
        return categoryService.editCategory(id, categoryDTO);
    }
}
