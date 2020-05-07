package br.com.agenda;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import br.com.menu.*;

public class Agenda {
	Teclado teclado = new Teclado();
	
	public List<Pessoa> clientes = new CopyOnWriteArrayList<Pessoa>();	
	
	//lista dos produtos
	private String[] produtos = {"Manicure","Pedicure","Design de sobrancelhas",
			"Corte de cabelo","Pintura de cabelo","Remoção de rugas","Remoção de manchas",
			"Botox","Tratamento para emagrecimento","Redução de medidas","Modelagem e corte de barba",
			"Tratamento para queda de cabelo","Produtos especializados"};

	public void comprarP() { //comprar produto
			int i;
			System.out.println("Selecione o codigo do cliente que deseja adicionar o item na lista:");
			int pe = teclado.opcao();
			System.out.println("PRODUTOS: ");
			for(i = 0; i < this.produtos.length; ++i) {
				System.out.println(i  + " " +  produtos[i]);
			}
			
			System.out.println("Selecione o produto que deseja comprar (pelo id):");
			int prod = teclado.opcao();
			System.out.println("Insira a quantidade:");
			int qtd = teclado.opcao();		
			for (Pessoa x : clientes) {
				if (x.getCod() == pe) {
					x.setProdutos(prod, qtd);
					System.out.println("Produto comprado");
				}
			}
		}
	
	public void prodMaisCons() { //produtos mais consumidos
		int[] prod = new int[13];
		int maior = 0; //maior
		int MaiorF = 0; //maior final
		for (Pessoa x : clientes) {
			for (int i = 0; i < prod.length; i++) {
				prod[i] += x.getProdutos(i);
			}
		}
		
		for(int i = 0; i < prod.length; ++i) {
			if(prod[i] > maior) {
				maior = prod[i];
				MaiorF = i;
			}
		}
		
		System.out.println("Produtos mais consumido:" + this.produtos[MaiorF]);		
	}
	public void prodMaisConM() { // produtos mais consumidos por homens
		int[] prodM = new int[13];
		int maiorM = 0; //maior masculino
		int MaiorMF = 0; //maior masculino final
		for (Pessoa x : clientes) {
			for (int i = 0; i < prodM.length; i++) {
				if(x.getGenero() == 'M') {
					prodM[i] += x.getProdutos(i);		
				}
			}
		}
		for(int i = 1; i < prodM.length; ++i) {
			if(prodM[i] > maiorM) {
				maiorM = prodM[i];
				MaiorMF = i;
			}
		}	
		System.out.println("Produtos mais consumido por homens:" + this.produtos[MaiorMF]);
		}
	public void prodMaisConF() { // produtos mais consimidos por mulheres
		int[] prodF = new int[13];
		int maiorF = 0; //maior feminino
		int MaiorFF = 0; //maior feminino final
		for (Pessoa p : clientes) {
			for (int i = 0; i < prodF.length; i++) {
				if(p.getGenero() == 'F') {
					prodF[i] += p.getProdutos(i);
				}
			}
		}
		
		for(int i = 1; i < prodF.length; ++i) {
			if(prodF[i] > maiorF) {
				maiorF = prodF[i];
				MaiorFF = i;
			}
		}
		System.out.println("Produtos mais consumido por mulheres:" + this.produtos[MaiorFF]);
	}
}