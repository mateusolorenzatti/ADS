# Affine Cipher
# Adaptado o código de: https://www.geeksforgeeks.org/implementation-affine-cipher/

def egcd(a, b):
    x, y, u, v = 0, 1, 1, 0
    while a != 0:
        q, r = b // a, b % a
        m, n = x - u * q, y - v * q
        b, a, x, y, u, v = a, r, u, v, m, n
    gcd = b
    return gcd, x, y

def modinv(a, m):
    gcd, x, y = egcd(a, m)
    if gcd != 1:
        return None
    else:
        return x % m

def affine_encrypt(text, key):
    '''
    C = (a*P + b) % 26
    '''
    return ''.join([chr(((key[0] * (ord(t) - ord('A')) + key[1]) % 26)
                        + ord('A')) for t in text.upper().replace(' ', '')])

def affine_decrypt(cipher, key):
    '''
    P = (a^-1 * (C - b)) % 26
    '''
    return ''.join([chr(((modinv(key[0], 26) * (ord(c) - ord('A') - key[1]))
                         % 26) + ord('A')) for c in cipher])

def main():
    text = input('Mensagem: ')

    key = []
    key.append(int(input('Insira a chave A (inteiro): ')))
    key.append(int(input('Insira a chave B (inteiro): ')))

    mode = input("Modo (encrypt ou decrypt): ")

    if mode == 'encrypt':
        print('Resultado: {}'.format(affine_encrypt(text, key)))
    elif mode == 'decrypt':
        print('Resultado: {}'.format(affine_decrypt(text, key)))
    else:
        print("Modo inválido!")

if __name__ == '__main__':
    main()

# This code is contributed by 
# Bhushan Borole

