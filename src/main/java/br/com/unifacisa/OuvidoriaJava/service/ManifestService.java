package br.com.unifacisa.OuvidoriaJava.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unifacisa.OuvidoriaJava.entities.Manifest;
import br.com.unifacisa.OuvidoriaJava.repositories.ManifestRepository;

@Service
public class ManifestService {

	@Autowired
	ManifestRepository manifestRepository;

	public void addManifest(Manifest manifest) {
		manifestRepository.save(manifest);
	}
	
	public String listarAlunoEspecifico(String email) {
		List<Manifest> todasManifestacoes = (List<Manifest>) manifestRepository.findAll();
		List<Manifest> manifestacoesDoUsuario = ((List<Manifest>) todasManifestacoes).stream()
				.filter(f -> f.getAutor().equals(email)).collect(Collectors.toList());

		String result = "";

		for (Manifest manifestacao : manifestacoesDoUsuario) {
		    result += manifestacao.toString() + "\n";
		}
		

		return result;
	}


	public void deletarManifest(int id) {
		manifestRepository.deleteById(id);

	}

}
