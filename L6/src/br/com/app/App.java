package br.com.app;

import br.com.agenda.*;
import br.com.menu.*;

public class App {

	public static void main(String[] args) throws Exception {
		int op = 1000;
		Menu menu = new Menu();
		Agenda agenda =  new Agenda();
		while(op != 0) {
			Teclado teclado = new Teclado();
			menu.m();
			op = teclado.opcao();
			switch(op) {
			case 1 :  // Cadastrar Clientes
				agenda.cadastroC();
				break;
			
			case 2 : // Cadastrar Profissionais	
				agenda.cadatroP();
				break;
			
			case 3 : // Registrar mais pets para um cliente
				agenda.regisPet();
				break;
				
			case 4 : // Gerar relatorios
				menu.relatorio();
				int m = teclado.opcao();
				switch(m) {
				case 1 : // Ranking de raças preferidas
					agenda.rank();
					break;
					
				case 2 : // Qual o genero preferido de uma determinada raça
					agenda.genPref();
					break;
					
				case 0 : // Sair
					break;
				}
				break;
				
			case 5 : // Lista clientes
				agenda.listClient();
				break;
				
			case 6 : // Listar Profissionais
				agenda.listProf();
				break;
				
			case 7 : // Fazer relatorio de atendimento
				agenda.profAtend();
				break;
				
			case 8 : // Historico do atendimento dos petsitters
				agenda.profRelat();
				break;

			case 0 : // Sair
				continue;
			}
			
			
		}
	}

}
