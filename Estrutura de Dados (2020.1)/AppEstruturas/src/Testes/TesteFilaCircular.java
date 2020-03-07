package Testes;

import Estruturas.Fila.FilaCircular;
import Interfaces.I_TesteEstrutura;

/*
 * @author mateusolorenzatti
 */
public class TesteFilaCircular implements I_TesteEstrutura {

    private final int TAMANHO = 6;
    private FilaCircular fila;

    public TesteFilaCircular() {
        this.fila = new FilaCircular(TAMANHO);

        this.incluirNaEstrutura(20);
        this.incluirNaEstrutura("!");
        this.incluirNaEstrutura("Melão");
        
        this.removerDaEstrutura();
        
        this.incluirNaEstrutura(23124);
        
        this.removerDaEstrutura();
        
        this.incluirNaEstrutura("Never gonna Give you up");
        this.incluirNaEstrutura("Never gonna let you down");
        this.incluirNaEstrutura("Never gonna make you cry");
        
        this.removerDaEstrutura();
        
    }

    public void incluirNaEstrutura(Object param) {
        System.out.println("\n Inserindo o item " + param + " na lista... \n");

        this.fila.insere(param);

        System.out.println(this.fila.toStr());
    }

    public void removerDaEstrutura() {
        System.out.println("\n Removendo um item da lista... \n");

        this.fila.retira();

        System.out.println(this.fila.toStr());
    }

    public static void main(String[] args) {
        TesteFilaCircular tf = new TesteFilaCircular();
    }
}
