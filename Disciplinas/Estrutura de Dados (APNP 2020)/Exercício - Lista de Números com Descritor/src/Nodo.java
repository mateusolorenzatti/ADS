public class Nodo{
	private Numero numero;
	private Nodo prox;
	
	public Nodo(Numero num){
		this.numero = num;
		prox = null;
	}

	public Numero getNumero() {
		return numero;
	}

	public void setNumero(Numero numero) {
		this.numero = numero;
	}

	public void setProx(Nodo nodo){
		this.prox = nodo;
	}
	
	public Nodo getProx(){
		return prox;
	}
	public String toString(){
		return numero.toString();
	}
}