package model;

import java.io.Serializable;

public class Pontuacao implements Serializable{
	private int acumulado;
	private int partidas;
	private int ultPartida;

	public Pontuacao(int acumulado, int partidas, int ultPartida) {
		this.acumulado = acumulado;
		this.partidas = partidas;
		this.ultPartida = ultPartida;
	}
	public Pontuacao() {
		this.acumulado = 0;
		this.partidas = 0;
		this.ultPartida = 0;
	}
	public int getAcumulado() {
		return acumulado;
	}
	public void setAcumulado(int acumulado) {
		this.acumulado = acumulado;
	}
	public int getPartidas() {
		return partidas;
	}
	public void setPartidas(int partidas) {
		this.partidas = partidas;
	}
	public int getUltPartida() {
		return ultPartida;
	}
	public void setUltPartida(int ultPartida) {
		this.ultPartida = ultPartida;
	}
	@Override
	public String toString() {
		return "Pontuacao [acumulado=" + acumulado + ", partidas=" + partidas + ", ultPartida=" + ultPartida + "]";
	}

	
	

}
