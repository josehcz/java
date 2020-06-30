class Cesar:
  def __init__(self, mensagem: str, chave: int):
    self.mensagem = mensagem
    self.chave = chave
    

  def cifra(self, modo: str):
    #modo = '+' é cifrar
    #modo = '-' é descifrar 
    alpha = 'abcdefghijklmnopqrstuvxwyz'
    nova_msg = ''
    for char in self.mensagem:
      if char not in alpha:
        nova_msg += char
      elif modo == '+': 
        nova_msg += alpha[(alpha.find(char)+self.chave)%26]
      elif modo == '-':
        nova_msg += alpha[(alpha.find(char)-self.chave)%26]
    return nova_msg 
