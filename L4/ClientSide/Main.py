import socket
from Cliente import Cliente
from Cesar import Cesar
from threading import Thread

def server_connection(TCP_receptor):
  while True:
    socket_origem, origem = TCP_receptor.accept()
    msg = socket_origem.recv(2048)
    if not msg: break
    msg = Cesar(msg.decode(), 23)
    print(msg.cifra('-'))
    socket_origem.close()


def main():
  IP_PORT_SERVER = ('127.0.0.1', 2333) 
  TCP_sender = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
  TCP_sender.connect(IP_PORT_SERVER)

  TCP_receptor = socket.socket(socket.AF_INET, socket.SOCK_STREAM)   
  TCP_receptor.bind(('127.0.0.1', 0))    
  

  MSG_INICIAL = TCP_receptor.getsockname()[0] +', '+ str(TCP_receptor.getsockname()[1]) + '\n'
  MSG_INICIAL += TCP_sender.getsockname()[0] + ', '+ str(TCP_sender.getsockname()[1])
  
  
  TCP_receptor.listen(1)                                             
  Thread(target=server_connection, args=(TCP_receptor,)).start()     
  TCP_sender.sendto(MSG_INICIAL.encode(), IP_PORT_SERVER)

  print('Para sair use CTRL+X \n')
  while True:
    msg = input()
    if msg == '\x18': 
      break
    msg = Cesar(msg, 23)
    TCP_sender.sendto(msg.cifra('+').encode(), IP_PORT_SERVER)
  TCP_sender.close()


main()




