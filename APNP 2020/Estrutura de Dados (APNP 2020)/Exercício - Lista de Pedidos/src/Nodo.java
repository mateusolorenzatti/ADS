public class Nodo{
	private Pedido pedido;
	private Nodo prox;

	public Nodo(){
		this.pedido = null;
		this.prox = null;
	}
	
	public Nodo(Pedido ped){
		this.pedido = ped;
		prox = null;
	}
	
	public Pedido getPedido(){
		return pedido;
	}
	public void setPedido(Pedido ped){
		pedido = ped;
	}
	
	public void setProx(Nodo nodo){
		this.prox = nodo;
	}
	
	public Nodo getProx(){
		return prox;
	}
	public String toString(){
		return pedido.toString();
	}
}