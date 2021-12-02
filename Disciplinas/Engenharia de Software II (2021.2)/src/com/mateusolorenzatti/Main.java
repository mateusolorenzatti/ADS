package com.mateusolorenzatti;

import com.mateusolorenzatti.Abstraction.Caminhao;
import com.mateusolorenzatti.Abstraction.Onibus;
import com.mateusolorenzatti.Abstraction.Veiculo;
import com.mateusolorenzatti.Implementation.Cargas;
import com.mateusolorenzatti.Implementation.Pessoas;

public class Main {
    public static void main(String[] args) {
        System.out.println(" ---------------------------------------- ");

        Veiculo caminhao = new Caminhao("Scania", new Cargas());
        caminhao.realizarAtividade();

        System.out.println(" ---------------------------------------- ");

        Veiculo onibus = new Onibus("Mercedes", new Pessoas());
        onibus.realizarAtividade();

        System.out.println(" ---------------------------------------- ");

        Veiculo onibus2 = new Onibus("Volvo", new Cargas());
        onibus2.realizarAtividade();

        System.out.println(" ---------------------------------------- ");

    }
}
