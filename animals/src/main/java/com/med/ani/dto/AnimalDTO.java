package com.med.ani.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.med.ani.entities.AnimalCategory;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnimalDTO {
	private Long id;
	private String nom;
	private String type;
	private Integer age;
	private String nomcat;
	private AnimalCategory animalCategory;
	
}
