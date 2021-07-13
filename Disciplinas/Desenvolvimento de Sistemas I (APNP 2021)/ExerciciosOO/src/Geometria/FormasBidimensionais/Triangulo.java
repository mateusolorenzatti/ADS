package Geometria.FormasBidimensionais;

import Geometria.Interfaces.Desenho;

public class Triangulo extends FormaBidimencional implements Desenho {
    private float ladoA;
    private float ladoB;
    private float ladoC;

    private String tipo;

    public Triangulo(float ladoA, float ladoB, float ladoC) {
        super();

        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;

        this.classificaTriangulo();
    }

    @Override
    public float calculaArea() {
        float s = (this.ladoA + this.ladoB + this.ladoC) / 2;

        return (float) Math.sqrt ( s * ( s - this.ladoA ) * ( s - this.ladoB ) * ( s - this.ladoC ));
    }

    private boolean isTriangulo(){
        if (this.ladoA > (this.ladoB + this.ladoC)) {
            return false;
        }else if (this.ladoC > (this.ladoB + this.ladoA)){
            return false;
        }else if (this.ladoB >(this.ladoA + this.ladoC)){
            return false;
        }
        return true;
    }

    private void classificaTriangulo(){
        if (this.isTriangulo()) {
            if ((this.ladoA == this.ladoB) && (this.ladoB == this.ladoC)) {
                this.tipo = (" Triângulo Equilátero ");
            } else if (this.ladoA == this.ladoB || this.ladoB == this.ladoC || this.ladoC == this.ladoA){
                this.tipo = (" Triângulo Isóceles ");
            } else {
                this.tipo = (" Triangulo Escaleno ");
            }

        }else{
            this.tipo = "Não sou um triangulo!";
        }

    }

    @Override
    public void desenho() {
        this.mostrarNomeDaForma();

        System.out.println("\n");
        System.out.println(" Minha área: " + this.calculaArea());
        System.out.println(" Sou do tipo: " + this.tipo + "\n");
        System.out.println("                .                ");
        System.out.println("               ...               ");
        System.out.println("              .....              ");
        System.out.println("             .......             ");
        System.out.println("            .........            ");
        System.out.println("           ...........           ");
        System.out.println("          .............          ");
        System.out.println("         ...............         ");
    }

    @Override
    public void mostrarNomeDaForma() {
        System.out.println(" TRIANGULO ");
    }
}
