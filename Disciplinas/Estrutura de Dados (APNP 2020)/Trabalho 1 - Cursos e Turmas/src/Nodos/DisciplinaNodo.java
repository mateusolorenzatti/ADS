package Nodos;

import Objetos.Disciplina;

public class DisciplinaNodo {
	private Disciplina disciplina;
	private DisciplinaNodo prox;
	private DisciplinaNodo ant;
	
	public DisciplinaNodo(Disciplina dis){
		this.disciplina = dis;
		ant = null;
		prox = null;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void setProx(DisciplinaNodo nodo){
		this.prox = nodo;
	}
	
	public DisciplinaNodo getProx(){
		return prox;
	}
	public void setAnt(DisciplinaNodo nodo){
		this.ant = nodo;
	}
	
	public DisciplinaNodo getAnt(){
		return ant;
	}

	public String toString(){
		return disciplina.toString();
	}
	
}