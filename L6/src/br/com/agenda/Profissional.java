package br.com.agenda;


import java.util.ArrayList;
import java.util.List;

public class Profissional extends Pessoa{
	
	private ArrayList<String> relatorio  = new ArrayList<String>();
	int codR = 0;
	
	public Profissional(String nome, String cpf, String endereco, String tel, char genero, int cod) {
		super(nome, cpf, endereco, tel, genero, cod);
	}
	
	public List<String> getRelatorio () {
		return relatorio;
	}
	
	public void setRelatorio(String x) {
		this.relatorio.add(x);
		codR += 1;
	}
	
	public void imprimirRelatorio() {
		System.out.println("++++++++++++++++++ Relatorios do Petsitter +++++++++++++++++");
		System.out.println(relatorio);
		System.out.println("\n");
	}
	
	@Override
	public void imprimir() throws Exception{
		super.imprimir();
		System.out.println("Codigo: " + cod);
		System.out.println("Nome: " + nome);
		System.out.println("CPF: " + cpf);
		System.out.println("endereço: " + endereco);
		System.out.println("Telefone: " + tel);
		System.out.println("Genero: " + genero);
		System.out.println("\n");
	}

}
