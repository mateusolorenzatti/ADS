package Geometria.FormasTridimensionais;

public class Tetraedro extends FormaTridimensional{
    private float aresta;

    public Tetraedro(float aresta) {
        super();

        this.aresta = aresta;
    }

    @Override
    public float calculaVolume() {
        return (float) (Math.pow(this.aresta, 3) * Math.sqrt(2)) / 12;
    }
}
