package br.com.app;

import java.util.Collections;

import br.com.agenda.Agenda;
import br.com.agenda.Pessoa;
import br.com.menu.*;

public class App {
	public static void main(String[] args) {
		String n,tel;
		char g;
		int cod = 0, codt, info, data;
		Menu menu = new Menu();
		Agenda agenda = new Agenda();	
		int op = 1000;
		while (op != 0) {
			menu.m();
			Teclado teclado = new Teclado();
			op = teclado.opcao();
			switch (op) {
			case 1: //Adicionar
				System.out.println("Defina o nome.");
				teclado = new Teclado();
				n = teclado.texto();
				System.out.println("Defina o telefone.");
				tel = teclado.texto();
				System.out.println("Defina a data de nascimento(coloque os numeros sem / Ex:02052000).");
				data = teclado.opcao(); 
				System.out.println("Defina o genero (M/F).");
				g = teclado.cha();
				Pessoa p = new Pessoa(n, tel, data, g, cod);
				p.calcIdade(data);
				agenda.clientes.add(p);
				cod = cod + 1;
				Collections.sort(agenda.clientes);
				break;
			case 2: // Alterar cadastro
				System.out.println("Qual o codigo da pessoa que deseja alterar?");
				codt = teclado.opcao();
				menu.alt();
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
					continue;
				case 2:
					for (Pessoa x: agenda.clientes) {
						if (x.getCod() == codt) {
							System.out.println("Novo telefone");
							tel = teclado.texto();
							x.atualizaFone(tel);
						}
					}
					continue;
				case 3:
					for (Pessoa x: agenda.clientes) {
						if (x.getCod() == codt) {
							System.out.println("Nova data nasc");
							data = teclado.opcao();
							x.atualizaNasc(data);
							x.calcIdade(data);
						}
					}
					continue;
				case 4:
					for (Pessoa x: agenda.clientes) {
						if (x.getCod() == codt) {
							System.out.println("Novo genero");
							g = teclado.cha();
							x.atualizaGen(g);
						}
					}
					continue;
				case 0:
					continue;
				default:
					break;
				}
			case 3: // remover cadastro
				System.out.println("Qual o codigo da pessoa que deseja remover?");
				codt = teclado.opcao();
				for (Pessoa x: agenda.clientes) {
					if (x.getCod() == codt) {
						agenda.clientes.remove(x);
					}
				}
				break;
				
			case 4: //comprar
				agenda.comprarP();
				break;
				
			case 5: // listar
				for (Pessoa x: agenda.clientes) {
					x.imprimir();
				}
				break;
			case 6: // listar apenas masculinos
				for (Pessoa x: agenda.clientes) {
					if(x.getGenero() == 'M')
					x.imprimir();
				}
				break;
			case 7: // listar apenas masculinos
				for (Pessoa x: agenda.clientes) {
					if(x.getGenero() == 'F')
					x.imprimir();
				}
				break;
			case 8: // relatorio
				int M = 0,Med = 0; //contador , media
				int MM = 0,MedM = 0; //contador, media M
				int MF = 0, MedF = 0; //contador, media F
				menu.relatorio();
				codt = teclado.opcao();
				switch (codt) {
				case 1: //media geral
					for (Pessoa x: agenda.clientes) {
						Med += x.getIdade();
						M += 1;
					}
					Med = Med / M;
					System.out.println("Idade media dos pacientes: " + Med);
					break;
				
				case 2: //media masculina
					for (Pessoa x: agenda.clientes) {
						if(x.getGenero() == 'M') {
							MedM += x.getIdade();
							MM += 1;		
						}
					}
					MedM = MedM / MM;
					System.out.println("Idade media dos pacientes masculinos: " + MedM);
					break;
				
				case 3: //media feminina
					for (Pessoa x: agenda.clientes) {
						if(x.getGenero() == 'F') {
							MedF += x.getIdade();
							MF += 1;
						}
					}
					MedF = MedF / MF;
					System.out.println("Idade media dos pacientes femininos: " + MedF);
					break;
				
				case 4: //serviços mais consumido
					agenda.prodMaisCons();
					break;
				
				case 5: //serviços mais consumido por homens
					agenda.prodMaisConM();
					break;
				
				case 6: //serviços mais consumido por mulheres
					agenda.prodMaisConF();
					break;
				
				case 0:// sair
					continue;
				default:
					continue;
				}
			case 0: //Sair
				continue;
			}	
		}	
	}
}