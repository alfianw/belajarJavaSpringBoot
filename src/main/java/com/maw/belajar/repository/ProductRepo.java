/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.maw.belajar.repository;

import com.maw.belajar.models.Product;
import com.maw.belajar.models.Suplier;
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
    
    @Query("SELECT p FROM Product p WHERE p.name = :name")
    public Product findProductByName(@PathParam("name") String name);
    
    @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
    public List<Product> findProduct(@PathParam("name") String name);
    
    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    public List<Product> findProductByCategory(@PathParam("categoryId") Long categoryId);
    
    @Query("SELECT p FROM Product p WHERE :suplier MEMBER OF p.supliers")
    public List<Product> findProductBySupplier(@PathParam("suplier") Suplier suplier);
}
