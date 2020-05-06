package br.org.usuario;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import br.org.ferramentas.Input;

public class Carteira {
  private String tipo_pessoa;
  public Carteira(String tipo_pessoa) {
    this.tipo_pessoa = tipo_pessoa;
  }	
	
  //____________________________________L I S T A S  E N T R A D A____________________________________
  private List <Fluxos> lista_salarios = new CopyOnWriteArrayList<Fluxos>();
  private List <Fluxos> lista_receita_de_vendas = new CopyOnWriteArrayList<Fluxos>();
  private List <Fluxos> lista_investimentos = new CopyOnWriteArrayList<Fluxos>();
  
  //____________________________________L I S T A S  S A I D A____________________________________
  private List <Fluxos> lista_energia_eletrica = new CopyOnWriteArrayList<Fluxos>();
  private List <Fluxos> lista_gas = new CopyOnWriteArrayList<Fluxos>();
  private List <Fluxos> lista_alimentacao = new CopyOnWriteArrayList<Fluxos>();
  private List <Fluxos> lista_combustivel = new CopyOnWriteArrayList<Fluxos>();
  private List <Fluxos> lista_outros = new CopyOnWriteArrayList<Fluxos>();
  
  
  //____________________________________V E T O R E S  & L I S T A S  D E  A U X I L I O____________________________________
  //  --->> para um explicaçao melhor do porque destes vetores/listas,por favor consutar o caragua. <<---  //
  private List vetor_listas_entradas_pf[] = {lista_salarios, lista_investimentos};
  private List vetor_listas_entradas_pj[] = {lista_receita_de_vendas, lista_investimentos};
  private List vetor_listas_saidas[] = {lista_energia_eletrica, lista_gas, lista_alimentacao,
		                                lista_combustivel, lista_outros};
  
