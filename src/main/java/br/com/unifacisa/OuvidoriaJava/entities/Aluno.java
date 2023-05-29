package br.com.unifacisa.OuvidoriaJava.entities;

import jakarta.persistence.Entity;

@Entity
public class Aluno extends Person {

	public Aluno(String nome, String email, String senha) {
		super(nome, email, senha);
		setStatusAdm(false);
	}
	
	public Aluno() {
		
	}
}
