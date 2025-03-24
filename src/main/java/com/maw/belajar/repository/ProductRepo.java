/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.maw.belajar.repository;

import com.maw.belajar.models.Product;
import jakarta.websocket.server.PathParam;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Hp
 */
public interface ProductRepo extends CrudRepository<Product, Long>{
    
    List<Product> findByNameContains(String name);
    
//    @Query("SELECT p FROM Product p WHERE p.name = :name")
//    public Product findProductByName(@PathParam("name") String name);
}
