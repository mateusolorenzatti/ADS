from typing import Final

# Caesar Cipher

# Every possible symbol that can be encrypted:
SYMBOLS: Final = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'

def ler_dados():
    mode = ''
    while mode not in ('encrypt', 'decrypt', 'exit'):
        mode = input(" Do you wish to encrypt or decrypt a message or exit? ")
        if mode == 'exit': return (mode, )

    message = input(" Enter your message: ")
    key = int(input(" Enter the key number (1-{}): ".format(len(SYMBOLS))))

    return (mode, message, key)

def cesar_cript(mode, message, key):
    # Stores the encrypted/decrypted form of the message:
    translated = ''

    for symbol in message:
        # Note: Only symbols in the `SYMBOLS` string can be encrypted/decrypted.
        if symbol in SYMBOLS:
            symbolIndex = SYMBOLS.find(symbol)

            # Perform encryption/decryption:
            if mode == 'encrypt':
                translatedIndex = symbolIndex + key
            elif mode == 'decrypt':
                translatedIndex = symbolIndex - key

            # Handle wrap-around, if needed:
            if translatedIndex >= len(SYMBOLS):
                translatedIndex = translatedIndex - len(SYMBOLS)
            elif translatedIndex < 0:
                translatedIndex = translatedIndex + len(SYMBOLS)

            translated = translated + SYMBOLS[translatedIndex]
        else:
            # Append the symbol without encrypting/decrypting:
            translated = translated + symbol

    print(" Your translated text is: \n {}".format(translated))

def main():
    while True:
        dados = ler_dados()

        if len(dados) == 1:
            break

        cesar_cript(*dados)

if __name__ == "__main__":
    main()
