from typing import Final
import random
import string

ALLOWED_CHARS: Final = string.ascii_letters + string.digits + '!?'

def random_string_generator(str_size):

    return ''.join(random.choice(ALLOWED_CHARS) for x in range(str_size))

def main():
    mensagens = [random_string_generator(10) for _ in range(5)]
    random.shuffle(mensagens)

    print(mensagens)

if __name__ == "__main__":
    main()