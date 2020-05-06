package br.org.fatecL2;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Inicio {

	public static void main(String[] args) {
		int codigo=0,i=0,codv=0;//variavel pra contar e acessar o endereco dos clientes
		Input teclado= new Input();
		
		Lista tentativa = new Lista();
		Lista chance =new Lista();
		while(true) {
			switch(teclado.opcao("1.Cadastrar Cliente\n2.Cadastrar Veiculo\n3.Agendar Revisao\n4.Troca de Data de Revisao\n5.Cancelar Agendamento\n6.Registrar Relatorio\n"))
			{
				case 1: //cadastrar cliente //finalizado
					Cliente nc=new Cliente(teclado.texto("nome: "),teclado.texto("telefone: "),teclado.texto("endereco: "),teclado.opcao("cpf: "),codigo);
					codigo++;
					tentativa.clientes.add(nc);
					System.out.println("Cliente registrado com sucesso\ncodigo: "+nc.getCod()+"\n");
					break;
				case 2://Cadastrar Veiculo //finalizado
					int codc = teclado.opcao("digite o codigo do cliente:");
					for (Cliente x: tentativa.clientes) {
						if (x.getCod()==codc) {
							Veiculo vn= new Veiculo(teclado.texto("placa:"),teclado.texto("modelo:"),teclado.opcao("ano:"),teclado.pegaFloat("valor:"),teclado.texto("data de revisao:"),teclado.texto("relatorio:"),codv);
							x.adicionaVeiculo(vn);codv++;
							chance.veiculos.add(vn);
							System.out.println("cadastrado com sucesso!");
							System.out.println("---LISTA DE VEICULOS CADASTRADOS DO CLIENTE---");
							for(Veiculo y: x.getCarros()){
								y.imprimir();
							}
						}
						
					}
					break;
				case 3://Agendar Revisao
					String solicita = teclado.texto("data desejada: \n");
					codc = teclado.opcao("digite o codigo do cliente:\n");
					for (Cliente x: tentativa.clientes) {
						if (x.getCod()==codc) {
							int codigov=teclado.opcao("digite o codigo do veiculo: \n");
							for(Veiculo y: chance.veiculos){
								if(solicita.equals(y.getDataRevisao())){
								System.out.println("Essa data ja esta ocupada!");
								break;
								}
								if(y.getCod()==codigov) {
									y.setDataRevisao(solicita);
									y.imprimir();
								}
							}
						}
					}		
					break;
				case 4://Troca de Data de Revisao
					codc = teclado.opcao("digite o codigo do cliente:\n");
					for (Cliente x: tentativa.clientes) {
						if (x.getCod()==codc) {
							int codigov=teclado.opcao("digite o codigo do veiculo: \n");
							for(Veiculo y: chance.veiculos){
								if(y.getCod()==codigov) {
									y.setDataRevisao(teclado.texto("nova data de revisao: "));
									y.imprimir();
								}
							}
						}
					}	
					break;
				case 5://Cancelar Agendamento
					codc = teclado.opcao("digite o codigo do cliente:\n");
					for (Cliente x: tentativa.clientes) {
						if (x.getCod()==codc) {
							int codigov=teclado.opcao("digite o codigo do veiculo: \n");
							for(Veiculo y: chance.veiculos){
								if(y.getCod()==codigov) {
									y.setDataRevisao("CANCELADA");
									y.imprimir();
								}
							}
						}
					}	
					break;
				case 6://Relatorio de servicos
					codc = teclado.opcao("digite o codigo do cliente:\n");
					for (Cliente x: tentativa.clientes) {
						if (x.getCod()==codc) {
							int codigov=teclado.opcao("digite o codigo do veiculo: \n");
							for(Veiculo y: chance.veiculos){
								if(y.getCod()==codigov) {
									y.setRelatorio(teclado.texto("digite o relatorio: \n"));
									y.imprimir();
								}
							}
						}
					}	
					break;
				default:
					break;
			}
		}
	}

}
