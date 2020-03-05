package br.com.agenda;

public class Pessoa {
	private String nome;
	private String telefone;
	private String datanasc;
	private String genero;

	public Pessoa(String nome, String telefone, String datanasc, String genero) {
		this.nome = nome;
		this.telefone = telefone;
		this.datanasc = datanasc;
		this.genero = genero;
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
	
	public void imprimir() {
		System.out.println("Nome: " + nome);
		System.out.println("Telefone: " + telefone);
		System.out.println("Data de nascimento: " + datanasc);
		System.out.println("Genero: " + genero);
	}
}
