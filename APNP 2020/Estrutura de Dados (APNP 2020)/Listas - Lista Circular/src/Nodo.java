public class Nodo{
	private Aluno aluno;
	private Nodo prox;
	private Nodo ant;
	
	public Nodo(Aluno al){
		this.aluno = al;
		ant = null;
		prox = null;
	}
	
	public Aluno getAluno(){
		return aluno;
	}
	public void setAluno(Aluno al){
		aluno = al;
	}
	
	public void setProx(Nodo nodo){
		this.prox = nodo;
	}
	
	public Nodo getProx(){
		return prox;
	}
	public void setAnt(Nodo nodo){
		this.ant = nodo;
	}
	
	public Nodo getAnt(){
		return ant;
	}
	public String toString(){
		return aluno.toString();
	}
	
}