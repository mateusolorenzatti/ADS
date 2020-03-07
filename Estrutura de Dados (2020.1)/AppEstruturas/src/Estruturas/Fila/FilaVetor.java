/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estruturas.Fila;

/**
 *
 * @author Xavier & mateusolorenzatti
 */
public class FilaVetor {

    private int inicio, fim;
    private Object array[];

    public FilaVetor(int tam) {
        this.inicio = 0;
        this.fim = 0;
        this.array = new Object[tam];
    }

    public boolean vazia() {
        if (this.inicio == this.fim) {
            return true;
        }
        return false;
    }

    public boolean cheia() {
        if (this.fim==this.array.length){
            return true;
        }
        return false;
    }

    public void insere(Object elem) {
        if (!cheia()) {
            this.array[this.fim] = elem;
            this.fim++;
        } else {
            System.out.println("Fila Cheia");
        }
    }

    public Object retira() {
        Object temp = null;
        if (!vazia()) {
            temp = this.array[this.inicio];
            this.array[this.inicio] = null;
            this.inicio++;
        } else {
            System.out.println("Fila vazia");
        }
        return temp;
    }

    public int getTamanho() {
        return (this.fim - this.inicio);
    }
    
    public String toStr(){
        String str = "Fila: \n";
        
        for (int i = this.inicio; i < this.fim; i++) {
            str += " - " + this.array[i] + "\n";
        }
        
        str += " --------------------- ";
        str += " Total de itens: " + (this.fim - this.inicio);
        
        return str;
    }

}
