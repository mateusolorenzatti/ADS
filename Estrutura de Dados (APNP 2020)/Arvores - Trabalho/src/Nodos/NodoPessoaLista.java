package Nodos;

import Objetos.Pessoa;

public class NodoPessoaLista {
    private Pessoa pessoa;
    private NodoPessoaLista prox;

    public NodoPessoaLista(Pessoa p){
        this.pessoa = p;
        prox = null;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public NodoPessoaLista getProx() {
        return prox;
    }

    public void setProx(NodoPessoaLista prox) {
        this.prox = prox;
    }

    @Override
    public String toString() {
        return this.pessoa.toString();
    }
}