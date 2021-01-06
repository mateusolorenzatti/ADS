__author__ = 'Mateus Orlandin Lorenzatti'

"""
Slides 8 - Arquivos e Exceções:
==========================
1) Faça um programa para gerenciar uma agenda de contatos. Para cada contato armazene o nome, o telefone e o aniversário. O programa deve permitir 
(1) inserir contato, (2) remover contato, (3) pesquisar um contato pelo nome, (4) listar todos os contatos, 
(5) listar os contatos cujo nome inicia com uma dada letra, 
(6) salvar dados em arquivo. Sempre que o programa for encerrado, 
os contatos devem ser armazenados em um arquivo. Quando o programa iniciar, os contatos devem ser lidos do mesmo arquivo.
"""

import pickle

FILE_PATH = r'./res/contatos.txt'

# afile = open(FILE_PATH, 'wb')
# pickle.dump(d, afile)
# afile.close()

file2 = open(FILE_PATH, 'rb')
new_d = pickle.load(file2)
file2.close()

print(new_d)
