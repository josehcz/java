package br.com.agenda;

import java.util.ArrayList;

public class Cliente extends Pessoa{
	
	
	private ArrayList<Animal> pets  = new ArrayList<Animal>(5);
	int codP = 0;
	
	public Cliente(String nome, String cpf, String endereco, String tel, char genero, int cod) {
		super(nome, cpf, endereco, tel, genero, cod);
	}

	public ArrayList<Animal> getPets() {
		return pets;
	}

	public void setPets(Animal x) {
		this.pets.add(x);
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
		System.out.println("+++++++++++++++++ PETS +++++++++++++++++");
		for (Animal x: pets) {
			x.imprimirPet();
			System.out.println("\n");
		}
		System.out.println("\n");
	}

	
}
