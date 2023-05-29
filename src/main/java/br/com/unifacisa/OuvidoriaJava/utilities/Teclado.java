package br.com.unifacisa.OuvidoriaJava.utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Teclado {

	private static Scanner scNumero = new Scanner(System.in);
	private static Scanner scTexto = new Scanner(System.in);

	public static String lerString(String mensagem) {
		System.out.println(mensagem);
		String entrada = scTexto.nextLine();
		if (entrada.isEmpty()) {
			System.out.println("O campo não pode estar vazio, digite uma mensagem válida.");
		} else {
			return entrada;

		}
		return entrada;
	}

	public static int lerInt(String mensagem) {

		try {
			System.out.println(mensagem);

			int entrada = Integer.parseInt(scTexto.nextLine());

			return entrada;

		} catch (InputMismatchException e) {

			System.out.println("Voce digitou uma opcao invalida.");
			return 0;

		} catch (IllegalStateException e) {

			System.out.println("Voce digitou uma opcao invalida.");
			return 0;

		} catch (NumberFormatException e) {

			System.out.println("Voce digitou uma opcao invalida.");
			return 0;
		}

	}

	public static void fecharScanner() {
		scTexto.close();
		scNumero.close();
	}
}
