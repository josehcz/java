import socket
from threading import Thread
from time import sleep

#sockets com o nome servidor, recebem a conxao de um socket cliente.
#sockets com o nome cliente, conectao com um socket servidor.


IP_PORT_RECEPTOR = '?'
IP_PORT_SERVER = ('127.0.0.1', 2333)

#____________________________C E S A R ____________________________
def cesar(msg: str, chave: int, modo: str):
  #modo = '+' é cifrar
  #modo = '-' é descifrar 
  alpha = 'abcdefghijklmnopqrstuvxwyz'
  nova_msg = ''
  for m in msg:
    if m not in alpha:
      nova_msg += m
    elif modo == '+': 
      nova_msg += alpha[(alpha.find(m)+chave)%26]
    elif modo == '-':
      nova_msg += alpha[(alpha.find(m)-chave)%26]
  return nova_msg 


#____________________________S .  C O N N E C T I O N____________________________
def server_connection(servidor):
  #"server_connection"
  #é conctado pelo servidor: 127.0.0.1:2333
  #recebe as mensagems dos outro clientes
  global IP_PORT_RECEPTOR, IP_PORT_SERVER
  while True:
    conexao_origem, origem = servidor.accept()
    msg = conexao_origem.recv(2048)
    if not msg: break
    print(cesar(msg.decode(), 23, '-'))
    conexao_origem.close()


#____________________________S T A R T____________________________
def S_T_A_R_T():
  global IP_PORT_RECEPTOR, IP_PORT_SERVER
  cliente = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
  cliente.connect(IP_PORT_SERVER)
  
  #____________________Conectando no servidor____________________#
  servidor = socket.socket(socket.AF_INET, socket.SOCK_STREAM)   #
  servidor.bind(('127.0.0.1', 0))                                #
  IP_PORT_RECEPTOR = servidor.getsockname()                      #
  servidor.listen(1)                                             #
  Thread(target=server_connection, args=(servidor,)).start()     #
  cliente.sendto(str(IP_PORT_RECEPTOR).encode(), IP_PORT_SERVER) #
  #______________________________________________________________#
  
  print('*** Seu Endereco:',cliente.getsockname(),'***')
  print('Para sair use CTRL+X \n')
  while True:
    msg = input()
    if msg == '\x18': 
      break
    cliente.sendto(cesar(msg, 23, '+').encode(), IP_PORT_SERVER)
  cliente.close()


if __name__ == "__main__":
  S_T_A_R_T()
