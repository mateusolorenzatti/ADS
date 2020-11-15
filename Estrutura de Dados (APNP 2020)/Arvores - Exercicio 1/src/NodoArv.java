class NodoArv{
	  private NodoArv esq;
	  private int dado;
	  private NodoArv dir;
	  
	  public NodoArv( int d ){
	  	dado = d;
	  	esq = null;
	  	dir = null;
	  }
	  
	  public NodoArv getEsq(){
	  	return esq;
	  }
	  
	  public void setEsq(NodoArv e){
	  	esq = e;
	  }
	  
	  public NodoArv getDir(){
	  	return dir;
	  }
	  
	  public void setDir(NodoArv d){
	  	dir = d;
	  }
	  
	  public int getDado(){
	  	return dado;
	  }
	  
	  public void setDado(int dado){
	  	this.dado = dado;
	  }	  
}