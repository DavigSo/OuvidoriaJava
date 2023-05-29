package br.com.unifacisa.OuvidoriaJava.entities;

import jakarta.persistence.Entity;

@Entity
public class Reclamacao extends Manifest {

	public Reclamacao(String descricao, String tipo, String autor) {
		super(descricao, tipo, autor);
	}

	public Reclamacao() {

	}
}
