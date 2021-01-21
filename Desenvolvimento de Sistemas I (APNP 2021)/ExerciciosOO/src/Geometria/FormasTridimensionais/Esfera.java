package Geometria.FormasTridimensionais;

public class Esfera extends FormaTridimensional{
    private float raio;

    public Esfera(float raio) {
        super();

        this.raio = raio;
    }

    @Override
    public float calculaVolume() {
        return (float) ( 4/3 * Math.PI * (Math.pow(this.raio, 3)) );
    }
}
