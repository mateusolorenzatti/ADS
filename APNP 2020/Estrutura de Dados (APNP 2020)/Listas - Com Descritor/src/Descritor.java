
public class Descritor {
	Nodo inicio;
	int tamanho;
	Nodo fim;
	
	Descritor(){  
	  inicio = null;
	  tamanho = 0;
	  fim = null;
	}
	
	void setInicio( Nodo inicio ){
		this.inicio = inicio;
    }
    
    void setFim( Nodo fim ){
    	this.fim = fim;
    }
    
    void incrementaTamanho(){
    	tamanho++;
    }

    void decrementaTamanho(){
    	tamanho--;
    }	
	
	Nodo getInicio(){
		return inicio;
    }
    
	Nodo getFim(){
		return fim;
    }
    
    int getTamanho(){
    	return tamanho;
	}
}
