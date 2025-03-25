/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maw.belajar.service;

import com.maw.belajar.models.Product;
import com.maw.belajar.models.Suplier;
import com.maw.belajar.repository.ProductRepo;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hp
 */
@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    
    @Autowired
    private SuplierService suplierService;

    public Product create(Product product) {
        return productRepo.save(product);
    }

    public Product findById(Long id) {
        Optional<Product> product = productRepo.findById(id);
        if (!product.isPresent()) {
            return null;
        }
        return productRepo.findById(id).get();
    }

    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    public List<Product> findByName(String name) {
        return productRepo.findByNameContains(name);
    }

    public void addSupplier(Suplier suplier, Long productId) {
        Product product = findById(productId);
        if (product == null) {
            throw new RuntimeException("Product with ID" + productId + " not found");
        }
        product.getSupliers().add(suplier);
        create(product);
    }

    public Product findByProductName(String name) {
        return productRepo.findProductByName(name);
    }

    public Iterable<Product> findProduct(String name) {
        return productRepo.findProduct("%" + name + "%");
    }

    public Iterable<Product> findProductByCategory(Long categoryId) {
        return productRepo.findProductByCategory(categoryId);
    }

    public List<Product> findProductBySuplier(Long suplierId) {
        Suplier suplier = suplierService.findById(suplierId);
        if(suplier == null){
            return new ArrayList<Product>();
        }
        return productRepo.findProductBySupplier(suplier);
    }
}
