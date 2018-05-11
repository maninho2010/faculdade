package com.example.myproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myproject.model.Categoria;
import com.example.myproject.model.Trabalhador;

public interface TrabalhadorRepository extends JpaRepository<Trabalhador, String>{

	List<Trabalhador> findByCategoria(Categoria categoria);
}
