from typing import Final
import random
import string

ALLOWED_CHARS: Final = string.ascii_letters + string.digits + '!?'

def random_string_generator(str_size):

    return ''.join(random.choice(ALLOWED_CHARS) for x in range(str_size))

def main():
    mensagens_len = int(input(" Insira o tamanho ads mensagens: "))
    quant_mensagens = int(input(" Insira a quantidade de mensagens a serem geradas: "))

    mensagens = [random_string_generator(mensagens_len) for _ in range(quant_mensagens)]
    random.shuffle(mensagens)

    print('\n')
    print(mensagens)

if __name__ == "__main__":
    main()