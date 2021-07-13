public class Nodo{
	private Aluno aluno;
	private Nodo prox;
	
	public Nodo(Aluno al){
		this.aluno = al;
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
	public String toString(){
		return aluno.toString();
	}
}