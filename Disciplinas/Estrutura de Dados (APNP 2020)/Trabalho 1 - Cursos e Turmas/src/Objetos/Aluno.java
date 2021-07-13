package Objetos;

import Nodos.AlunoNodo;
import Nodos.NotaNodo;

public class Aluno{
	private String nome;

	private NotaNodo inicio;

	public Aluno() {
		this.nome = "";
		inicio = null;
	}

	public Aluno(int matricula, String nome) {
		super();
		this.nome = nome;
		this.inicio = null;
	}

	public boolean insereNota(Double nota){
		NotaNodo novo = new NotaNodo(nota);
		NotaNodo atual = this.inicio;

		if(this.inicio == null){
			this.inicio = novo;
		}
		else{
			while(atual.getProx() != null){
				atual = atual.getProx();
			}
			atual.setProx(novo);
		}
		return true;
	}
	
	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome=nome;
	}

	@Override
	public String toString() {
		return " Nome: " + nome + "; Média: " + this.calculaMediaDeNotas() + "; \n";
	}

	public Double calculaMediaDeNotas() {
		Double soma = 0.0;
		int quant = 0;
		NotaNodo atual = inicio;

		while( atual != null ) {
			soma += atual.getNota();
			quant ++;

			atual = atual.getProx();
		}

		if (quant == 0) { return 0.0; }

		return  soma / quant;
	}
}