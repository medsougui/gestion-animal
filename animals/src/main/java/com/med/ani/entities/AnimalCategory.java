package com.med.ani.entities;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AnimalCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCat;
	private String nomCat;
	private String descriptionCat;

	@JsonIgnore
	@OneToMany(mappedBy = "animalCategory")
	private List<Animal> animals;

	public AnimalCategory(String nomCat, String descriptionCat) {
		this.nomCat = nomCat;
		this.descriptionCat = descriptionCat;
	}

	public Long getidCat() {
		return idCat;
	}

	public void setidCat(Long idCat) {
		this.idCat = idCat;
	}

	public String getNomCat() {
		return nomCat;
	}

	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}

	public String getDescriptionCat() {
		return descriptionCat;
	}

	public void setDescriptionCat(String descriptionCat) {
		this.descriptionCat = descriptionCat;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}
}
