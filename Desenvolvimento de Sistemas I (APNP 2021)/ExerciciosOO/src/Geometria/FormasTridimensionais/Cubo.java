package Geometria.FormasTridimensionais;

public class Cubo extends FormaTridimensional{
    private float lado;

    public Cubo(float lado) {
        super();

        this.lado = lado;
    }

    @Override
    public float calculaVolume() {
        return (float) Math.pow(this.lado, 2);
    }
}
