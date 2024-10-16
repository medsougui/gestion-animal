package com.med.ani;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import com.med.ani.entities.Animal;
import com.med.ani.entities.AnimalCategory;

@SpringBootApplication
public class AnimalsApplication implements CommandLineRunner {

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(AnimalsApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {
	repositoryRestConfiguration.exposeIdsFor(Animal.class,AnimalCategory.class);
	}
	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}
	

}
