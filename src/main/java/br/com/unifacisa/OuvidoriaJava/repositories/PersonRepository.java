package br.com.unifacisa.OuvidoriaJava.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.unifacisa.OuvidoriaJava.entities.Person;

public interface PersonRepository extends CrudRepository<Person, String>{
	
}
