/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maw.belajar.controllers;

import com.maw.belajar.dto.Response;
import com.maw.belajar.dto.ResponseData;
import com.maw.belajar.dto.SearchData;
import com.maw.belajar.dto.SuplierData;
import com.maw.belajar.models.Suplier;
import com.maw.belajar.service.SuplierService;
import jakarta.validation.Valid;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
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
@RequestMapping("/api/supliers")
public class SuplierController {

    @Autowired
    private SuplierService suplierService;

    @Autowired
    private ModelMapper ModelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<Suplier>> create(@Valid @RequestBody SuplierData suplierData, Errors errors) {
        ResponseData<Suplier> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setCode("50");
            responseData.getMessage().add("Data Not Found");
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        Suplier suplier = ModelMapper.map(suplierData, Suplier.class);

        responseData.setCode("00");
        responseData.getMessage().add("Success");
        responseData.setPayload(suplierService.create(suplier));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Suplier> findAll() {
        return suplierService.findAll();
    }

    @GetMapping("/{id}")
    public Suplier findById(@PathVariable("id") Long id) {
        return suplierService.findById(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Suplier>> update(@Valid @RequestBody SuplierData suplierData, Errors errors) {
        ResponseData<Suplier> responseData = new ResponseData<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessage().add(error.getDefaultMessage());
            }
            responseData.setCode("50");
            responseData.getMessage().add("Data Not Found");
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        Suplier suplier = ModelMapper.map(suplierData, Suplier.class);

        responseData.setCode("00");
        responseData.getMessage().add("Success");
        responseData.setPayload(suplierService.create(suplier));
        return ResponseEntity.ok(responseData);
    }

    @PostMapping("search/email")
    public Response<Suplier> findByEmail(@RequestBody SearchData searchData) {
        Response<Suplier> response = new Response<>();
        Suplier suplier = suplierService.findByEmail(searchData.getSearchKey());
        if (suplier == null) {
            response.setCode("50");
            response.setMessage("Data Not Found");
        } else {
            response.setCode("00");
            response.setMessage("Success");
            response.setResponse(suplier);
        }
        return response;
    }

    @PostMapping("search/name")
    public List<Suplier> findByName(@RequestBody SearchData searchData) {
        return suplierService.findByName(searchData.getSearchKey());
    }

    @PostMapping("search/nameStart")
    public List<Suplier> findByNameStart(@RequestBody SearchData searchData) {
        return suplierService.findByNameStart(searchData.getSearchKey());
    }

    @PostMapping("search/nameOrEmail")
    public List<Suplier> findByNameOrEmail(@RequestBody SearchData searchData) {
        return suplierService.findByNameOrEmali(searchData.getSearchKey(), searchData.getOtherSearchKey());
    }
}
