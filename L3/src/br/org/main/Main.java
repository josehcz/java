package br.org.main;


import br.org.ferramentas.Input;
import br.org.usuario.Cliente;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

public class Main {
  private static void tela_inicio() throws InterruptedException {
	    System.out.println("\n**********************************************************************************");
        Thread.sleep(100);
		System.out.println("a88888b.   .d888888    888888ba   d888888P   88888888b  dP   888888ba    .d888888");
		Thread.sleep(100);
		System.out.println("d8'   `88  d8'    88    88    `8b     88      88         88   88    `8b  d8'    88");
		Thread.sleep(100);
		System.out.println("88         88aaaaa88a  a88aaaa8P'     88     a88aaaa     88  a88aaaa8P'  88aaaaa88a");
		Thread.sleep(100);
		System.out.println("88         88     88    88   `8b.     88      88         88   88   `8b.  88     88");
		Thread.sleep(100);
		System.out.println("Y8.   .88  88     88    88     88     88      88         88   88     88  88     88");
		Thread.sleep(100);
		System.out.println("Y88888P'  88     88    dP     dP     dP      88888888P  dP   dP     dP  88     88\n");
		Thread.sleep(100);
		System.out.println("dP     dP  dP   888888ba   d888888P  dP     dP   .d888888   dP");
		Thread.sleep(100);
		System.out.println("88     88  88   88    `8b     88     88     88  d8'    88   88");
		Thread.sleep(100);
		System.out.println("88    .8P  88  a88aaaa8P'     88     88     88  88aaaaa88a  88");
		Thread.sleep(100);
		System.out.println("88    d8'  88   88   `8b.     88     88     88  88     88   88");
		Thread.sleep(100);
		System.out.println("88  .d8P   88   88     88     88     Y8.   .8P  88     88   88");
		Thread.sleep(100);
		System.out.println("888888'    dP   dP     dP     dP     `Y88888P'  88     88   88888888P");
		Thread.sleep(100);
		System.out.println("\n**********************************************************************************\n\n");
		Thread.sleep(150);

  }
  
  public static void main(String[] args) throws InterruptedException {
	Input teclado = new Input(); 
	String a;
	Cliente mano = new Cliente();
	tela_inicio();
	while(true) {
	  System.out.println("1.Cadastrar usuario.");
	  System.out.println("2.Entrar com usuario.");
	  System.out.println("0.Sair");
	  a = teclado.pegar_texto_teclado("> ");
	
	  if(a.equals("0")) {break;}
	  if(a.equals("1")) {mano.cadastrar();}
	  if(a.equals("2")) {
        if(mano.login()) {
          while(true) {
            System.out.println("1.Cadastrar fluxo de caixa (entrada)");
            System.out.println("2.Cadastrar fluxo de caixa (saida)");
            System.out.println("3.Impressso de relatorios");
            System.out.println("0.Sair");
            a = teclado.pegar_texto_teclado("> ");
            System.out.println("\n");
            if(a.equals("1")) {mano.carteira.cadastro_fluxo_entradas();}
            else if(a.equals("2")) {mano.carteira.cadastro_fluxo_saidas();}
            else if(a.equals("3")){mano.carteira.relatorio();}
            else {break;}
          }
        }
        else {System.out.println("Voce errou.");}
	  } 
    }
  }
}
