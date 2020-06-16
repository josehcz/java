import socket
from threading import Thread
from time import sleep

#sockets com o nome servidor, recebem a conxao de um socket cliente.
#sockets com o nome cliente, conectao com um socket servidor.

acessos = {}

#____________________________C .  C O N N E C T I O N____________________________
def cliente_connection(conexao_origem, origem):
  #"cliente_connection"
  #conecta os clientes e manda as mensagems
  #enviadas dos mesmos
  flag = True
  global acessos
  while True:
    try:
      msg = conexao_origem.recv(2048)
      if not msg:
        cliente = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        cliente.connect(acessos[origem])
        cliente.close()
        acessos.pop(origem, None)
        print('***',origem ,'Desconectou! ***')
        break
    except:
      conexao_origem.close()
      acessos.pop(origem, None)
      print('***',origem ,'Desconectou! ***')
      break
    if flag:
      IP_PORT_RECEPTOR = msg.decode().replace('(','').replace(')','').replace("'",'').split(',')
      IP_PORT_RECEPTOR = (IP_PORT_RECEPTOR[0], int(IP_PORT_RECEPTOR[1]))
      acessos[origem] = IP_PORT_RECEPTOR
      flag = False
    else:
      #replica msg para todos clientes
      msg_f = f'({origem[0]}:{origem[1]}): ' + msg.decode()
      for node in acessos.keys():
        if origem == node:
          continue
        cliente = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        cliente.connect(acessos[node])
        cliente.sendto(msg_f.encode(), acessos[node])
        cliente.close()
    print(f'{origem}: {msg}')
  conexao_origem.close()


#____________________________S T A R T____________________________
def S_T_A_R_T():
  TCP_receptor = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
  TCP_receptor.bind(('127.0.0.1', 2333))
  TCP_receptor.listen(1)
  print('*** Servidor Online! ***')
  while True:
    conexao_origem, origem = TCP_receptor.accept()
    print('*** Concetado por', origem,'***')
    Thread(target=cliente_connection, args=(conexao_origem, origem,)).start()


if __name__ == "__main__":
  S_T_A_R_T()
