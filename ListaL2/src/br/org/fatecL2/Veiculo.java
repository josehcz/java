package br.org.fatecL2;

public class Veiculo {
	
	private String placa;
	private String modelo;
	private int ano;
	private float valor;
	private String dataRevisao;
	private String relatorio;
	private int cod;
	
	
	public Veiculo(String placa, String modelo, int ano, float valor, String dataRevisao, String relatorio,int cod) {
		this.placa = placa;
		this.modelo = modelo;
		this.ano = ano;
		this.valor = valor;
		this.dataRevisao = dataRevisao;
		this.relatorio = relatorio;
		this.cod=cod;		
		
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getDataRevisao() {
		return dataRevisao;
	}
	public void setDataRevisao(String dataRevisao) {
		this.dataRevisao = dataRevisao;
	}
	public String getRelatorio() {
		return relatorio;
	}
	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	
	public void imprimir() {
		System.out.println("\n******************");
		System.out.println("\nplaca: "+this.placa);
		System.out.println("modelo: "+this.modelo);
		System.out.println("ano: "+this.ano);
		System.out.println("valor: "+this.valor);
		System.out.println("data de revisao: "+this.dataRevisao);
		System.out.println("relatorio: "+this.relatorio);
		System.out.print("codigo do veiculo: "+this.cod);
		System.out.println("\n*****************\n");
	}
}
