package com.example.myproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String imagem;
	
	@OneToMany(mappedBy= "categoria")
	private List<Trabalhador> trabalhadores;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public List<Trabalhador> getTrabalhadores() {
		return trabalhadores;
	}
	public void setTrabalhadores(List<Trabalhador> trabalhadores) {
		this.trabalhadores = trabalhadores;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
