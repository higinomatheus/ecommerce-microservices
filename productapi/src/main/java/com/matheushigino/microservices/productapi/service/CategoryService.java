package com.matheushigino.microservices.productapi.service;

import com.matheushigino.microservices.productapi.dto.CategoryDTO;
import com.matheushigino.microservices.productapi.dto.ProductDTO;
import com.matheushigino.microservices.productapi.model.Category;
import com.matheushigino.microservices.productapi.model.Product;
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

    public CategoryDTO save(CategoryDTO categoryDTO){
        Category category = categoryRepository.save(Category.convert(categoryDTO));
        return CategoryDTO.convert(category);
    }

    public CategoryDTO editCategory(Long categoryId, CategoryDTO categoryDTO){
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new RuntimeException());

        if(categoryDTO.getNome() != null &&
            !category.getNome().equals(categoryDTO.getNome())){
            category.setNome(categoryDTO.getNome());
        }

        category = categoryRepository.save(category);
        return CategoryDTO.convert(category);
    }
}
