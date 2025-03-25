/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maw.belajar.service;

import com.maw.belajar.models.Suplier;
import com.maw.belajar.repository.SuplierRepo;
import jakarta.transaction.Transactional;
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
public class SuplierService {

    @Autowired
    private SuplierRepo suplierRepo;

    public Suplier create(Suplier suplier) {
        return suplierRepo.save(suplier);
    }

    public Suplier findById(Long id) {
        Optional<Suplier> suplier = suplierRepo.findById(id);
        if (!suplier.isPresent()) {
            return null;
        }
        return suplier.get();
    }

    public Iterable<Suplier> findAll() {
        return suplierRepo.findAll();
    }

    public void delete(Long id) {
        suplierRepo.deleteById(id);
    }
    
    public Suplier findByEmail(String email){
        return suplierRepo.findByEmail(email);
    }
    
    public List<Suplier> findByName(String name){
        return suplierRepo.findByNameContainsOrderByIdDesc(name);
    }
    
    public List<Suplier> findByNameStart(String prefix){
        return suplierRepo.findByNameStartingWith(prefix);
    }
    
    public List<Suplier> findByNameOrEmali(String name,String email){
        return suplierRepo.findByNameContainsOrEmailContains(name, email);
    }
}
