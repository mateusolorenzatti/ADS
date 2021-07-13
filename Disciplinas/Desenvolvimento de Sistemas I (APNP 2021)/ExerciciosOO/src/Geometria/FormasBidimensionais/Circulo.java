package Geometria.FormasBidimensionais;

import Geometria.Interfaces.Desenho;

public class Circulo extends FormaBidimencional implements Desenho {
    private float raio;

    public Circulo(float raio) {
        super();

        this.raio = raio;
    }

    @Override
    public float calculaArea() {
        return (float) Math.PI * (this.raio * this.raio);
    }

    @Override
    public void desenho() {
        this.mostrarNomeDaForma();

        System.out.println("\n");
        System.out.println(" Minha área: " + this.calculaArea() + "\n");
        System.out.println("             ......             ");
        System.out.println("         ..............         ");
        System.out.println("        ................        ");
        System.out.println("       ..................       ");
        System.out.println("       ..................       ");
        System.out.println("        ................        ");
        System.out.println("         ..............         ");
        System.out.println("             ......             ");
    }

    @Override
    public void mostrarNomeDaForma() {
        System.out.println(" CIRCULO ");
    }
}
