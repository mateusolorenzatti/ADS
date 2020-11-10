package Geral.Int;

public class PilhaInt{

	NodoInt topo;
	public PilhaInt(){
		topo=null;
	}
	
	public boolean isEmpty() { //Testa se a pilha est� vazia
		return topo == null;
	}

	public int tamanho(){
		if ( this.isEmpty() ) return 0;

		NodoInt atual = topo;
		int res=0;

		while(atual != null){
			res++;
			atual = atual.getAnt();
		}
		return res;
	}
	
	public void push( int dado ){ // Empilha
		NodoInt aux = new NodoInt(dado);
		if(topo==null){
			topo = aux;
		}
		else{
			aux.setAnt(topo);
			topo = aux;
		}
	}
	
	public NodoInt pop() { //Desempilha
		NodoInt aux=null;
		if(this.isEmpty()==false){ //Geral.Char.Int.Pilha n�o est� vazia
			aux = topo;
			topo = topo.getAnt();		
			aux.setAnt(null);
		}
		return aux;
	}
	
	public NodoInt peek() { //Retorna o topo da pilha, mas n�o retira da pilha
		NodoInt aux=null;
		if(this.isEmpty()==false){
			aux = new NodoInt(topo.getDado());//Cria uma c�pia do nodo do topo da pilha
		}
		
		return aux;
	}
}