  private List <Fluxos> lista_entradas = new CopyOnWriteArrayList<Fluxos>();        
  private List <Fluxos> lista_saidas = new CopyOnWriteArrayList<Fluxos>();           

  
  //____________________________________F L U X O  D E  E N T R A D A____________________________________
  public void cadastro_fluxo_entradas() {
	Input teclado = new Input();
	String a;
    if(tipo_pessoa.equals("1")){
      while(true) {
        System.out.println("1.cadastrar salario.");
        System.out.println("2.cadastrar investimentos.");
        System.out.println("0.sair.");
        
        a = teclado.pegar_texto_teclado("> ");
        System.out.println("\n");
        if(a.equals("1")) {
          System.out.println("cadastrando salario");
          Fluxos sal = new Fluxos(teclado.pegar_texto_teclado("valor: "), teclado.pegar_texto_teclado("data dd/mm: "), "Salario");
          lista_salarios.add(sal);
          System.out.println("\n");
        }
        else if(a.equals("2")) {
        	System.out.println("cadastrando investimentos");
          Fluxos inv = new Fluxos(teclado.pegar_texto_teclado("valor: "), teclado.pegar_texto_teclado("data dd/mm: "), "Inverstimento");
          lista_investimentos.add(inv);
          System.out.println("\n");
        }
        else{break;}
      }
    }
    else {//  <- tipo_pessoa == 2
      while(true) {
        System.out.println("1.cadastrar receita de vendas.");
        System.out.println("2.cadastrar investimentos.");
        System.out.println("0.sair.");
      
        a = teclado.pegar_texto_teclado("> ");
        System.out.println("\n");
        if(a.equals("1")) {
          System.out.println("cadastrando receita de vendas");       	
          Fluxos sal = new Fluxos(teclado.pegar_texto_teclado("valor: "), teclado.pegar_texto_teclado("data dd/mm: "), "Receita de Vendass");
          lista_salarios.add(sal);
          System.out.println("\n");
        }
        else if(a.equals("2")) {
          System.out.println("cadastrando investimentos");
          Fluxos inv = new Fluxos(teclado.pegar_texto_teclado("valor: "), teclado.pegar_texto_teclado("data dd/mm: "), "Investimentos");
          lista_investimentos.add(inv);
          System.out.println("\n");
        }
        else{break;}
      }
    }
  }
  
  
  //____________________________________F L U X O  D E  S A I D A____________________________________
  public void cadastro_fluxo_saidas() {
	Input teclado = new Input();
	String a;
    while(true) {
	  System.out.println("1.cadastrar energia eletrica.");
	  System.out.println("2.cadastrar gas.");
	  System.out.println("3.cadastrar alimentacao.");
	  System.out.println("4.cadastrar combustivel.");
	  System.out.println("5.cadastrar outros.");
	  System.out.println("0.sair.");
	  
	  
	  a = teclado.pegar_texto_teclado("> ");
	  System.out.println("\n");
	  if(a.equals("1")) {
	    System.out.println("cadastrando energia eletrica");
	    Fluxos ee = new Fluxos(teclado.pegar_texto_teclado("valor: "), teclado.pegar_texto_teclado("data dd/mm: "), "Energia Eletrica");
	    lista_energia_eletrica.add(ee);
	    
	  }
	  else if(a.equals("2")) {
	    System.out.println("cadastrando gas");
		Fluxos gas = new Fluxos(teclado.pegar_texto_teclado("valor: "), teclado.pegar_texto_teclado("data dd/mm: "), "Gas");
		lista_gas.add(gas);
	  }
	  else if(a.equals("3")) {
		System.out.println("cadastrando alimentos");
		Fluxos ali = new Fluxos(teclado.pegar_texto_teclado("valor: "), teclado.pegar_texto_teclado("data dd/mm: "), "Alimentos");
		lista_alimentacao.add(ali);
	  }
	  else if(a.equals("4")) {
		System.out.println("cadastrando combustivel ");
		Fluxos cmb = new Fluxos(teclado.pegar_texto_teclado("valor: "), teclado.pegar_texto_teclado("data dd/mm: "), "Combustivel");
	    lista_combustivel.add(cmb);
	  }
	  else if(a.equals("5")) {
		System.out.println("cadastrando outros ");
		Fluxos otr = new Fluxos(teclado.pegar_texto_teclado("valor: "), teclado.pegar_texto_teclado("data dd/mm: "), "Outros");
	    lista_outros.add(otr);
	  }
	  else{break;}
	  System.out.println("\n");
    }
    
  }
  
  
  //____________________________________I M P R E S S A O  D E  R E L A T O R I O____________________________________
  public void relatorio() {
	Input teclado = new Input();
    String user_mes, user_opcao;
    while(true) {
      int soma_total_entrada=0;
      int soma_total_saidas=0;
      List <Fluxos> lista_entradas = new CopyOnWriteArrayList<Fluxos>();
      user_mes = teclado.pegar_texto_teclado("digite o mes para impressao de relatorio: e.g 05 \n0.Sair\n> ");
      System.out.println("\n");
      if(user_mes.equals("0")) {break;}
      System.out.println("opcao 1:   1   2   3   4   5   6  7");
      System.out.println("opcao:2:   8   9  10  11  12  13 14");
      System.out.println("opcao 3:  15  16  17  18  19  20 21");
      System.out.println("opcao 4:  22  23  24  25  26  27 28");
      System.out.println("opcao 5:  29  30 ");
      System.out.println("opcao 6: O mes inteiro.");
      user_opcao = teclado.pegar_texto_teclado("> ");
      System.out.println("\n");

      if(user_opcao.equals("6")) {
    	//___________________________C A L C U L A N D O  E N T R A D A S  M E N S A I S___________________________
        for(int a=0;a<2;a++) {
          for(int b=0;b<vetor_listas_entradas_pf[a].size();b++) {             	
            if(((Fluxos) vetor_listas_entradas_pf[a].get(b)).data.mes.equals(user_mes)) {
              soma_total_entrada += Integer.parseInt(((Fluxos) vetor_listas_entradas_pf[a].get(b)).valor);
              lista_entradas.add(((Fluxos) vetor_listas_entradas_pf[a].get(b)));
            }
          }
        }
        //___________________________C A L C U L A N D O  S A I D A S  M E N S A I S___________________________
        for(int a=0;a<5;a++) {
          for(int b=0;b<vetor_listas_saidas[a].size();b++) {             	
            if(((Fluxos) vetor_listas_saidas[a].get(b)).data.mes.equals(user_mes)) {
              soma_total_saidas += Integer.parseInt(((Fluxos) vetor_listas_saidas[a].get(b)).valor);
              lista_saidas.add(((Fluxos) vetor_listas_saidas[a].get(b)));
            }
          }
        }
      }
      
      
      else {
    	//___________________________C A L C U L A N D O  E N T R A D A S  S E M A N A I S___________________________
    	for(int a=0;a<2;a++) {
          for(int b=0;b<vetor_listas_entradas_pf[a].size();b++) {             	
            if(((Fluxos) vetor_listas_entradas_pf[a].get(b)).data.get_opcao() == Integer.parseInt(user_opcao)  && ((Fluxos) vetor_listas_entradas_pf[a].get(b)).data.mes.equals(user_mes)) {
              soma_total_entrada += Integer.parseInt(((Fluxos) vetor_listas_entradas_pf[a].get(b)).valor);
              lista_entradas.add(((Fluxos) vetor_listas_entradas_pf[a].get(b)));
            }
          }
        }
    	//___________________________C A L C U L A N D O  S A I D A S  S E M A N A I S___________________________
    	for(int a=0;a<5;a++) {
          for(int b=0;b<vetor_listas_saidas[a].size();b++) {             	
            if(((Fluxos) vetor_listas_saidas[a].get(b)).data.get_opcao() == Integer.parseInt(user_opcao)  && ((Fluxos) vetor_listas_saidas[a].get(b)).data.mes.equals(user_mes)) {
              soma_total_saidas += Integer.parseInt(((Fluxos) vetor_listas_saidas[a].get(b)).valor);
              lista_saidas.add(((Fluxos) vetor_listas_saidas[a].get(b)));
            }
          }
        }
      }
      
      
      //___________________________M O S T R A N D O  O  F L U X O  D E  C A I X A___________________________
      System.out.println("\n");
      System.out.println(" * * * Entradas * * *");
      for(int a=0;a<lista_entradas.size();a++) {
        System.out.println("Valor: " + ((Fluxos) lista_entradas.get(a)).valor );
        System.out.println("Data: " + ((Fluxos) lista_entradas.get(a)).data.mostra_data() );
        System.out.println("Tipo: " + ((Fluxos) lista_entradas.get(a)).tipo );
      }
      System.out.println(" * * * Saidas * * *");
      for(int a=0;a<lista_saidas.size();a++) {
        System.out.println("Valor: " + ((Fluxos) lista_saidas.get(a)).valor );
        System.out.println("Data: " + ((Fluxos) lista_saidas.get(a)).data.mostra_data() );
        System.out.println("Tipo: " + ((Fluxos) lista_saidas.get(a)).tipo );
      }
      System.out.println("* * * Total * * *");
      System.out.println("Total de ganho: " + soma_total_entrada);
      System.out.println("Total de gasto: " + soma_total_saidas);
    }
  }
}
