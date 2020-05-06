package br.org.usuario;

import br.org.ferramentas.Input;

public class Cliente {
  private String tipo_pessoa, nome, telefone, endereco, email, user, password;
  public Carteira carteira;  
  
  //____________________________________G E T  &  S E T____________________________________
  public String getTipo_pessoa() {return tipo_pessoa;}
  public String getNome() {return nome;}
  public String getTelefone() {return telefone;}
  public String getEndereco() {return endereco;}
  public String getEmail() {return email;}
  public String getUser() {return user;}
  public String getPassword() {return password;}
  
  public void setTipo_pessoa(String tipo_pessoa) {this.tipo_pessoa = tipo_pessoa;}
  public void setNome(String nome) {this.nome = nome;}
  public void setTelefone(String telefone) {this.telefone = telefone;}
  public void setEndereco(String endereco) {this.endereco = endereco;}
  public void setEmail(String email) {this.email = email;}
  public void setUser(String user) {this.user = user;}
  public void setPassword(String password) {this.password = password;}
  
  
  //____________________________________C A D A S T R A R____________________________________
  public void cadastrar() {
	Input teclado = new Input(); 
    System.out.print("nome: ");nome = teclado.pegar_texto_teclado();
    System.out.print("telefone: ");telefone = teclado.pegar_texto_teclado();
    System.out.print("endereco: ");endereco = teclado.pegar_texto_teclado();
    System.out.print("email: ");email = teclado.pegar_texto_teclado();
    System.out.print("user: ");user = teclado.pegar_texto_teclado();
    System.out.print("password: ");password = teclado.pegar_texto_teclado();
    System.out.print("pessoa fisica[1] ou juridica[2]?: ");tipo_pessoa = teclado.pegar_texto_teclado();System.out.println("\n");
    carteira = new Carteira(tipo_pessoa);
  }
  //____________________________________L O G I N____________________________________
  public boolean login() {
	Input teclado = new Input();
	String user_tmp, password_tmp;
	System.out.print("user: ");user_tmp = teclado.pegar_texto_teclado();
	System.out.print("password: ");password_tmp = teclado.pegar_texto_teclado();
	if(this.user.equals(user_tmp) && this.password.equals(password_tmp)) {return true;}
	else {return false;}
  }
}
