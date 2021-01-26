package Geometria.Testes;

import Geometria.FormasBidimensionais.Circulo;
import Geometria.FormasBidimensionais.Quadrado;
import Geometria.FormasBidimensionais.Triangulo;
import Geometria.FormasTridimensionais.Cubo;
import Geometria.FormasTridimensionais.Esfera;
import Geometria.FormasTridimensionais.FormaTridimensional;
import Geometria.FormasTridimensionais.Tetraedro;

import java.util.ArrayList;

public class TestaTridimensionais {

    public static void main(String[] args) {

        ArrayList<FormaTridimensional> formas = new ArrayList<>();

        formas.add(new Esfera(2));
        formas.add(new Tetraedro(5));
        formas.add(new Cubo(10));

        formas.forEach( forma -> {
            System.out.println("\n ----------------------------------- \n");

            forma.mostrarNomeDaForma();
            System.out.println(" Volume: " + forma.calculaVolume());
        });

        System.out.println("\n ----------------------------------- \n");
    }
}
