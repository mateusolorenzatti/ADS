public class TestaArvore{
	
	public static void main(String args[]){
		
		Arvore arv = new Arvore();
		int val=0;
		boolean res;
		
		System.out.println( "Inserindo Valores..." );

	    arv.insNodo(100);
	    arv.insNodo(50);
	    arv.insNodo(150);
	    arv.insNodo(40);
	    arv.insNodo(10);
	    arv.insNodo(59);
	    arv.insNodo(23);
	    arv.insNodo(145);
	    arv.insNodo(3);
	    arv.insNodo(7);
	    arv.insNodo(499);

		System.out.print("\n Pre-Fixado: [ ");
		arv.preFixado( );

		System.out.print("]\n Central: [ ");
		arv.central( );

		System.out.print("]\n Pos-Fixado: [ ");
		arv.posFixado( );
		System.out.println("]\n");

		System.out.println(" Valor 35 pertence à arvore? " + (arv.pesquisa(35) ? "Sim" : "Não") + "\n");

		System.out.println(" Menor valor: " + arv.encontraMenorNaoRecursivo());
		System.out.println(" Maior valor: " + arv.encontraMaiorRecursivo());
		System.out.println(" Número de pares: " + arv.encontraNumerosParesRecursivo());
		System.out.println(" Soma dos primos: " + arv.encontraSomaDePrimosRecursivo());
		System.out.println(" Altura: " + arv.alturaDaArvore());
		System.out.println(" Qtde de Nodos: " + arv.encontraNumeroDeNodosNaoRecursivo());

		System.out.print("\n Após Remoção: [ ");
		arv.remove( 100 );
		arv.central();
		System.out.println("]");
	}
}