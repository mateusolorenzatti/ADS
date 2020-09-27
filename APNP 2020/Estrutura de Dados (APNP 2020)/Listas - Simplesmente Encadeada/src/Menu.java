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
		System.out.println("1 - Inserir Aluno no Início da Lista");
		System.out.println("2 - Inserir Aluno no Fim da Lista");
		System.out.println("3 - Inserir Aluno em uma Posição");
		System.out.println("4 - Inserir um Aluno em Ordem Alfabética por Nome");
		System.out.println("5 - Informa a Existência de um Aluno");
		System.out.println("6 - Retorna um Aluno de uma Posição Informada");
		System.out.println("7 - Excluir um Aluno de uma Posição Informada");
		System.out.println("8 - Excluir Aluno por Nome");
		System.out.println("9 - Exclui um Aluno do Início da Lista");
		System.out.println("f - Exclui um Aluno do Fim da Lista");
		
		System.out.println("i - Listar os Alunos\n");
		System.out.println("0 - Sair\n");
	}
	
	
	private Aluno leDados(){
		Aluno aux_aluno = new Aluno();
		aux_aluno.setMatricula(leTec.leInt("Matrícula do Aluno: "));
		aux_aluno.setNome(leTec.leString("Nome do Aluno: "));
		aux_aluno.setPeso(leTec.leInt("Peso do Aluno: "));	
		aux_aluno.setAltura(leTec.leInt("Altura do Aluno: "));
		return aux_aluno;
	}
	
	public void menu(){
		String aux_nome;
		int pos=0;
		char opc;
		Aluno aluno;
		
		opcoes();
		opc = leTec.leChar("Digite a sua Opção: ");
		while(opc != '0'){
		  switch(opc){
		     case '1': aluno = leDados();		// Leitura de Dados
			           if(turma.insereInicio(aluno)) {
			        	   System.out.println("Inserção Ok!");
			           }
			           else {
			          	   System.out.println("Não foi possível inserir!");
			           }
			           break;
		     case '2': aluno = leDados();		// Leitura de Dados
		               if(turma.insereFim(aluno)) {
		            	   System.out.println("Inserção Ok!");
		               }
		               else {
		            	   System.out.println("Não foi possível inserir!");
		               }
		               break;
		               
		     case '3': 	aluno = leDados();		// Leitura de Dados
		    	 		pos = leTec.leInt("Informe a Posição Para Inserção do Aluno");
		    	 		if(turma.inserePosicao(aluno,pos)){
		    	 			System.out.println("Inserção Ok!");
			            }
			            else {
			            	System.out.println("Não foi possível inserir!");
			            }
			            break;
			            
		     case '4': //EXERCÍCIO 		    	 
		    	 		
		    	 		aluno = leDados();		// Leitura de Dados
						if(turma.insereOrdenado(aluno)){
			 	 			System.out.println("Inserção Ok!");
			            }
			            else {
			            	System.out.println("Não foi possível inserir!");
			            }
			            
			            break;
			            
		     case '5': 	// EXERCÍCIO
		    	 		aux_nome = leTec.leString("Nome do Aluno");
		    	 		aluno = new Aluno(0, aux_nome,0,0);
			 	 		if(turma.existe(aluno)){
			 	 			System.out.println("O aluno "+aluno.getNome() + " está presente na lista.");
			            }
			            else {
			            	System.out.println("O aluno "+aluno.getNome() + " não está presente na lista.");
			            }
			            
			            break;		
	            
		     case '6': pos = leTec.leInt("Informe a Posição do Aluno na Lista");
		               aluno = turma.obtemAluno(pos);
		               if(aluno == null) {
		            	   System.out.println("Aluno não encontrado!");
		               }
		               else {
		            	   System.out.println(aluno.toString());
		               }
		               break;
		               
		     case '7': pos = leTec.leInt("Informe a Posição do Aluno na Lista");
		               aluno = turma.obtemAluno(pos);
		               if(aluno == null) {
		            	   System.out.println("Posição Inválida!");
		            	   System.out.println("Aluno não encontrado!");
		               }
		               else {
		            	   if(turma.excluiPosicao(pos)) {
		            		   System.out.println("Exclusão Ok!");
		            	   }
		            	   else {
		            		   System.out.println("Não foi possível realizar a exclusão!");
		            	   }
		               }
		               break;
		               
		     case '8':  aux_nome = leTec.leString("Nome do Aluno");
		    	 		aluno = new Aluno(0, aux_nome,0,0);
		    	 		if(turma.exclui(aluno)) {
		    	 			System.out.println("Exclusão Ok!");
		    	 		}
		    	 		else {
		    	 			System.out.println("Não foi possível realizar a exclusão!");
		    	 		}
		               break;
		     case '9': if(turma.excluiInicio()) {
		    	 			System.out.println("Exclusão Ok!");
		     		   }
					   else {
			 	 			System.out.println("Não foi possível realizar a exclusão!");
			 	 	   }
			           break;
		     case 'f': if(turma.excluiFim()) {
			 	 			System.out.println("Exclusão Ok!");
			  		   }
					   else {
			 	 			System.out.println("Não foi possível realizar a exclusão!");
			 	 	   }
			           break;			    
		     case 'i': 	if(turma.vazia()) { 
		    	 			System.out.println("Não há elementos na lista.");
		     			}
		     			else {
		     				for(int i=0; i<turma.quantidadeAlunos(); i++){
			     				aluno = turma.obtemAluno(i);
			     				System.out.println(aluno.toString());
			                }
		     			}
		                break;
		  }
		  opcoes();
		  opc = leTec.leChar("Digite a sua Opção: ");   
		}
	}
}