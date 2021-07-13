package Estruturas.Fila;

/*
 * @author Rogério Xavier
 */
public class FilaCircular {

    private int inicio, fim, numElementos;
    private Object array[];

    public FilaCircular(int tamanho) {
        this.inicio = 0;
        this.fim = 0;
        this.numElementos = 0;
        this.array = new Object[tamanho];
    }

    public boolean vazia() {
        if (numElementos == 0) {
            return true;
        }
        return false;
    }

    public boolean cheia() {
        if (numElementos == array.length) {
            return true;
        }
        return false;
    }

    public void insere(Object elemento) {
        if (!cheia()) {
            array[fim] = elemento;
            numElementos++;

            fim = (fim + 1) % array.length;

        } else {
            System.out.println("Fila Cheia");
        }
    }

    public Object retira() {
        Object elemento = null;
        if (!vazia()) {
            elemento = array[inicio];
            array[inicio] = null;
            numElementos--;

            inicio = (inicio + 1) % array.length;

        } else {
            System.out.println("Fila vazia");
        }
        return elemento;
    }

    public int getTamanho() {
        return this.numElementos;
    }

    public String toStr() {
        String saida = "Fila Circular: \n";
        for (int i = 0; i < array.length; i++) {
            saida += " - " + array[i] + "\n";
        }
        saida += "\n inicio=" + this.inicio + " \n final=" + this.fim + "\n";
        return saida;
    }

}
