/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maw.belajar.controllers;

import com.maw.belajar.dto.AppUserData;
import com.maw.belajar.dto.ResponseData;
import com.maw.belajar.models.AppUser;
import com.maw.belajar.service.AppUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hp
 */
@RestController
@RequestMapping("/api/users")
public class AppUserController {
    
    @Autowired
    private AppUserService appUserService;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @PostMapping("/register")
    private ResponseEntity<ResponseData<AppUser>> register(@RequestBody AppUserData appUserData){
    
        ResponseData<AppUser> responseData = new ResponseData<>();
        AppUser appUser = modelMapper.map(appUserData, AppUser.class);
        responseData.setPayload(appUserService.registerAppUser(appUser));
        responseData.getMessage().add("Success");
        responseData.setCode("00");
        return ResponseEntity.ok(responseData);
    }
    
}
