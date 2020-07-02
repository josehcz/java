package br.com.agenda;

public class Pessoa implements Comparable<Pessoa>{
	protected String nome;
	protected String cpf;
	protected String endereco;
	protected String tel;
	protected char genero;
	protected int cod;
	
	
	public Pessoa(String nome, String cpf, String endereco, String tel, char genero, int cod) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.tel = tel;
		this.genero = genero;
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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

	@Override
	public int compareTo(Pessoa o) {
		return this.nome.compareTo(o.nome);
	}
	
	public void imprimir() throws Exception{
	}
}
