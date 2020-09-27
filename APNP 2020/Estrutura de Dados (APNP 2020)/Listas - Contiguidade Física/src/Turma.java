public class Turma{
	private final int TAM = 20;
	private Aluno turma[];
	private int qtde;
	
	public Turma(){
		turma = new Aluno[TAM];
		qtde = 0;
	}
	
	public boolean insereFim(Aluno aluno){
		boolean res=false;
		if(qtde < TAM){
			turma[qtde] = aluno;
			res = true;
			qtde++;
		}
		return res;
	}
	
	/* Exerc�cio 01
	 *  Implementar a inser��o de um aluno no in�cio da lista. O m�todo deve retornar verdadeiro 
	 *  (true) se a inser��o foi realizada. Se a inser��o n�o foi realizada, o m�todo deve retornar falso (false).
	 *  
	 *  Dica: Deslocar todos os elementos uma posi��o para a direita,
	 *  para abrir espa�o para a inser��o de um novo aluno no in�cio da lista.
	 *  
	 *  Assinatura do m�todo:
	 *  public boolean insereInicio(Aluno aluno);
	 */

	public boolean insereInicio(Aluno aluno){
		return this.inserePosicao(aluno, 0);
	}
	
	/* Exerc�cio 02
	 *  Considere uma lista ordenada pelo nome do aluno.
	 *  Implementar a inser��o de um aluno na sua posi��o correta.
	 *  O m�todo deve retornar verdadeiro (true) se a inser��o foi realizada. Se a inser��o n�o foi realizada, 
	 *  o m�todo deve retornar falso (false).
	 *  
	 *  Dica: Encontrar a posi��o correta onde a inser��o deve ser realizada. 
	 *  Em seguida, deslocar todos os elementos uma posi��o para a direita (se houver espa�o para 
	 *  o deslocamento). Realizar a inser��o na posi��o correta.
	 *  
	 *  IMPORTANTE: N�O inserir no final da lista e, em seguida, orden�-la.
	 *  
	 *  Assinatura do m�todo:
	 *  public boolean insereOrdenado(Aluno aluno);
	 */

	public boolean insereOrdenado(Aluno aluno){
		for(int i = 0; i < qtde; i ++){
			if (aluno.getNome().compareTo(turma[i].getNome()) <= 0){
				// Se encontra a letra 'maior' alfabeticamente, adiciona ali
				return inserePosicao(aluno, i);
			}
		}

		// Se não encontrar, adiciona no final
		return insereFim(aluno);
	}
	
	// Insere um aluno em uma determinada posi��o da lista. Retorna true se conseguiu inserir e retorna false 
	// se n�o conseguiu inserir.
	public boolean inserePosicao(Aluno aluno, int pos){
		boolean res=false;
		//Retorna se n�o h� espa�o para inserir
		if(qtde == TAM){
			return false;
		}
		
		//Se a posi��o � igual a quantidade, chamar o m�todo para inserir no fim do vetor
		if(pos == qtde){
			res = this.insereFim(aluno);
		}
		else{
			if((pos>=0) && (pos<qtde)){ //Testa se � uma posi��o v�lida para inserir
				//Desloca os alunos uma posi��o para a direita
				for(int i=qtde;i>pos;i--){
					turma[i]=turma[i-1];
				}
				turma[pos] = aluno; //Insere
				qtde++; //Incrementa a quantidade de alunos
				res = true;
			}
		}	
		return res;
	}
	
	// Retorna a quantidade de alunos presentes na lista
	public int quantidadeAlunos(){
		return qtde;
	}
	
	// Retorna verdadeiro ou falso se a lista est� vazia ou n�o.
	public boolean vazia() {
		return this.quantidadeAlunos()  == 0;
	}
	
	// Retorna o aluno de uma determinada posi��o da lista (acesso direto a uma posi��o da lista)
	public Aluno obtemAluno(int pos){
		Aluno aluno = null;
		if((pos>=0) && (pos<qtde)){
			aluno = turma[pos];
		}
		return aluno;
	}
	
	/* Exerc�cio 03
	 * 
	 * Escreva um m�todo que retorna verdadeiro (true) se um aluno, recebido por par�metro,
	 * est� presente na lista. Se o aluno n�o estiver presente na lista o m�todo deve retornar 
	 * falso (false).
	 * 
	 * Para determinar se o aluno est� presente ou n�o na lista, o nome do aluno passado por par�metro 
	 * deve ser comparado com os nomes dos alunos presentes na lista.
	 * 
	 * Assinatura do m�todo:
	 * public boolean existe(Aluno aluno); 
	 */

	public boolean existe(Aluno aluno){
		return (verificaAluno(aluno) >= 0);
	}
	
	/* O m�todo abaixo retorna a posi��o da lista em que um determinado aluno foi encontrado.
	 * Se o aluno n�o est� presente na lista o m�todo retorna "-1".
	 */
	public int verificaAluno(Aluno al){
		int achou = -1; // Aluno N�O est� na lista
		int i = 0;
  
   		while((achou==-1) && (i<qtde)){ //procura o aluno atrav�s do nome
      		if( (al.getNome().equals(turma[i].getNome()))== true){
         		achou = i; //Recebe a posi��o do aluno encontrado
      		}
      		else{
        	 	i++;
      		}
   		}
   		return achou;
	}
	
	/* Exerc�cio 04
	 * Escreva o m�todo que exclui o primeiro aluno da lista. O m�todo deve retornar verdadeiro (true) 
	 * se a exclus�o foi realizada ou retornar falso (false) se a exclus�o n�o pode ser realizada.
	 * 
	 * Assinatura do m�todo
	 * public boolean excluiInicio(Aluno aluno);
	 * 
	 */

	public boolean excluiInicio(Aluno aluno){
		return this.excluiPosicao(0);
	}
	
	/* Exerc�cio 05
	 * Escreva o m�todo que exclui o �ltimo aluno da lista. O m�todo deve retornar verdadeiro (true) 
	 * se a exclus�o foi realizada ou retornar falso (false) se a exclus�o n�o pode ser realizada.
	 * 
	 * Assinatura do m�todo
	 * public boolean excluiFim(Aluno aluno);
	 * 
	 */
	public boolean excluiFim(Aluno aluno){
		return this.excluiPosicao( this.qtde - 1 );
	}
	
	/* Exerc�cio 06
	 * Escreva o m�todo que exclui um aluno da lista, se o mesmo existir. Fa�a uso dos m�todos previamente existentes.
	 * 
	 * Verifique a posi��o em que o aluno se encontra na lista. Se estiver no in�cio, exclua-o com a execu��o do 
	 * m�todo excluiInicio. Se estiver no fim, exclua-o com a execu��o do m�todo excluiFim. Se n�o estiver no in�cio 
	 * ou no fim, escreva as instru��es para remov�-lo.
	 * 
	 */

	public boolean excluiAluno(Aluno aluno){
		boolean achou = false;
		boolean res = false;
		int i = 0;

		while((achou==false) && (i<qtde)){
			if(aluno.getNome().equals(turma[i].getNome())==true){
				achou = true;
			}
			else{
				i++;
			}
		}

		if(achou==true){
			if(i == 0) res = this.excluiInicio(aluno);
			else if(i == (qtde - 1)) res = this.excluiInicio(aluno);
			else res = this.excluiPosicao(i);
		}

		return res;
	}

	//Exclui um aluno da lista (se o aluno estiver presente na lista).
	public boolean exclui(Aluno aluno){
		boolean achou = false;
		boolean res = false;
		int i = 0;
				  
		while((achou==false) && (i<qtde)){ //procura o aluno atrav�s do nome
			if(aluno.getNome().equals(turma[i].getNome())==true){
				achou = true;
			}
			else{
				i++;
			}
		}
				
		if(achou==true){ //achou o aluno na lista
			for(int j=i;j<qtde-1;j++){ //exclui deslocando os elementos da direita uma posi��o para � esquerda.
				turma[j] = turma[j+1];
			}
			qtde--; //diminui a quantidade de alunos na lista
			res = true;
		}  
		return res;
	}
	
	
	// Exclui um aluno de uma posi��o informada
	public boolean excluiPosicao(int pos) {
		boolean res = false;
		if ((pos >= 0) && (pos < qtde)) { //Testa se � uma posi��o v�lida para excluir
			//Desloca os alunos uma posi��o para a esquerda
			for (int i = pos; i < qtde - 1; i++) {
				turma[i] = turma[i + 1];
			}
			qtde--; //Diminui a quantidade de alunos
			res = true;
		}
		return res;
	}
	
}