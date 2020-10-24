package Nodos;

import Objetos.Aluno;

public class AlunoNodo {
	private Aluno aluno;
	private AlunoNodo prox;
	
	public AlunoNodo(Aluno al){
		this.aluno = al;
		prox = null;
	}
	
	public Aluno getAluno(){
		return aluno;
	}
	public void setAluno(Aluno al){
		aluno = al;
	}
	
	public void setProx(AlunoNodo nodo){
		this.prox = nodo;
	}
	
	public AlunoNodo getProx(){
		return prox;
	}
	public String toString(){
		return aluno.toString();
	}
}