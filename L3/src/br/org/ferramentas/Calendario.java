package br.org.ferramentas;


/*  
 *  sg  te  qa  qi  sx  sa dm
 *   1   2   3   4   5   6  7
 *   8   9  10  11  12  13 14
 *  15  16  17  18  19  20 21
 *  22  23  24  25  26  27 28
 *  29  30
 */


public class Calendario {
  public String dia, mes;
  public Calendario(String data_str) {
    dia = Character.toString(data_str.charAt(0)) +  Character.toString(data_str.charAt(1));
    mes = Character.toString(data_str.charAt(3)) +  Character.toString(data_str.charAt(4));
  }
  public int get_opcao() {
    if(Integer.parseInt(dia) > 0 && Integer.parseInt(dia) < 8) {return 1;}
    if(Integer.parseInt(dia) > 7 && Integer.parseInt(dia) < 15) {return 2;}
    if(Integer.parseInt(dia) > 14 && Integer.parseInt(dia) < 22) {return 3;}
    if(Integer.parseInt(dia) > 21 && Integer.parseInt(dia) < 29 ) {return 4;}
    if(Integer.parseInt(dia) > 28 && Integer.parseInt(dia) < 31) {return 5;}
    return -1;
  }
  public String mostra_data() {
    return dia + "/" + mes;
  }
}
