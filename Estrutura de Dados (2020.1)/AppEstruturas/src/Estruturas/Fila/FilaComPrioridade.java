
package Estruturas.Fila;

/*
 * @author Rogério Xavier
 */

public class FilaComPrioridade<T> extends Fila<T> {

    @Override
    public void insere(T t) {
        Comparable<T> chave = (Comparable<T>) t;
        int i;
        for ( i = 0; i < this.getTamanho(); i++) {
            if (chave.compareTo(this.objetos.get(i)) < 0){
                break;
            }            
        }
        this.objetos.add(i, t);
    }

    @Override
    public String toString() {
        return "FilaComPrioridade (" +this.objetos + ")";
    }

}
