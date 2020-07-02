package br.com.agenda;

public class Animal {
	private String nome;
	private String raca;
	private char genero;
	
	
	public Animal(String nome, String raca, char genero) {
		this.nome = nome;
		this.raca = raca;
		this.genero = genero;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getRaca() {
		return raca;
	}


	public void setRaca(String raca) {
		this.raca = raca;
	}


	public char getGenero() {
		return genero;
	}


	public void setGenero(char genero) {
		this.genero = genero;
	}
	
	public void imprimirPet() throws Exception{
		System.out.println("Nome: " + nome);
		System.out.println("Raça: " + raca);
		System.out.println("Genero: " + genero);
	}
	
	
}
