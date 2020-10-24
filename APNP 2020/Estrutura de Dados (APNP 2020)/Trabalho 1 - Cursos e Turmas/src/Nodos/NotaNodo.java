package Nodos;

import Objetos.Aluno;

public class NotaNodo {

    private Double nota;
    private NotaNodo prox;

    public NotaNodo(Double nota){
        this.nota = nota;
        prox = null;
    }

    public Double getNota(){
        return nota;
    }
    public void setNota(Double nota){
        this.nota = nota;
    }

    public void setProx(NotaNodo nodo){
        this.prox = nodo;
    }

    public NotaNodo getProx(){
        return prox;
    }

    public String toString(){
        return this.nota.toString();
    }

}
