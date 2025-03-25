/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.maw.belajar.repository;

import com.maw.belajar.models.Suplier;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Hp
 */
public interface SuplierRepo extends CrudRepository<Suplier, Long>{
    
    Suplier findByEmail(String email);
    
    List<Suplier> findByNameContainsOrderByIdDesc(String name);
    
    List<Suplier> findByNameStartingWith(String prefix);
    
    List<Suplier> findByNameContainsOrEmailContains(String name, String email);
}
