package br.com.menu;

public class Menu {
	public void m() {
		System.out.println("1 - Inserir cliente.");
		System.out.println("2 - Alterar cadastro.");
		System.out.println("3 - Remover cadastro");
		System.out.println("4 - Comprar.");
		System.out.println("5 - Listar cadastro");
		System.out.println("6 - Listar cadastro apenas Masculinos");
		System.out.println("7 - Listar cadastro apenas Feminino");
		System.out.println("8 - Relatorio");
		System.out.println("0 - Sair");
		
	}
	public void alt(){
		System.out.println("Qual informação deseja alterar (1 = nome/2 = tel/3 = datanasc/4 = genero/ 0 = sair)");
	}
	public void relatorio() {
		System.out.println("1 - Media geral");
		System.out.println("2 - Media masculina");
		System.out.println("3 - Media feminina");
		System.out.println("4 - Serviço mais procurado");
		System.out.println("5 - Serviço mais procurado por homens");
		System.out.println("6 - Serviço mais procurado por mulheres");
		System.out.println("0 - Sair");
	}
}


