package Geometria.Testes;

import Geometria.FormasBidimensionais.Circulo;
import Geometria.FormasBidimensionais.Quadrado;
import Geometria.FormasBidimensionais.Triangulo;

public class TestaBidimensionais {

    public static void main(String[] args) {

        Circulo c = new Circulo(2);
        c.desenho();

        System.out.println("\n ----------------------------------- \n");

        Triangulo t = new Triangulo(2, 3, 2);
        t.desenho();

        System.out.println("\n ----------------------------------- \n");

        Quadrado q = new Quadrado(2);
        q.desenho();
    }

}
