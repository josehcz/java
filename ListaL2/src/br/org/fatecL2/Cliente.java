package br.org.fatecL2;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.*;


public class Cliente {
	
	Input teclado= new Input();
	private String nome;
	private String telefone;
	private String endereco;
	private int cpf;
	private int cod;
	//private Veiculo v;
	
	
	public List <Veiculo> carros = new CopyOnWriteArrayList<Veiculo>();
	//private List <Veiculo> carros= new ArrayList<Veiculo>();
	
	
	public Cliente (String nome, String telefone, String endereco, int cpf,int cod) {
		this.nome=nome;
		this.telefone=telefone;
		this.endereco=endereco;
		this.cpf=cpf;
		//Veiculo v1= new Veiculo(teclado.texto("placa:"),teclado.texto("modelo:"),teclado.opcao("ano:"),teclado.pegaFloat("valor:"),teclado.texto("data de revisao:"),teclado.texto("relatorio:"));
		//carros.add(v1);
		this.cod=cod;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}
	
	public void imprimir(){
		System.out.println("\n******************");
		System.out.println("\nnome: "+this.nome);
		System.out.println("telefone: "+this.telefone);
		System.out.println("endereco: "+this+endereco);
		System.out.println("cpf: "+this.cpf);
		System.out.print("cod: "+this.cod);
		System.out.println("*****************");
		}
	
	//isso tem q ser um loop com todos os veiculos;
	public List<Veiculo> getCarros() {
		return carros;
	}
	
	
	public void adicionaVeiculo(Veiculo novo) {
		this.carros.add(novo);
	}
}
