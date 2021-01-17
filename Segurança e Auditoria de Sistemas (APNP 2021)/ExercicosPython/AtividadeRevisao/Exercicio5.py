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

class Contato:
    def __init__(self, nome, aniversario, telefone):
        self.nome = nome
        self.aniversario = aniversario
        self.telefone = telefone

    def __str__(self):
        return '{} - Aniv: {} - Tel: +{}'.format(self.nome, self.aniversario, self.telefone)

def ler_operacao():
    return input("\n Digite a operação desejada: \n"
      " - (1) inserir contato; \n"
      " - (2) remover contato; \n"
      " - (3) pesquisar um contato pelo nome; \n"
      " - (4) listar todos os contatos; \n"
      " - (5) listar os contatos cujo nome inicia com uma dada letra; \n "
      " - (6) salvar dados em arquivo.; \n "
      " - (0) salvar e sair; \n "
      " Sua opção: ")

def salvar_arq(caminho, dados):
    afile = open(caminho, 'wb')
    pickle.dump(dados, afile)
    afile.close()

def main():
    FILE_PATH = r'res/contatos.txt'
    contatos = []

    file2 = open(FILE_PATH, 'rb')
    contatos = pickle.load(file2)
    file2.close()

    operacao = ler_operacao()

    while (operacao != '0'):

        if operacao == '1':
            nome = input(" Digite o nome do contato: ")
            aniv = input(" Digite o aniversario do contato: ")
            tele = input(" Digite o telefone do contato: ")

            contatos.append(Contato(nome, aniv, tele))

            print(" Contato adicionado! ")

        elif operacao == '2':
            nome = input(" Digite o nome do contato a ser apagado: ")
            tamanho_antes = len(contatos)

            for contato in contatos:
                if contato.nome == nome:
                    contatos.remove(contato)

            if tamanho_antes == len(contatos):
                print(" Contato não encontrado! ")
            else:
                print(" Contato removido! ")

        elif operacao == '3':
            nome = input(" Digite o nome do contato a ser consultado: ")
            encontrado = False

            for contato in contatos:
                if contato.nome == nome:
                    print(contato)
                    encontrado = True

            if not encontrado: print(" Contato inexistente! ")

        elif operacao == '4':
            if len(contatos) == 0:
                print(" Nenhum cadastro existente! ")

            for contato in contatos:
                print('{}'.format(contato))

        elif operacao == '5':
            letra = input(" Digite a letra inicial: ")
            encontrado = False

            if len(letra) == 1:
                for contato in contatos:
                    if contato.nome[0].lower() == letra.lower():
                        print(contato)
                        encontrado = True

                if not encontrado: print(" Nenhum nome começa com a letra {}! ".format(letra))
            else:
                print(" Isso não é uma letra...")

        elif operacao == '6':
            salvar_arq(FILE_PATH, contatos)
            print(" Contatos salvos com sucesso! ")

        else:
            print(" Operação inválida. Digite 0 se quiser sair. \n")

        operacao = ler_operacao()

    print("Salvando e saindo...")
    salvar_arq(FILE_PATH, contatos)

if __name__ == "__main__":
    main()