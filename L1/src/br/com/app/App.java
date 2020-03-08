package br.com.app;

import br.com.agenda.Agenda;
import br.com.agenda.Pessoa;
import br.com.menu.*;

public class App {
	public static void main(String[] args) {
		String n,tel,data,g;
		int cod = 0, codt, info;
		Menu menu = new Menu();
		Agenda agenda = new Agenda();	
		int op = 1000;
		while (op != 0) {
			menu.imprimir();
			Teclado teclado = new Teclado();
			op = teclado.opcao();
			switch (op) {
			case 1: //Adicionar tem que arrumar ainda
				System.out.println("Defina o nome.");
				n = teclado.texto();
				n = teclado.texto();
				System.out.println("Defina o telefone.");
				tel = teclado.texto();
				System.out.println("Defina a data de nascimento.");
				data = teclado.texto();
				System.out.println("Defina o genero (M/F).");
				g = teclado.texto();
				Pessoa p = new Pessoa(n, tel, data, g, cod);
				agenda.clientes.add(p);
				cod = cod + 1;
				break;
			case 2: // imprimir/listar
				for (Pessoa x: agenda.clientes) {
					x.imprimir();
				}
				break;
			case 3: // Alterar
				System.out.println("Qual o codigo da pessoa que deseja alterar?");
				codt = teclado.opcao();
				System.out.println("Qual informação deseja alterar (1 = nome/2 = tel/3 = datanasc/4 = genero/ 0 = sair)");
				info = teclado.opcao();
				switch (info) {
				case 1:
					for (Pessoa x: agenda.clientes) {
						if (x.getCod() == codt) {
							System.out.println("Novo nome");
							n = teclado.texto();
							x.atualizaNome(n);
						}
					}
					break;
				case 2:
					for (Pessoa x: agenda.clientes) {
						if (x.getCod() == codt) {
							System.out.println("Novo telefone");
							tel = teclado.texto();
							x.atualizaFone(tel);
						}
					}
					break;
				case 3:
					for (Pessoa x: agenda.clientes) {
						if (x.getCod() == codt) {
							System.out.println("Nova data nasc");
							data = teclado.texto();
							x.atualizaNasc(data);
						}
					}
					break;
				case 4:
					for (Pessoa x: agenda.clientes) {
						if (x.getCod() == codt) {
							System.out.println("Novo genero");
							g = teclado.texto();
							x.atualizaGen(g);
						}
					}
					break;
				case 0:
					continue;
				default:
					continue;
				}
			case 4: // remover
			case 0: //Sair
				continue;
			}
			
		}
		
	}

}