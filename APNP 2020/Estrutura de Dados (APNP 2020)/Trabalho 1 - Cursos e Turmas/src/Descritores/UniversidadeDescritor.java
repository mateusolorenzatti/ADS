package Descritores;

import Nodos.DisciplinaNodo;

public class UniversidadeDescritor {
    DisciplinaNodo inicio;
    int tamanho;
    DisciplinaNodo fim;

    public UniversidadeDescritor(){
        inicio = null;
        tamanho = 0;
        fim = null;
    }

    public void setInicio( DisciplinaNodo inicio ){
        this.inicio = inicio;
    }

    public void setFim( DisciplinaNodo fim ){
        this.fim = fim;
    }

    public void incrementaTamanho(){
        tamanho++;
    }

    public void decrementaTamanho(){
        tamanho--;
    }

    public DisciplinaNodo getInicio(){
        return inicio;
    }

    public DisciplinaNodo getFim(){
        return fim;
    }

    public int getTamanho(){
        return tamanho;
    }
}
