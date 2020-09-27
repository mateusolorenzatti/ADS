public class Turma{
	private Nodo inicio;
	
	public Turma(){
		inicio = null;
	}
	//Insere no In�cio da Lista
	public boolean insereInicio(Aluno aluno){
	  Nodo novo = new Nodo(aluno);
	    
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
	public boolean insereFim(Aluno aluno){		
		Nodo novo = new Nodo(aluno);
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
	
	public boolean inserePosicao(Aluno aluno, int pos){
		boolean res=false;
		Nodo novo = new Nodo(aluno);
		Nodo atual = inicio;
		Nodo ant = inicio;
		
		int i=0;
		int tamanho= quantidadeAlunos();
		
		if((pos < 0) || (pos>tamanho)) {
			return res;
		}
		if(pos == 0 ){ //insere no inicio
			res = insereInicio(aluno);
	    }
	    else{//
	    	if(pos == tamanho){
	    		res=insereFim(aluno);
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
	
	
	// Exerc�cio - Implementar o m�todo abaixo
	public boolean insereOrdenado(Aluno aluno){
		return false;
	}
	
	
	// Retorna verdadeiro ou falso se a lista est� vazia ou n�o.
	public boolean vazia() {
		return this.quantidadeAlunos()  == 0;
	}
		
	public int quantidadeAlunos(){
		Nodo atual = inicio;
		int res=0;
  
  		while(atual != null){
	 		res++;
	 		atual = atual.getProx();
	 	}
  		return res;	
	}
	
	public int verificaAluno(Aluno al){
		int posicao = 0;  
  		int resp = -1;
  		Nodo atual = inicio;
  		while((resp == -1) && (atual != null)){
	 		if(al.getNome().equals(atual.getAluno().getNome())==true){
        		resp = posicao;
     		}
     		else{
     			posicao++;
	 		}
	 		atual = atual.getProx();
  		}
  		return resp;
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
	
	// EXERC�CIO - Implementar o m�todo abaixo
	public boolean existe(Aluno aluno) {
		return false;
	}
	
	public boolean excluiInicio()
	{
		boolean res = false;  
		Nodo atual = inicio;
		if(inicio != null){
			inicio = inicio.getProx();
			atual.setProx(null);
			res=true;
		}
		return res;
	}
	public boolean excluiFim()
	{
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
	
	
	public boolean excluiPosicao(int pos){
		Nodo atual = inicio;
		Nodo ant = null;
		boolean res = false;
		
		int qtdeAlunos = this.quantidadeAlunos();
		
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
	
	public boolean exclui(Aluno aluno){
		boolean res=false;  
  		Nodo atual = inicio;
  		Nodo ant = null;
  
  		if(inicio != null){ //Lista existe
     		if(verificaAluno(aluno) == -1){ // Verifica se o valor existe na lista
        		res=false;
     		}
     		else{
          		if(inicio.getProx() == null){ //testa se a lista s� possui um elemento
          		// Valor existe na lista, mas a lista s� possui um elemento
             		inicio = null;
          		}
          		else{
          			if(atual.getAluno().getNome().equals(aluno.getNome())==true){
          				//Lista possui v�rios elementos e o elemento a ser excluido � o primeiro
                  		res = excluiInicio();
               		}
               		else{ //acha o valor a ser exclu�do
               			while(atual.getAluno().getNome().equals(aluno.getNome()) == false){
                     		ant = atual;
                     		atual = atual.getProx();
                  		}
                  		ant.setProx(atual.getProx());
                  		res=true;
               		}
          		}  
     		}
  		}
  		return res;
	}

}