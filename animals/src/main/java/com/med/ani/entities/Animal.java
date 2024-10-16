package com.med.ani.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private Integer age;
	private String type;

	@ManyToOne
	@JoinColumn(name = "id_cat")
	private AnimalCategory animalCategory;

	public Animal() {
		super();
	}

	public Animal(String nom, Integer age, String type, AnimalCategory animalCategory) {
		super();
		this.nom = nom;
		this.age = age;
		this.type = type;
		this.animalCategory = animalCategory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public AnimalCategory getAnimalCategory() {
		return animalCategory;
	}

	public void setAnimalCategory(AnimalCategory animalCategory) {
		this.animalCategory = animalCategory;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nom=" + nom + ", age=" + age + ", type=" + type + ", animalCategory="
				+ animalCategory + "]";
	}
}
