import com.sun.xml.internal.ws.wsdl.writer.UsingAddressing;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class ListaPedidos{
	private Nodo inicio;

	private boolean primeiroMenor;

	public ListaPedidos(){
		inicio = null;
		primeiroMenor = true;
	}

	public ListaPedidos(Nodo inicio){
		this.inicio = inicio;
		primeiroMenor = true;
	}

	//Insere no In�cio da Lista
	public boolean insereInicio(Pedido pedido){
	  Nodo novo = new Nodo(pedido);

	  if(inicio == null){
	     inicio = novo;
	  }
	  else{
	  	 novo.setProx(inicio);
		 inicio=novo;
	  }
	  return true; //Sempre consegue inserir (s� n�o consegue se n�o houver mem�ria dispon�vel)
	}

	//Insere no fim da lista
	public boolean insereFim(Pedido pedido){
		Nodo novo = new Nodo(pedido);
		Nodo atual = inicio;

		if(inicio == null){
		     inicio = novo;
		}
		else{
		  while(atual.getProx() != null){
			 atual = atual.getProx();
		  }
		  atual.setProx(novo);
		}
		return true; //Sempre consegue inserir (s� n�o consegue se n�o houver mem�ria dispon�vel)
	}

	public boolean inserePosicao(Pedido pedido, int pos){
		boolean res=false;
		Nodo novo = new Nodo(pedido);
		Nodo atual = inicio;
		Nodo ant = inicio;

		int i=0;
		int tamanho= quantidadePedidos();

		if((pos < 0) || (pos>tamanho)) {
			return res;
		}
		if(pos == 0 ){ //insere no inicio
			res = insereInicio(pedido);
	    }
	    else{//
	    	if(pos == tamanho){
	    		res=insereFim(pedido);
	        }
	        else{ //posicao v�lida
	        	for(i=0;i<pos;i++){
	                  ant = atual;
	                  atual = atual.getProx();
	            }
	            ant.setProx(novo);
	            novo.setProx(atual);
	            res=true;
	        }
	   }
	  return res; //Sempre consegue inserir (s� n�o consegue se n�o houver mem�ria dispon�vel)
	}

	public boolean vazia() {
		return this.quantidadePedidos()  == 0;
	}

	public int quantidadePedidos(){
		Nodo atual = inicio;
		int res=0;

  		while(atual != null){
	 		res++;
	 		atual = atual.getProx();
	 	}
  		return res;
	}

	public boolean excluiInicio() {
		boolean res = false;
		Nodo atual = inicio;
		if(inicio != null){
			inicio = inicio.getProx();
			atual.setProx(null);
			res=true;
		}
		return res;
	}

	public Pedido trazDoInicio() {
		boolean res = false;
		Nodo atual = inicio;
		if(inicio != null){
			inicio = inicio.getProx();
			atual.setProx(null);
		}
		return atual.getPedido();
	}

	public boolean excluiFim() {
		boolean res=false;
		Nodo atual = inicio;
		Nodo ant = null;
		if(inicio != null){
			while(atual.getProx() != null){
				ant = atual;
				atual = atual.getProx();
			}
			if(ant != null) { // ant � diferente de nulo se houve navega��o
				ant.setProx(null);
			}
			else { // ant � null. Lista com um �nico elemento (n�o navegou)
				inicio = null;
			}
			res=true;
		}
		return res;
	}

	public Pedido trazDoFim() {
		Nodo atual = inicio;
		Nodo ant = null;
		Pedido pedidoFim = null;

		if(inicio != null){
			while(atual.getProx() != null){
				ant = atual;
				atual = atual.getProx();
			}
			if(ant != null) {
				ant.setProx(null);
			}
			else {
				inicio = null;
			}
			pedidoFim = atual.getPedido();
		}

		return pedidoFim;
	}

	public boolean excluiPosicao(int pos){
		Nodo atual = inicio;
		Nodo ant = null;
		boolean res = false;

		int qtdeAlunos = this.quantidadePedidos();

		if(qtdeAlunos == 0) {
			return res; //Lista Vazia
		}

		if((pos >= 0) && (pos < qtdeAlunos)){

			if(pos== qtdeAlunos){ //Excluir o �ltimo aluno
				res = this.excluiFim();
			}
			else{
				if(pos==0){ //Excluir o primeiro aluno
					res = this.excluiInicio();
				}
				else{
					for(int i=0; i<pos; i++){
						ant = atual;
						atual = atual.getProx();
					}
					ant.setProx(atual.getProx());
					res = true;
				}
			}
		}
		return res;
	}

	private Nodo sortedMerge(Nodo a, Nodo b) {
		Nodo result = null;
		if (a == null)
			return b;
		if (b == null)
			return a;

		if (a.getPedido().getTempoAtendimento() <= b.getPedido().getTempoAtendimento()) {
			result = a;
			result.setProx(sortedMerge(a.getProx(), b));
		}
		else {
			result = b;
			result.setProx(sortedMerge(a, b.getProx()));
		}
		return result;
	}

	private Nodo ordenaLista(Nodo h) {
		if (h == null || h.getProx() == null) {
			return h;
		}
		Nodo middle = getMeio(h);
		Nodo nextofmiddle = middle.getProx();

		middle.setProx(null);

		Nodo left = ordenaLista(h);

		Nodo right = ordenaLista(nextofmiddle);

		Nodo sortedlist = sortedMerge(left, right);
		return sortedlist;
	}

	private static Nodo getMeio(Nodo head) {
		if (head == null)
			return head;

		Nodo slow = head, fast = head;

		while (fast.getProx() != null && fast.getProx().getProx() != null) {
			slow = slow.getProx();
			fast = fast.getProx().getProx();
		}
		return slow;
	}

	public void ordenarAtendimento(){
		ListaPedidos listaOrdenada = new ListaPedidos(this.ordenaLista(this.inicio));

		// Recriar a lista prioncipal do 'zero'
		this.inicio = null;

		int pos = 0;
		while(!listaOrdenada.vazia()){

			if (this.primeiroMenor){
				if (pos % 2 == 0){
					this.insereFim(listaOrdenada.trazDoInicio());
				}else{
					this.insereFim(listaOrdenada.trazDoFim());
				}
			}else{
				if (pos % 2 == 0){
					this.insereFim(listaOrdenada.trazDoFim());
				}else{
					this.insereFim(listaOrdenada.trazDoInicio());
				}
			}

			pos ++;
		}
	}

	public boolean atendePedido() {
		this.ordenarAtendimento();

		this.primeiroMenor = !this.primeiroMenor;
		return this.excluiInicio();
	}

	public String exibeLista() {
		this.ordenarAtendimento();

		String saida = "";

		if(!this.vazia()){
			Nodo atual = inicio;

			while(atual != null){
				saida += atual.getPedido().toString() + "\n";

				atual = atual.getProx();
			}
		}

		return saida;
	}

	public String informacoesPedido(int pedido) {
		String resposta = " Pedido inexistente! ";
		Nodo temp = this.inicio;

		int pos = 0;
		int tempoDeEspera = 0;

		while (temp != null) {
			if(temp.getPedido().getNumero() == pedido){
				resposta = " O pedido " + pedido + " está na posição " + ( pos + 1 ) + " e levará cerca de " + (tempoDeEspera + temp.getPedido().getTempoAtendimento()) + " minutos para ser atendido! ";
				break;

			}else{
				tempoDeEspera += temp.getPedido().getTempoAtendimento();
			}

			pos ++;
			temp = temp.getProx();
		}

		return resposta;
	}

}