package com.med.ani.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nom", types = { Animal.class })
public interface AnimalProjection {
	public String getNom();
}
