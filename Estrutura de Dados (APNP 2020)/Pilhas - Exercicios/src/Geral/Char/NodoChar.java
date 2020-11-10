package Geral.Char;

public class NodoChar {
    private char ch;
    private NodoChar ant;

    public NodoChar(char ch) {
        this.ch = ch;
        this.ant = null;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public NodoChar getAnt() {
        return ant;
    }

    public void setAnt(NodoChar ant) {
        this.ant = ant;
    }

    @Override
    public String toString() {
        return "String.NodoChar [ch=" + ch + "]";
    }

}
