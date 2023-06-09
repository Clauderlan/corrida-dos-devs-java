package com.c7.corrida.services;

import com.c7.corrida.entities.Category;
import com.c7.corrida.repositories.CategoryRepository;
import com.c7.corrida.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }
    public Category findById(Long id){
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
