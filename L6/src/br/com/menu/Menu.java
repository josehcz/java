package br.com.menu;

public class Menu {
	public void m() {
		System.out.println("========== O que deseja fazer ===============");
		System.out.println("1 - Cadastrar cliente.");
		System.out.println("2 - Cadastrar profissional.");
		System.out.println("3 - Registrar mais pets para um cliente.");
		System.out.println("4 - Gerar relarios.");
		System.out.println("5 - Listar clientes.");
		System.out.println("6 - Listar profissionais.");
		System.out.println("7 - Fazer relatorio de atendimento");
		System.out.println("8 - Historico de atendimento dos petsitters.");
		System.out.println("0 - Sair");
	}
	
	public void relatorio() {
		System.out.println("1 = Ranking de raças preferidas.");
		System.out.println("2 = Qual o genero preferido de uma determinada raça.");
		System.out.println("0 = Sair.");
	}
}