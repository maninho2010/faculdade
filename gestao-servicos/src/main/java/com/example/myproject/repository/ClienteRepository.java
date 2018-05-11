package com.example.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myproject.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
}
