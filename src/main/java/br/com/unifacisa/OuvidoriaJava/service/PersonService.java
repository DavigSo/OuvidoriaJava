package br.com.unifacisa.OuvidoriaJava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacisa.OuvidoriaJava.entities.Person;
import br.com.unifacisa.OuvidoriaJava.repositories.ManifestRepository;
import br.com.unifacisa.OuvidoriaJava.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	ManifestRepository manifestRepository;

	@Autowired
	ManifestService manifestService;

	public void addPerson(Person pessoa) {

		personRepository.save(pessoa);
	}

	public Person findByEmail(String email) {
		List<Person> pessoas = (List<Person>) personRepository.findAll();
		for (Person pessoa : pessoas) {
			if (pessoa.getEmail().equals(email)) {
				return pessoa;
			}
		}
		return null;
	}

	public Boolean verificarLoginPessoa(String email, String senha) {
		Person pessoa = findByEmail(email);
		if (pessoa.getSenha().equals(senha)) {
			return true;
		}
		return false;
	}

	public boolean checarTipoPessoa(String email) {
		return findByEmail(email).isStatusAdm();
	}

	public String listarTodosAlunos() {
		Iterable<Person> todasPessoas = personRepository.findAll();
		List<Person> todosAlunos = ((List<Person>) todasPessoas).stream().filter(f -> f.isStatusAdm() == false)
				.toList();

		String result = " ";

		for (Person person : todosAlunos) {
			result += "Manifestações de " + person.getNome().toUpperCase() + ":\n" +	manifestService.listarAlunoEspecifico(person.getEmail());
		}

		
		return result + "\n";
	}

}
