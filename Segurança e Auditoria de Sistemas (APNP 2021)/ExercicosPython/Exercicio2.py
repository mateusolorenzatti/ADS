__author__ = 'Mateus Orlandin Lorenzatti'

"""
Slide 3
1) Faça um programa que leia 4 números e mostre a soma e a multiplicação dos
mesmos.
"""

def main():
    numeros = []
    i = 0

    # Ler os números
    for i in range(0, 4):
        numeros.append(float(input(" Insira o {}º valor: ".format(i+1))))

    # Calcular a soma
    soma = 0
    for numero in numeros:
        soma += numero

    # Calcular o produto
    produto = 1
    for numero in numeros:
        produto *= numero

    print("\n Resultados: \n Soma: {} \n Produto: {}".format(soma, produto))

if __name__ == "__main__":
    main()