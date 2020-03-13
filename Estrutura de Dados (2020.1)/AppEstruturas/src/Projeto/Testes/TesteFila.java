package Projeto.Testes;

import Estruturas.Fila.FilaVetor;
import Projeto.Interfaces.I_TesteEstrutura;

/*
 * @author mateusolorenzatti
 */
public class TesteFila implements I_TesteEstrutura{

    private final int TAMANHO = 6;
    private FilaVetor fila;

    public TesteFila() {
        this.fila = new FilaVetor(TAMANHO);
        
        this.incluirNaEstrutura(20);
        this.incluirNaEstrutura("!");
        this.incluirNaEstrutura("Melão");
        
        this.removerDaEstrutura();
        
        this.incluirNaEstrutura(23124);
        
        this.removerDaEstrutura();
    }

    public void incluirNaEstrutura(Object param) {
        System.out.println("\n Inserindo o item " + param + " na lista... \n");

        this.fila.insere(param);

        this.mostrarElementos();
    }

    public void removerDaEstrutura() {
        System.out.println("\n Removendo um item da lista... \n");

        this.fila.retira();

        this.mostrarElementos();
    }

    public static void main(String[] args) {
        TesteFila tf = new TesteFila();
    }

    @Override
    public void mostrarElementos() {
        System.out.println(this.fila.toStr());
    }
}
