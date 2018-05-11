package com.example.myproject.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Role {
	
	@Id
	public String nomeRole;

	@ManyToMany(mappedBy="roles")
	private List<Usuario> usuarios;
	
	@Override
	public String toString() {
		return "Role [nomeRole=" + nomeRole + "]";
	}

	public String getNomeRole() {
		return nomeRole;
	}

	public void setNomeRole(String nomeRole) {
		this.nomeRole = nomeRole;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
