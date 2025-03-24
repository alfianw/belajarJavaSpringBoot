/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maw.belajar.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author Hp
 */
@Entity
@Table(name = "tbl_product")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
         property = "id"
)
public class Product implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "Name is Required")
    @Column(name = "product_name", length = 100, nullable = false)
    private String name;
    
    @NotEmpty(message = "Description is Required")
    @Column(name = "product_Description", length = 255)
    private String description;
    
    private double price;
    
    @ManyToOne
    private Category category;
    
//    @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "tbl_product_suplier", 
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "suplier_id"))
    private Set<Suplier> supliers;

    public Product() {
    }

    public Product(Long id, String name, String Description, double price) {
        this.id = id;
        this.name = name;
        this.description = Description;
        this.price = price;
    }

    public Set<Suplier> getSupliers() {
        return supliers;
    }

    public void setSupliers(Set<Suplier> supliers) {
        this.supliers = supliers;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String Description) {
        this.description = Description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    
    
}
