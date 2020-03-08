package br.com.agenda;

import br.com.menu.Teclado;

public class Pessoa {
	private String nome;
	private String telefone;
	private String datanasc;
	private String genero;
	private int cod;
	Teclado teclado = new Teclado();

	public Pessoa(String nome, String telefone, String datanasc, String genero, int cod) {
		this.nome = nome;
		this.telefone = telefone;
		this.datanasc = datanasc;
		this.genero = genero;
		this.cod = cod;
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

	public String getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(String datanasc) {
		this.datanasc = datanasc;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}
	
	public void imprimir() {
		System.out.println("Codigo: " + cod);
		System.out.println("Nome: " + nome);
		System.out.println("Telefone: " + telefone);
		System.out.println("Data de nascimento: " + datanasc);
		System.out.println("Genero: " + genero);
		System.out.println("\n");
	}	
		
	public void atualizaNome(String nome) {
		this.nome = teclado.texto();
	}
	public void atualizaFone(String telefone) {
		this.telefone = teclado.texto();
	}
	public void atualizaNasc(String datanasc) {
		this.datanasc = teclado.texto();
	}
	public void atualizaGen(String genero) {
		this.genero = teclado.texto();
	}
}

