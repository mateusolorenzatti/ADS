package Pilha;

import Helpers.CounterUsers;


/* Implementação de Pilha
 *
 * author: mateusolorenzatti
 * @IFRS Campus Farroupilha
 */
public class PilhaVetor {

    private Object[] array;
    private int topo;

    public PilhaVetor() {
    }

    public PilhaVetor(int tam) {
        this.topo = 0;

        if (tam <= 0) {
            CounterUsers.fechar();
        }

        this.array = new Object[tam];
    }

    public boolean estaVazio() {
        return (topo == 0) ? true : false;
    }

    public boolean estaCheio() {
        return (topo == this.array.length) ? true : false;
    }

    public int inserir(Object objeto) {
        if (!(this.estaCheio())) {
            this.array[topo] = objeto;
            this.topo++;
            return 1;
        }
        return -1;
    }
    
    public Object remove(){
        if(!(this.estaVazio())){
            this.topo --;
            return this.array[topo ++]; 
        }
        return -1;
    }
    
    public int tamanho(){
        return this.array.length;
    }
    
    @Override
    public String toString(){
        String r = "Vetor em Pilha: \n";
         
        for (int i = 0; i < this.topo; i++) {
            r += " " + (i+1) + ". " + this.array[i].toString() + "\n"; 
        }
        
        return r;
    }
}
