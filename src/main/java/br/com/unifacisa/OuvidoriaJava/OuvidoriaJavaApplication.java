package br.com.unifacisa.OuvidoriaJava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.unifacisa.OuvidoriaJava.entities.Aluno;
import br.com.unifacisa.OuvidoriaJava.entities.Elogio;
import br.com.unifacisa.OuvidoriaJava.entities.Funcionario;
import br.com.unifacisa.OuvidoriaJava.entities.Manifest;
import br.com.unifacisa.OuvidoriaJava.entities.Person;
import br.com.unifacisa.OuvidoriaJava.entities.Reclamacao;
import br.com.unifacisa.OuvidoriaJava.repositories.PersonRepository;
import br.com.unifacisa.OuvidoriaJava.service.ManifestService;
import br.com.unifacisa.OuvidoriaJava.service.PersonService;
import br.com.unifacisa.OuvidoriaJava.utilities.Teclado;

@SpringBootApplication
public class OuvidoriaJavaApplication implements CommandLineRunner {

	@Autowired
	PersonRepository personRepository;

	@Autowired
	PersonService personService;

	@Autowired
	ManifestService manifestService;

	public static void main(String[] args) {
		SpringApplication.run(OuvidoriaJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// classe teclado para setar scanner entre outros utilities

		// Menu de cadastramento/login
		boolean menuInicial = true;
		while (menuInicial) {
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			System.out.println("Escolha a opção para seguir: ");
			System.out.println("1 - Cadastrar");
			System.out.println("2 - Login");
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
			int opcaoDoMenu = Teclado.lerInt("Digite sua opcao: ");

			switch (opcaoDoMenu) {

			// Cadastramento de usuario
			case 1:

				boolean menuDeCadastro = true;
				while (menuDeCadastro) {

					System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
					System.out.println("Escolha como voce quer se cadastrar: ");
					System.out.println("1 - Aluno");
					System.out.println("2 - Funcionario");
					System.out.println("3 - Voltar para menu inicial.");
					System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
					int opcaoDeUsuario = Teclado.lerInt("Digite sua opcao: ");

					if (opcaoDeUsuario == 3) {

						menuDeCadastro = false;
						break;

					} else {

						System.out.println("\n-*-*-*-*-*-* CADASTRE-SE -*-*-*-*-*-*");
						String nomeDaPessoa = Teclado.lerString("Digite seu nome: ");
						String emailDaPessoa = Teclado.lerString("Email:");
						String senhaDaPessoa = Teclado.lerString("Senha: ");
						System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");

						switch (opcaoDeUsuario) {
						// Cadastro aluno
						case 1:

							Person novoAluno = new Aluno(nomeDaPessoa, emailDaPessoa, senhaDaPessoa);
							personService.addPerson((Aluno) novoAluno);

							menuDeCadastro = false;
							break;

						// Cadastro funcionario
						case 2:

							Person novoFuncionario = new Funcionario(nomeDaPessoa, emailDaPessoa, senhaDaPessoa);
							personService.addPerson((Funcionario) novoFuncionario);

							menuDeCadastro = false;
							break;

						}

					}

				}
				break;

			case 2:

				System.out.println("\n*-*-*-*-*-*-*-*- LOGIN/ENTRAR *-*-*-*-*-*-*-*-*");
				String emailDoLogin = Teclado.lerString("Digite o Email cadastrado:");
				String senhaDoLogin = Teclado.lerString("Senha criada no cadastro: ");
				System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\n");

				if (personService.verificarLoginPessoa(emailDoLogin, senhaDoLogin)) {

					if (personService.checarTipoPessoa(emailDoLogin)) {

						boolean menuDoAdm = true;
						while (menuDoAdm) {

							System.out.println("\n-*-*-*-*-*-*-* MENU ADMIN -*-*-*-*-*-");
							System.out.println("1 - Ver todas as manifestações dos usuarios");
							System.out.println("2 - Excluir manifestação");
							System.out.println("3 - Sair");
							System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
							int opcaoDoAdm = Teclado.lerInt("Digite sua opcao: ");

							switch (opcaoDoAdm) {

							case 1:

								System.out.println(personService.listarTodosAlunos());
								break;

							case 2:

								System.out.println(personService.listarTodosAlunos());

								int opcaoDoAdmDelete = Teclado.lerInt("Digite sua opcao: ");

								manifestService.deletarManifest(opcaoDoAdmDelete);

								break;

							case 3:
								menuDoAdm = false;
								break;

							default:
								System.out.println("Tente novamente!");
								break;
							}
						}

					} else {
						boolean menuDoAluno = true;
						while (menuDoAluno) {
							System.out.println("\n-*-*-*-*-*-*-* MENU ALUNO -*-*-*-*-*-");
							System.out.println("1 - Adicionar manifestacoes.");
							System.out.println("2 - Listar suas manifestacoes.");
							System.out.println("3 - SAIR!");
							System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
							int opcaoDoAluno = Teclado.lerInt("Digite sua opcao: ");

							switch (opcaoDoAluno) {

							case 1:
								System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
								System.out.println("1 - Reclamacao");
								System.out.println("2 - Elogio");
								System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
								int opcaoDeManifestacao = Teclado.lerInt("Digite sua opcao: ");

								switch (opcaoDeManifestacao) {

								case 1:

									String reclamacao = Teclado.lerString("\nDigite sua Reclamacao: ");
									Manifest novaReclamacao = new Reclamacao(reclamacao, "Reclamacao", emailDoLogin);
									manifestService.addManifest((Reclamacao) novaReclamacao);
									break;

								case 2:

									String elogio = Teclado.lerString("\nDigite sua Elogio: ");
									Manifest novaElogio = new Elogio(elogio, "Elogio", emailDoLogin);
									manifestService.addManifest((Elogio) novaElogio);
									break;

								default:
									System.out.println("Tente novamente!");
									break;
								}

								break;

							case 2:

								System.out.println(manifestService.listarAlunoEspecifico(emailDoLogin));
								break;

							case 3:
								menuDoAluno = false;
								break;

							default:
								System.out.println("Tente novamente!");
								break;
							}

						}

					}

				} else {
					System.out.println("Tente novamente");
				}

				break;
			default:
				System.out.println("Tente novamente!");
				break;
			}

		}

		Teclado.fecharScanner();
	}

}
