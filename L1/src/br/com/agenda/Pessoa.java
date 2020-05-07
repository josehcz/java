package br.com.agenda;

import java.util.GregorianCalendar;

import br.com.menu.Teclado;

public class Pessoa implements Comparable<Pessoa> {
	private String nome;
	private String telefone;
	private int datanasc;
	private char genero;
	private int cod;
	private int idade;
	Teclado teclado = new Teclado();
	
	private int[] Produtos = new int[13];

	public Pessoa(String nome, String telefone, int datanasc, char genero, int cod, int idade, Teclado teclado) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.datanasc = datanasc;
		this.genero = genero;
		this.cod = cod;
		this.idade = idade;
		this.teclado = teclado;
	}

	public Pessoa(String nome, String telefone, int datanasc, char genero, int cod) {
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

	public int getDatanasc() {
		return datanasc;
	}

	public void setDatanasc(int datanasc) {
		this.datanasc = datanasc;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public int getProdutos(int i) {
		return Produtos[i];
	}
	
	public void setProdutos(int i, int qtd) {
		this.Produtos[i] = qtd;
	}
	

	//imprimir
	public void imprimir() {
		System.out.println("Codigo: " + cod);
		System.out.println("Nome: " + nome);
		System.out.println("Telefone: " + telefone);
		System.out.println("Data de nascimento: " + datanasc);
		System.out.println("Genero: " + genero);
		System.out.println("\n");
	}	
	//atualizar cadastro	
	public void atualizaNome(String nome) {
		this.nome = teclado.texto();
	}
	public void atualizaFone(String telefone) {
		this.telefone = teclado.texto();
	}
	public void atualizaNasc(int datanasc) {
		this.datanasc = teclado.opcao();
	}
	public void atualizaGen(char genero) {
		this.genero = teclado.cha();
	}
	
	
	// calcular idade
	public void calcIdade(int datanasc) {
    	int dia = datanasc/1000000;
    	int ano = datanasc % 10000;
    	int mes = datanasc/10000;
    	mes = mes % 100;
    	
    	GregorianCalendar calendar = new GregorianCalendar();
    	int diah = calendar.get(GregorianCalendar.DAY_OF_MONTH); //dia hoje
    	int mesh = calendar.get(GregorianCalendar.MONTH) + 1; //mes hoje
    	int anoh = calendar.get(GregorianCalendar.YEAR); //ano hoje

    	int idade = anoh - ano - 1;
    	if (mes == mesh) {
    		if (dia <= diah) {
    			idade += 1;
    		}
    	}
    	if (mes < mesh) {
    		idade += 1;
    	}
    	
    	setIdade(idade);
	}
	
	@Override
	public int compareTo(Pessoa o){	
		return this.nome.compareTo(o.nome);
	}

}