package Testes;

import Pilha.PilhaVetor;
import Pilha.PilhaVetor;
import java.util.Stack;

public class TestesPilhaVetor {
    public static void main(String[] args) {
        PilhaVetor pv = new PilhaVetor(10);
        
        pv.inserir(2);
        pv.inserir("Mateus");
        pv.inserir(87.2);
        
        System.out.println(pv.toString());
        
        // Já implementado pelo Java
        
        Stack myStack = new Stack();
        
        // Push -> Adiciona
        // Pop -> Remove
        
    }
}