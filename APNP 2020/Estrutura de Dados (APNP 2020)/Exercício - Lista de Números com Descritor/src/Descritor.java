
public class Descritor {
	Nodo inicio;
	int tamanho;
	Nodo fim;
	Nodo maior;

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

	public Nodo getMaior() {
		return maior;
	}

	public void setMaior(Nodo maior) {
		this.maior = maior;
	}
}
