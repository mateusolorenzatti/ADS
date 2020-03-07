package Testes;

import Estruturas.Pilha.PilhaVetor;
import Interfaces.I_TesteEstrutura;

/*
 * @author mateusolorenzatti
 */
public class TestePilha implements I_TesteEstrutura {

    private final int TAMANHO = 6;
    private PilhaVetor pilha;

    public TestePilha() {
        this.pilha = new PilhaVetor(TAMANHO);

        this.incluirNaEstrutura(20);
        this.incluirNaEstrutura("!");
        this.incluirNaEstrutura("Melão");
        
        this.removerDaEstrutura();
        
        this.incluirNaEstrutura(23124);
        
        this.removerDaEstrutura();
    }

    public void incluirNaEstrutura(Object param) {
        System.out.println("\n Inserindo o item " + param + " na lista... \n");

        this.pilha.inserir(param);

        System.out.println(this.pilha.toStr());
    }

    public void removerDaEstrutura() {
        System.out.println("\n Removendo um item da lista... \n");

        this.pilha.remove();

        System.out.println(this.pilha.toStr());
    }

    public static void main(String[] args) {
        TestePilha tf = new TestePilha();
    }
}
