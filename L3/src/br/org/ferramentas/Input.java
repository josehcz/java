package br.org.ferramentas;

import java.util.Scanner;

public class Input {
  private Scanner teclado;
	
  public Input() {teclado = new Scanner(System.in);}

  public String pegar_texto_teclado() {
	String t = teclado.nextLine();
	teclado = new Scanner(System.in);
	return t;
  }
  public String pegar_texto_teclado(String str) {
	System.out.print(str);
	String t = teclado.nextLine();
	teclado = new Scanner(System.in);
	return t;
  }

  @Override
  protected void finalize() throws Throwable {
    teclado.close();
  }
}

