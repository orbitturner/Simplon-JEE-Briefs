package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Pharmacie;

@RestController
public class pharmacieController {
	@Autowired
	private PharmacieRepository phRepository;
	
	@GetMapping({"/pharmacie"})
	public List<Pharmacie> getAll(){
		return phRepository.findAll();
	}
	
	@GetMapping({"/pharmacie/{id}"})
	public Optional<Pharmacie> getOneById(@PathVariable int id){
		Optional<Pharmacie> ph = phRepository.findById(id);
		return ph;
	}
	
	@PostMapping(path={"/pharmacie"},consumes = {"application/json"})
	public Optional<Pharmacie> insertOne(@RequestBody() Pharmacie ph){
		phRepository.save(ph);
		return phRepository.findById(ph.getId());
	}
	
	@DeleteMapping({"/pharmacie/{id}"})
	public String deleteOne(@PathVariable() int id) {
		phRepository.deleteById(id);
		return "SUCCESS";
	}
	
	@PutMapping(path= {"/pharmacie/{id}"},consumes = {"application/json"})
	public String updatePharmacie(@RequestBody() Pharmacie ph,@PathVariable(name="id") int id) {
		ph.setId(id);
		phRepository.save(ph);
		return "SUCCESS";
	}
	
	
}
