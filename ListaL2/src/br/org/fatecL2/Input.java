package br.org.fatecL2;
import java.util.Scanner;

public class Input {
  public Scanner teclado;

  public Input() {
    teclado = new Scanner(System.in);
  }

  public int opcao(String str) {
	  System.out.print(str);
      int op = teclado.nextInt();
      teclado = new Scanner(System.in);
      return op;
  }
  
  public float pegaFloat(String str)
  {
	  System.out.print(str);
	  float f = teclado.nextFloat();
	  teclado = new Scanner(System.in);
	  return f;
  }
  
  public String texto(String str) {
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


