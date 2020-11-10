import java.util.Scanner;

public class Menu{
	Leitura leTec;
	Turma turma;
	public Menu(){
		leTec = new Leitura();
		turma = new Turma();
		menu();
	}
	
	private void opcoes(){
		System.out.println("");
		System.out.println("1 - Inserir um Aluno no In�cio da Lista");
		System.out.println("2 - Inserir um Aluno no Fim da Lista");		
		System.out.println("3 - Inserir Aluno em uma Posi��o da Lista");
		
		
		System.out.println("4 - Excluir um Aluno no In�cio da Lista");
		System.out.println("5 - Excluir um Aluno no Fim da Lista");
		System.out.println("6 - Excluir um Aluno de uma Posi��o da Lista");
		System.out.println("7 - Excluir Aluno por Nome");


		System.out.println("8 - Listar os Alunos");
		System.out.println("9 - Informacões de IMC por categoria. \n");

		System.out.println("0 - Sair\n");
	}
	
	
	private Aluno leDados(){
		Aluno aux_aluno = new Aluno();
		aux_aluno.setMatricula(leTec.leInt("Matr�cula do Aluno: "));
		aux_aluno.setNome(leTec.leString("Nome do Aluno: "));
		aux_aluno.setPeso(leTec.leInt("Peso do Aluno: "));	
		aux_aluno.setAltura(leTec.leInt("Altura do Aluno: "));
		return aux_aluno;
	}
	
	public void menu(){
		int pos=0;
		char opc;
		String aux_nome;
		Aluno aluno;
		
		opcoes();
		opc = leTec.leChar("Digite a sua Op��o: ");
		while(opc != '0'){
		  switch(opc){
		     case '1': 	aluno = leDados();		// Leitura de Dados
		     			if(turma.insereInicio(aluno)) {
		     				System.out.println("Inser��o Ok!");
		     			}
		     			else {
					  	   	System.out.println("N�o foi poss�vel inserir!");
		     			}
		     			break;
	           
		     case '2': 	aluno = leDados();		// Leitura de Dados
		     			if(turma.insereFim(aluno)) {
		     				System.out.println("Inser��o Ok!");
						}
						else {
							System.out.println("N�o foi poss�vel inserir!");
						}
						break;
		               
		     case '3': 	aluno = leDados();		// Leitura de Dados
 	 					pos = leTec.leInt("Informe a Posi��o Para Inser��o do Aluno");
 	 					if(turma.inserePosicao(aluno,pos)){
 	 						System.out.println("Inser��o Ok!");
 	 					}
 	 					else {
 	 						System.out.println("N�o foi poss�vel inserir!");
 	 					}
 	 					break;
 	 					
		     case '4': 	if(turma.excluiInicio()) {
 	 						System.out.println("Exclus�o Ok!");
		     			}
			   			else {
			   				System.out.println("N�o foi poss�vel realizar a exclus�o!");
			   			}
	           			break;
	           			
		     case '5': 	if(turma.excluiFim()) {
	 	 					System.out.println("Exclus�o Ok!");
	  		   			}
			   			else {
			   				System.out.println("N�o foi poss�vel realizar a exclus�o!");
			   			}
	           			break;			    
		               
		     case '6': pos = leTec.leInt("Informe a Posi��o do Aluno");
		               if(turma.excluiPosicao(pos)) {
		            	   System.out.println("Exclus�o Ok!");
	  		   			}
			   			else {
			   				System.out.println("N�o foi poss�vel realizar a exclus�o!");
			   			}
		               break;
		               
		     case '7': 	aux_nome = leTec.leString("Nome do Aluno");
 	 					aluno = new Aluno(0, aux_nome,0,0);
 	 					if(turma.exclui(aluno)) {
 	 						System.out.println("Exclus�o Ok!");
 	 					}
 	 					else {
 	 						System.out.println("N�o foi poss�vel realizar a exclus�o!");
 	 					}
		               break;
		                  
		     case '8':  if(turma.vazia()) { 
 	 						System.out.println("N�o h� elementos na lista.");
  						}
  						else {
  							for(int i=0; i<turma.quantidadeAlunos(); i++){
  								aluno = turma.obtemAluno(i);
  								System.out.println(aluno.toString());
  							}
  						}
             			break;

			  case '9':  if(turma.vazia()) {
				 			 System.out.println("N�o h� elementos na lista.");
						  }
						  else {
							  System.out.println(turma.informacoesIMC());
						  }
						  break;
		  }
		  opcoes();
		  opc = leTec.leChar("Digite a sua Op��o: ");   
		}
	}
}