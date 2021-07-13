package Geral.Int;

public class NodoInt{
	private int dado;
	private NodoInt ant;
	
	public NodoInt(int dado) {
		this.dado = dado;
		this.ant = null;
	}

	public int getDado() {
		return dado;
	}

	public void setDado(int dado) {
		this.dado = dado;
	}

	public NodoInt getAnt() {
		return ant;
	}

	public void setAnt(NodoInt ant) {
		this.ant = ant;
	}

	@Override
	public String toString() {
		return "Geral.Char.Int.Nodo [dado=" + dado + "]";
	}	
}