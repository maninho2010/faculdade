package com.example.myproject.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("T")
public class Trabalhador extends Usuario{
	
	private static final long serialVersionUID = 1L;
	
	private Float rating;
	
	@ManyToOne
	private Categoria categoria;
	
	
	public Float getRating() {
		return rating;
	}
	public void setRating(Float rating) {
		this.rating = rating;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
