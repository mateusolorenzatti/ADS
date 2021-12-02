package com.mateusolorenzatti.Implementation;

public class Pessoas implements Transporte {
    @Override
    public void transportar() {
        System.out.println("Veículo Transportando Pessoas");
    }

    @Override
    public void descricaoTransporte() {
        System.out.println("Veículo que Transporta Pessoas");
    }
}
