package br.com.unifacisa.OuvidoriaJava.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Person {

	@Id
	private String email;

	private String nome;
	private String senha;
	private boolean statusAdm;


	public Person(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;

	}

	public Person() {

	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isStatusAdm() {
		return statusAdm;
	}

	public void setStatusAdm(boolean statusAdm) {
		this.statusAdm = statusAdm;
	}

	@Override
	public String toString() {
		return "Person [ nome=" + nome + ", email=" + email + "]";
	}

}
