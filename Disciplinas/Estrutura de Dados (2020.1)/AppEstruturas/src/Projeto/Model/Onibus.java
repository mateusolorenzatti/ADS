package Projeto.Model;

/*
 * @author mateusolorenzatti
 */
public class Onibus implements Comparable<Onibus>{
    private String modelo;
    private int ano;
    private int capacidadePassageiros;

    public Onibus(String modelo, int ano, int capacidadePassageiros) {
        this.modelo = modelo;
        this.ano = ano;
        this.capacidadePassageiros = capacidadePassageiros;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    public void setCapacidadePassageiros(int capacidadePassageiros) {
        this.capacidadePassageiros = capacidadePassageiros;
    }

    public int compareTo(Onibus o) {
        if (this.getCapacidadePassageiros() > o.getCapacidadePassageiros()){
            return 1;
        }else if (this.getCapacidadePassageiros() < o.getCapacidadePassageiros()){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return " Onibus: " + " modelo=" + modelo + ", ano=" + ano + ", capacidadePassageiros=" + capacidadePassageiros + " \n";
    }
    
}
