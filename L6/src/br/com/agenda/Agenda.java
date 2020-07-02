package br.com.agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator; 
import java.util.HashMap; 
import java.util.LinkedHashMap; 
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set; 

import br.com.menu.*;

public class Agenda {
	Teclado teclado = new Teclado();
	
	public List<Profissional> Aprof = new ArrayList<Profissional>();
	public List<Cliente> Acliente = new ArrayList<Cliente>();
	public List<Animal> animal = new ArrayList<Animal>();
	Map<String,String> score = new HashMap<String,String>();
	
	Comparator<Entry<String, String>> valueComparator = new Comparator<Entry<String,String>>() {
		@Override
		public int compare(Entry<String, String> e1, Entry<String, String> e2) { 
			String v1 = e2.getValue(); String v2 = e1.getValue(); return v1.compareTo(v2); 
			} 
		};
	
	String n, cpf, end, tel;
	String nP, racaP; char genP;
	char g;
	int codC = 0, codP = 0;
	
	
	public void cadastroC () {
		System.out.println("Defina o nome: ");
		Teclado teclad = new Teclado();
		n = teclad.texto(); 
		System.out.println("Defina o CPF: ");
		cpf = teclad.texto();
		System.out.println("Defina endereço: ");
		end = teclad.texto();
		System.out.println("Defina telefone: ");
		tel = teclad.texto();
		System.out.println("Defina o genero: ");
		g = teclad.cha();
		System.out.println("========= Cadastrar o pet =============");
		Teclado teclado = new Teclado();
		System.out.println("Defina o nome do pet: ");
		nP = teclado.texto();
		System.out.println("Defina a raça do pet(escreva sempre da mesma maneira): ");
		racaP = teclado.texto();
		System.out.println("Defina o genero do pet: ");
		genP = teclado.cha();
		Animal a = new Animal(nP, racaP, genP);
		Cliente client = new Cliente (n, cpf, end, tel, g, codC);
		client.setPets(a);
		animal.add(a);
		if (score.containsKey(a.getRaca())) {
			String pega = score.get(a.getRaca());
			int total = Integer.parseInt(pega) + 1;
			score.put(a.getRaca(), new String(Integer.toString(total)));
		}
		else{
            score.put(a.getRaca(), new String("1"));
        }
		Acliente.add(client);
		codC += 1;
	}
	
	public void cadatroP () {
		System.out.println("Defina o nome: ");
		n = teclado.texto(); 
		System.out.println("Defina o CPF: ");
		cpf = teclado.texto();
		System.out.println("Defina endereço: ");
		end = teclado.texto();
		System.out.println("Defina telefone: ");
		tel = teclado.texto();
		System.out.println("Defina o genero: ");
		g = teclado.cha();
		Profissional profissional = new Profissional (n, cpf, end, tel, g, codP);
		Aprof.add(profissional);
		codP += 1;
	}
	
	public void regisPet () {
		System.out.println("Digite o codigo do cliente que deseja castras o Pet");
		int c = teclado.opcao();
		System.out.println("========= Cadastrar o pet =============");
		Teclado teclado = new Teclado();
		System.out.println("Defina o nome do pet: ");
		nP = teclado.texto();
		System.out.println("Defina a raça do pet(escreva sempre da mesma maneira): ");
		racaP = teclado.texto();
		System.out.println("Defina o genero do pet: ");
		genP = teclado.cha();
		Animal a = new Animal(nP, racaP, genP);
		animal.add(a);
		if (score.containsKey(a.getRaca())) {
			String pega = score.get(a.getRaca());
			int total = Integer.parseInt(pega) + 1;
			score.put(a.getRaca(), new String(Integer.toString(total)));
		}
		else{
            score.put(a.getRaca(), new String("1"));
        }
		for (Cliente x: Acliente) {
			if (x.getCod() == c) {
				x.setPets(a);
			}
		}
	}
	
	public void listClient () throws Exception {
		for (Cliente x: Acliente) {
			x.imprimir();
		}
	}
	
	public void listProf() throws Exception {
		for (Profissional x: Aprof) {
			x.imprimir();
		}
	}
	
	public void rank() {
		Set<Entry<String, String>> entries = score.entrySet();
		List<Entry<String, String>> listOfEntries = new ArrayList<Entry<String, String>>(entries);
		
		Collections.sort(listOfEntries, valueComparator);
		
		LinkedHashMap<String, String> sortedByValue = new LinkedHashMap<String, String>(listOfEntries.size());
		
		
		Set<Entry<String, String>> entrySetSortedByValue = sortedByValue.entrySet();
		
		for(Entry<String, String> entry : listOfEntries){ 
			sortedByValue.put(entry.getKey(), entry.getValue());
			}

		
		for(Entry<String, String> mapping : entrySetSortedByValue){ 
			System.out.println(mapping.getKey() + " ==> " + mapping.getValue()); 
			}
	}
	
	public void genPref () {
		int Ma = 0;
		int Fe = 0;
		System.out.println("Qual a raça do pet que deseja ver o genero preferido: ");
		Teclado teclado = new Teclado();
		String raca = teclado.texto();
		for (Animal x: animal) {
			if (x.getRaca().contentEquals(raca)) {
				if (x.getGenero() == 'M'){
					Ma = Ma + 1;	
				}
				if (x.getGenero() == 'F'){
					Fe = Fe + 1;
				}
				continue;
			}
		}
		if (Ma > Fe) {
			System.out.println("O genero preferido dessa raça é Masculino");
		}
		else if (Fe < Ma) {
			System.out.println("O genero preferido dessa raça é Feminino");
		}
		else if (Fe == Ma) {
			System.out.println("Essa raça possui o mesmo numero de pets Masculino e Feminino");
		}
	}
	
	public void profAtend () {
		System.out.println("Escreva o codigo do petsitter: ");
		int p = teclado.opcao();
		for (Profissional x: Aprof) {
			if (x.getCod() == p) {
				System.out.println("Escreva o relatorio do atendimento: ");
				Teclado teclado = new Teclado();
				String re = teclado.texto();
				x.setRelatorio(re);
			}
			else {
				break;
			}
		}
	}
	
	public void profRelat () {
		System.out.println("Escreva o codigo do petsitter: ");
		int p = teclado.opcao();
		for (Profissional x: Aprof) {
			if (x.getCod() == p) {
			}
		}
	}
	
	
	
}
