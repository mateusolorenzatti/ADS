__author__ = 'Mateus Orlandin Lorenzatti'

"""
2) Modularize o programa implementado no exercício 1. 
Ou seja, crie funções  para cada uma das ações realizadas. 
Quando uma ação for repetida, ao invés de escrever o código novamente, 
deve-se chamar o nome da função criada que executa o código. 
Crie no mínimo 3 funções e o programa principal main.
"""

def ler_numeros():
    numeros = []
    i = 0

    # Ler os números
    for i in range(0, 4):
        numeros.append(float(input(" Insira o {}º valor: ".format(i + 1))))
    return numeros

def calcular_soma(numeros):
    # Calcular a soma
    soma = 0
    for numero in numeros:
        soma += numero

    return soma

def calcular_produto(numeros):
    # Calcular o produto
    produto = 1
    for numero in numeros:
        produto *= numero

    return produto

def exibir_resultados(soma, produto):
    print("\n Resultados: \n Soma: {} \n Produto: {}".format(soma, produto))

def main():
    numeros = ler_numeros()

    soma = calcular_soma(numeros)
    produto = calcular_produto(numeros)

    exibir_resultados(soma, produto)

if __name__ == "__main__":
    main()