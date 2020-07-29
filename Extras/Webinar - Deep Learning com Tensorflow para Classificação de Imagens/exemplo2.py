from tensorflow import *
import numpy as np

'''
Problem:
Y = 2 * X - 1
'''

def main():
    
    PREDICT = [7.0]
    EPOCAS = 1000
    
    # cria o modelo sequencial com 1 camada (1 neurônio) e 1 dado de entrada
    model = keras.Sequential([keras.layers.Dense(units=1, input_shape=[1])]) #Dense representa uma camada de neurônios conectados
    model.compile(optimizer='sgd', loss='mean_squared_error') #define a forma como vai ser calculado o erro (médio quadrático)

    # inicializa os dados de entrada como dois arrays
    xs = np.array([1.00, 2.00, 3.00], dtype=float)
    ys = np.array([100000.00, 150000.00, 200000.00], dtype=float)

    # define o modelo (exemplos e épocas) para o treinamento
    model.fit(xs, ys, epochs=EPOCAS)

    # faz a predição do modelo para o valor de entrada 10
    print("\n RESULTADO -----------------------------------")
    print(model.predict(PREDICT))
    print(" --------------------------------------------- ")


if __name__ == '__main__':
    main()