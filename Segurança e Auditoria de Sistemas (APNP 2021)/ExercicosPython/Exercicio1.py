
__author__ = 'Mateus Orlandin Lorenzatti'

"""
5)  Crie  um  programa  no  qual  o  usuário  pode  escolher  qual operação  ele  quer  fazer
    (+,  -,  *  ou  /)  e  digitar  dois  números. Como   saída   do   programa,   deve   ser
    mostrado   o   resultado. Lembre-se que não é possível dividir um número por zero.
"""

OPERANDOS_PERMITIDOS = ['+', '-', '*', '/']

def ler_operacao():
    return input("\n Digite a operação desejada: \n"
      " - '+' para adição; \n"
      " - '-' para subtração; \n"
      " - '*' para multiplicação; \n"
      " - '/' para divisão; \n"
      " - '0' para sair; \n \n"
      " Sua opção: ")

def ler_operandos():
    return (float(input(" Digite o primeiro valor: ")), float(input(" Digite o segundo valor: ")))

operacao = ''
op_1 = 0.0
op_2 = 0.0

print(" CALCULADORA ")

operacao = ler_operacao()

while(operacao != '0'):
    if operacao not in OPERANDOS_PERMITIDOS:
        print(" Operação inválida. Digite 0 se quiser sair. \n")

    else:
        op_1, op_2 = ler_operandos()

        if operacao == '+':
            print(" Resultado: {}".format( op_1 + op_2 ))

        elif operacao == '-':
            print(" Resultado: {}".format( op_1 - op_2 ))

        elif operacao == '*':
            print(" Resultado: {}".format( op_1 * op_2 ))

        elif operacao == '/':
            if op_2 == 0:
                print(" Impossível dividir por zero. Tente novamente.")
            else:
                print(" Resultado: {}".format( op_1 / op_2 ))

        else:
            pass

    operacao = ler_operacao()
