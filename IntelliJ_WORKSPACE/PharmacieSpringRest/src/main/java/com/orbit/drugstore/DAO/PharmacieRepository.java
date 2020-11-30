package com.example.demo.controller;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Pharmacie;

public interface PharmacieRepository  extends JpaRepository<Pharmacie, Integer> {

}
