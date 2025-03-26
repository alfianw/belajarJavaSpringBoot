/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.maw.belajar.repository;

import com.maw.belajar.models.AppUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Hp
 */
public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    
    Optional<AppUser> findByEmail(String email);
}
