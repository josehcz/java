package br.com.app;

import br.com.agenda.Agenda;
import br.com.agenda.Pessoa;
import br.com.menu.*;

public class App {
	public static void main(String[] args) {
		String n,tel,data,g;
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
				System.out.println("Defina o telefone.");
				tel = teclado.texto();
				System.out.println("Defina a data de nascimento.");
				data = teclado.texto();
				System.out.println("Defina o genero (M/F).");
				g = teclado.texto();
				Pessoa p = new Pessoa(n, tel, data, g);
				agenda.clientes.add(p);
				break;
			case 2: // imprimir/listar
				for (Pessoa x: agenda.clientes) {
					
				}
			case 3: // Alterar
			case 4: // remover
			case 0: //Sair
				continue;
			}
			
		}
		
	}

}
