package Testes;

import Pilha.PilhaVetor;

public class Testes {
    public static void main(String[] args) {
        PilhaVetor pv = new PilhaVetor(10);
        
        pv.inserir(2);
        pv.inserir("Mateus");
        pv.inserir(87.2);
        
        System.out.println(pv.toString());
    }
}
