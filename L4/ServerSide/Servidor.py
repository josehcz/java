from Cliente import Cliente
import socket
from threading import Thread


class Servidor():
 
  def __init__(self):
    self._ACESSOS = list()


  def _adicionar_cliente(self, c: Cliente):
    self._ACESSOS.append(c) 


  def _deletar_cliente(self, c: Cliente):
    self._ACESSOS.remove(c)


  def _dados_cliente(self, socket_cliente):
    msg = socket_cliente.recv(2048)
    msg = msg.decode()
    msg = msg.split('\n')
    R = (msg[0].split(',')[0], int(msg[0].split(',')[1]))
    S = (msg[1].split(',')[0], int(msg[1].split(',')[1]))
    c = Cliente(R, S)
    self._adicionar_cliente(c)
    return c 

  
  def _enviar_msg_clientes(self, fmsg, usuario):
    for A in self._ACESSOS:
      if usuario.IP_PORT_RECEPTOR == A.IP_PORT_RECEPTOR:
        continue
      TCP_sender = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
      TCP_sender.connect(A.IP_PORT_RECEPTOR)
      TCP_sender.sendto(fmsg.encode(), A.IP_PORT_RECEPTOR)
      TCP_sender.close()


  def iniciar_servidor_tcp(self, HOST: str, PORT: int):
    self.TCP_receptor = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    self.TCP_receptor.bind((HOST, PORT))
    print('PORT:',self.TCP_receptor.getsockname())
    self.TCP_receptor.listen(1)
    while True:
      socket_cliente, IP_PORT_sender = self.TCP_receptor.accept()
      print('*** Concetado por', IP_PORT_sender,'***')
      usuario = self._dados_cliente(socket_cliente)
      Thread(target=self._cliente_conexao, args=(socket_cliente, usuario,)).start()


  def _cliente_conexao(self, socket_cliente, usuario):
    while True:
      msg = socket_cliente.recv(2048)
      if not msg:
        self._deletar_cliente(usuario)
        print('***',usuario.nome ,'Desconectou! ***')
        break
      fmsg = msg.decode()
      self._enviar_msg_clientes(fmsg, usuario)
      print(f'{msg}')
