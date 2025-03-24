/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maw.belajar.controllers;

import com.maw.belajar.dto.ResponseData;
import com.maw.belajar.dto.SearchData;
import com.maw.belajar.models.Product;
import com.maw.belajar.models.Suplier;
import com.maw.belajar.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hp
 */
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseData<Product>> create(@Valid @RequestBody Product product, Errors errors) {

        ResponseData<Product> responseData = new ResponseData<>();

        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setPayload(null);
            responseData.setCode("50");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setCode("00");
        responseData.getMessage().add("Success");
        responseData.setPayload(productService.create(product));
        return ResponseEntity.ok(responseData);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Product>> update(@Valid @RequestBody Product product, Errors e) {

        ResponseData<Product> responseData = new ResponseData<>();

        if (e.hasErrors()) {
            for (ObjectError error : e.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setCode("50");
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        responseData.setCode("00");
        responseData.getMessage().add("Success");
        responseData.setPayload(productService.create(product));
        return ResponseEntity.ok(responseData);
        
    }
    
//    @GetMapping
//    public  Iterable<Product> findByName(String name){
//     return productService.findByName(name);
//    }

    @GetMapping
    public Iterable<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        productService.delete(id);
    }
    
//    @PostMapping("/search/name")
//    public Product findProductByName(@RequestBody SearchData searchData){
//        return productService.findByProductName(searchData.getSearchKey());
//    }
    @PostMapping("/{id}")
    public void addSupplier(@RequestBody Suplier suplier, @PathVariable("id") Long productId){
        productService.addSupplier(suplier, productId);
    }
}
