/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.maw.belajar.repository;

import com.maw.belajar.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Hp
 */
public interface CategoryRepo extends JpaRepository<Category, Long> {

    Page<Category> findByCategoryNameContains(String categoryName, Pageable pageable);
    
}
