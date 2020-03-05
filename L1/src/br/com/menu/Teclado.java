package br.com.menu;

import java.util.Scanner;

public class Teclado {
	public Scanner teclado;
	
	public Teclado() {
		teclado = new Scanner(System.in);
	}

	public int opcao() {
		int op = teclado.nextInt();
		return op;
	}

	public String texto() {
		String t = teclado.nextLine();
		return t;
	}

	@Override
	protected void finalize() throws Throwable {
		teclado.close();
	}
}
