package br.com.unifacisa.OuvidoriaJava.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Manifest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String autor;

	private String descricao;
	private String tipo;

	public Manifest(String descricao, String tipo, String autor) {
		super();
		this.descricao = descricao;
		this.tipo = tipo;
		this.autor = autor;
	}

	public Manifest() {

	}
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Id da manifestacao= " + id + " | " + "Tipo=" + tipo  + " | " + "Descricao= " + descricao;
	}

}
