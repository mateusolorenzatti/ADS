import java.util.Scanner;

public class Menu{
	Leitura leTec;
	ListaNumero lista;

	public Menu(){
		leTec = new Leitura();
		lista = new ListaNumero();
		menu();
	}
	
	private void opcoes(){
		System.out.println("");
		System.out.println("1 - Inserir um numero na Lista");
		System.out.println("2 - Listar os números");

		System.out.println("0 - Sair\n");
	}
	
	public void menu(){
		int pos=0;
		char opc;
		String aux_nome;
		int numero;

		opcoes();
		opc = leTec.leChar("Digite a sua Op��o: ");
		while(opc != '0'){
		  switch(opc){
		     case '1': 	numero = this.leTec.leInt(" Insira o número: ");

		     			if(lista.insereAntesDoMaior(new Numero(numero))) {
		     				System.out.println("Inser��o Ok!");
		     			}
		     			else {
					  	   	System.out.println("N�o foi poss�vel inserir!");
		     			}
		     			break;

		     case '2': 	String numeros = lista.toString();
		                System.out.println(numeros);
						break;
		  }
		  opcoes();
		  opc = leTec.leChar("Digite a sua Op��o: ");   
		}
	}
}