public class Turma{
	private Nodo inicio;
	private Nodo fim;
	
	public Turma(){
		inicio = null;
		fim = null;
	}
	//Insere no Início da Lista
	public boolean insereInicio(Aluno aluno){
		Nodo novo = new Nodo(aluno);
	    if(inicio == null){
	    	inicio = novo;
	    	fim = novo;
	    }
	    else{
	    	novo.setProx(inicio);
	    	inicio.setAnt(novo);
	    	inicio=novo;
	    	
	    	// Ajuste dos ponteiros circulares
	    	inicio.setAnt(fim);
	    	fim.setProx(inicio);
	    }
	    return true; //Sempre consegue inserir se tiver memória
	}
	
	//Insere no fim da lista
	public boolean insereFim(Aluno aluno){
		Nodo novo = new Nodo(aluno);
		if(inicio == null){
		     inicio = novo;
		     fim = novo;
		}
		else{
		 	fim.setProx(novo);
		    novo.setAnt(fim);
		    fim=fim.getProx();
		    
	    	// Ajuste dos ponteiros circulares
	    	inicio.setAnt(fim);
	    	fim.setProx(inicio);
		}
		return true;
	}
	
	public boolean inserePosicao(Aluno aluno, int pos){
		Nodo novo = new Nodo(aluno);
		Nodo atual = inicio;
		Nodo ant = inicio;
		boolean res = false;
		
		int i=0;
		int tamanho= quantidadeAlunos();
		
		if((pos<0) || (pos > tamanho)) { //Posição inválida
			return res; // Retorna false, não inseriu
		}
		
		if((tamanho == 0) || (pos == 0)){ // Lista Vazia ou posição informada é zero
	     	res = this.insereInicio(aluno);
	  	}
	  	else{
            if(pos == tamanho){ 
	               res = this.insereFim(aluno);
	        }
	        else{ //posicao válida
	        	for(i=0;i<pos;i++){
	        		ant = atual;
	                atual = atual.getProx();
	            }
	            ant.setProx(novo);
	            novo.setAnt(ant);
	               
	            novo.setProx(atual);   
	            atual.setAnt(novo);
	            res = true;
	        }
	    }
		return res;
	}
			
	public int quantidadeAlunos(){
		Nodo atual = inicio;
		int res=0;
  
		// O LAÇO DEVE FINALIZAR QUANDO INICIO == FIM (PARA NÃO ENTRAR EM LOOP INFINITO)
  		while(atual != fim){
	 		res++;
	 		atual = atual.getProx();
	 	}
  		if(atual != null) {
  			res++;
  		}
  		return res;	
	}
	
	public int verificaAluno(Aluno aluno){
		int posicao = 0;  
  		int resp = -1;
  		Nodo atual = inicio;
  		while((resp == -1) && (atual != null)){
	 		if(aluno.getNome().equals(atual.getAluno().getNome())==true){
        		resp = posicao;
     		}
     		else{
     			posicao++;
	 		}
	 		atual = atual.getProx();
  		}
  		return resp;
	}
	
	// Retorna verdadeiro ou falso se a lista está vazia ou não.
	public boolean vazia() {
		return this.quantidadeAlunos()  == 0;
	}

	public Aluno obtemAluno(int pos){
		int aux=0;
		Aluno aluno = null;
		Nodo atual = inicio;
		
		if((pos>=0) && (pos< this.quantidadeAlunos())){
			for(int i=0;i<pos;i++){
					atual = atual.getProx();
			}
			aluno = atual.getAluno();
		}
		return aluno;
	}
	
	public boolean excluiInicio()
	{
		boolean res=false;  
		Nodo atual = inicio;
		if(inicio==null){ //Lista vazia - não pode excluir
			return res;
		}
		else{
			if(inicio == fim) { // Lista de apenas um nodo
				inicio = null;
				fim = null;
				res = true;
			}
			else {
				inicio=inicio.getProx();
				
				// Ajuste dos ponteiros circulares
				inicio.setAnt(fim);
		    	fim.setProx(inicio);
				
				res = true;
			}			
		}
		return res;
	}
	
	public boolean excluiFim()
	{
		boolean res=false;  
		Nodo atual = inicio;
		if(inicio==null){ //Lista vazia - não pode excluir
			return res;
		}
		else{
			if(inicio == fim) { // Lista de apenas um nodo
				inicio = null;
				fim = null;
				res = true;
			}
			else { //Lista com vários nodos
				fim = fim.getAnt();
				
				// Ajuste dos ponteiros circulares
				fim.setProx(inicio);
				inicio.setAnt(fim);
				res=true;
			}
		}
		return res;
	}

	
	
	public boolean excluiPosicao(int pos){
		boolean res=false;
		Nodo atual = inicio;
		Nodo ant = null;
		int qtdAlunos = this.quantidadeAlunos();
		
		if((pos<0) || (pos>qtdAlunos-1)){ // Informada uma posição inválida
			return res; // Posição inválida 
		}
		if( inicio == null) { // Lista Vazia - não pode excluir o que não existe
			return res;
		}
		
		//Lista existe
		if(pos == 0) { 
			res = this.excluiInicio();
		}
		else { 
			if(pos == qtdAlunos-1) {
				res = this.excluiFim();
			}
			else { 
				for(int i=0; i<pos; i++){
					ant = atual;
					atual = atual.getProx();
				}
				ant.setProx(atual.getProx());
				atual.getProx().setAnt(atual.getAnt());
				res = true;
			}
		}
		return res;
	}
	
	public boolean exclui(Aluno aluno){
		boolean res=false;
		Nodo atual = inicio;
		Nodo ant = null;
		int qtdAlunos = this.quantidadeAlunos();
		int posAluno = 0;
		
		if( inicio == null) { // Lista Vazia - não pode excluir o que não existe
			return res;
		}
		else {
			posAluno = verificaAluno(aluno);// Verifica se o aluno existe na lista, retornando a sua posição na lista
			if( posAluno == -1){ // Aluno não está presente na lista
				res = false;
			}
			else { //Aluno está presente na lista
				res = this.excluiPosicao(posAluno);	
			}
		}
		return res;
	}
}