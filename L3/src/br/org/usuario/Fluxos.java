package br.org.usuario;

import br.org.ferramentas.Calendario;

public class Fluxos {
  public String valor;
  public Calendario data;
  public String tipo;
  
  public String data_str;
  public Fluxos(String valor, String data_str, String tipo) {
    this.valor = valor;
    data = new Calendario(data_str);
    this.tipo = tipo;
  }
}
