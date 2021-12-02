package com.mateusolorenzatti.Abstraction;

import com.mateusolorenzatti.Implementation.Transporte;

public abstract class Veiculo {
    protected Transporte transporte;
    protected String marca;

    protected Veiculo(String marca, Transporte transporte){
        this.transporte = transporte;
        this.marca = marca;
    }

    abstract public void realizarAtividade();
}
