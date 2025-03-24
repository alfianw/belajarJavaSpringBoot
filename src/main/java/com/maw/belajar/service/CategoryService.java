/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maw.belajar.service;

import com.maw.belajar.models.Category;
import com.maw.belajar.repository.CategoryRepo;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hp
 */
@Service
@Transactional
public class CategoryService {
    
    @Autowired
    private CategoryRepo categoryRepo;

    public Category create(Category category){
    return categoryRepo.save(category);
    }
    
    public  Category findById(Long id){
        Optional<Category> category = categoryRepo.findById(id);
        if(!category.isPresent()){
        return null;
        }
        return category.get();
    }
    
    public  Iterable<Category> findAll(){
        return categoryRepo.findAll();
    }
    
    public void delete(Long id){
        categoryRepo.deleteById(id);
    }
}
