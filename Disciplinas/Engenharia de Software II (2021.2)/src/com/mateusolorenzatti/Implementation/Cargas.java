package com.mateusolorenzatti.Implementation;

public class Cargas implements Transporte {
    @Override
    public void transportar() {
        System.out.println("Veículo Transportando Cargas");
    }

    @Override
    public void descricaoTransporte() {
        System.out.println("Veículo que Transporta Cargas");
    }
}