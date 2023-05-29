package br.com.unifacisa.OuvidoriaJava.entities;

import jakarta.persistence.Entity;

@Entity
public class Elogio extends Manifest {

	public Elogio(String descricao, String tipo, String autor) {
		super(descricao, tipo, autor);
	}

	public Elogio() {
		
	}
}
