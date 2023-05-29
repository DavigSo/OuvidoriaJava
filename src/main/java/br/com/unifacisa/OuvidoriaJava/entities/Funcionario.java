package br.com.unifacisa.OuvidoriaJava.entities;

import jakarta.persistence.Entity;

@Entity
public class Funcionario extends Person {

	public Funcionario(String nome, String email, String senha) {
		super(nome, email, senha);
		setStatusAdm(true);
	}

	public Funcionario() {
		
	}
}
