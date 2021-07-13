package Geometria.FormasBidimensionais;

import Geometria.Interfaces.Desenho;

public class Quadrado extends FormaBidimencional implements Desenho {
    private float lado;

    public Quadrado(float lado) {
        super();

        this.lado = lado;
    }

    @Override
    public float calculaArea() {
        return (float) Math.pow(this.lado, 2);
    }

    @Override
    public void desenho() {
        this.mostrarNomeDaForma();

        System.out.println("\n");
        System.out.println(" Minha área: " + this.calculaArea() + "\n");
        System.out.println("         ...............         ");
        System.out.println("         ...............         ");
        System.out.println("         ...............         ");
        System.out.println("         ...............         ");
        System.out.println("         ...............         ");
        System.out.println("         ...............         ");
    }

    @Override
    public void mostrarNomeDaForma() {
        System.out.println(" QUADRADO ");
    }
}
