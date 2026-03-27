package com.matheushigino.microservices.productapi.service;

import com.matheushigino.microservices.productapi.dto.CategoryDTO;
import com.matheushigino.microservices.productapi.model.Category;
import com.matheushigino.microservices.productapi.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryDTO> getAll(){
        List<Category> categories =  categoryRepository.findAll();
        return categories
                .stream()
                .map(CategoryDTO::convert)
                .collect(Collectors.toList());
    }

}
