__author__ = 'Mateus Orlandin Lorenzatti'

"""
4) Faça um Programa que peça os 3 lados de um triângulo. 
O programa deverá informar se os valores podem ser um triângulo. 
Indique, caso os lados formem um triângulo, 
se o mesmo é: equilátero, isósceles ou escaleno (triangulo.py). 
"""

def ler_lados_triangulo():
    a = int(input(" Insira o tamanho do primeiro lado: "))
    b = int(input(" Insira o tamanho do segundo lado: "))
    c = int(input(" Insira o tamanho do terceiro lado: "))
    print("\n")

    return (a, b, c)

def verifica_triangulo(a, b, c):
    if a > (b + c) :
        return False
    elif c > (b + a) :
        return False
    elif b > (a + c):
        return False
    else:
        return True

def verifica_tipo_triangulo(a, b, c):
    if a == b == c:
        print(" Triângulo Equilátero ")
    elif a == b or b == c or c == a:
        print(" Triângulo Isóceles ")
    else:
        print(" Triangulo Escaleno ")

def main():
    triangulo = ler_lados_triangulo()

    if verifica_triangulo(*triangulo):
        verifica_tipo_triangulo(*triangulo)
    else:
        print(" Os lados não formam um triângulo!")

if __name__ == "__main__":
    main()
