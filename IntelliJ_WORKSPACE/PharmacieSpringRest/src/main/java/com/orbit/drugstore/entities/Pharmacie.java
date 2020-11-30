package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pharmacie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id ;
	String nom;
	String quartier;
	String ville;
	@Override
	public String toString() {
		return "Pharmacie [id=" + id + ", nom=" + nom + ", quartier=" + quartier + ", ville=" + ville + ", etat=" + etat
				+ "]";
	}
	int etat;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getQuartier() {
		return quartier;
	}
	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	
	
	
	
}
