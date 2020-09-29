public class Menu {
    Leitura leTec;
    Turma turma;

    public Menu() {
        leTec = new Leitura();
        turma = new Turma();
        menu();
    }

    private void opcoes() {
        System.out.println("");
        System.out.println("1 - Inserir Aluno no In�cio da Lista");
        System.out.println("2 - Inserir Aluno no Fim da Lista");
        System.out.println("3 - Inserir Aluno em uma Posi��o");
        System.out.println("4 - Inserir um Aluno em Ordem Alfab�tica por Nome");
        System.out.println("5 - Informa a Exist�ncia de um Aluno");
        System.out.println("6 - Retorna um Aluno de uma Posi��o Informada");
        System.out.println("7 - Excluir um Aluno de uma Posi��o Informada");
        System.out.println("8 - Excluir Aluno por Nome");
        System.out.println("9 - Exclui um Aluno do In�cio da Lista");
        System.out.println("f - Exclui um Aluno do Fim da Lista");
        System.out.println(" ------------------------------------------------  ");
        System.out.println("m - Verificar quais alunos fazem parte de uma faixa do IMC ");
        System.out.println("n - Verificar a média de alturas da turma atual ");
        System.out.println(" ------------------------------------------------  ");
        System.out.println("i - Listar os Alunos\n");
        System.out.println("0 - Sair\n");
    }


    private Aluno leDados() {
        Aluno aux_aluno = new Aluno();
        aux_aluno.setMatricula(leTec.leInt("Matr�cula do Aluno: "));
        aux_aluno.setNome(leTec.leString("Nome do Aluno: "));
        aux_aluno.setPeso(leTec.leInt("Peso do Aluno (em KG): "));
        aux_aluno.setAltura(leTec.leInt("Altura do Aluno (em Centimetros): "));
        return aux_aluno;
    }

    public void menu() {
        String aux_nome;
        int pos = 0;
        char opc;
        Aluno aluno;

        opcoes();
        opc = leTec.leChar("Digite a sua Op��o: ");
        while (opc != '0') {
            switch (opc) {
                case '1':
                    aluno = leDados();        // Leitura de Dados
                    if (turma.insereInicio(aluno)) {
                        System.out.println("Inser��o Ok!");
                    } else {
                        System.out.println("N�o foi poss�vel inserir!");
                    }
                    break;
                case '2':
                    aluno = leDados();        // Leitura de Dados
                    if (turma.insereFim(aluno)) {
                        System.out.println("Inser��o Ok!");
                    } else {
                        System.out.println("N�o foi poss�vel inserir!");
                    }
                    break;

                case '3':
                    aluno = leDados();        // Leitura de Dados
                    pos = leTec.leInt("Informe a Posi��o Para Inser��o do Aluno");
                    if (turma.inserePosicao(aluno, pos)) {
                        System.out.println("Inser��o Ok!");
                    } else {
                        System.out.println("N�o foi poss�vel inserir!");
                    }
                    break;

                case '4':
                    aluno = leDados();        // Leitura de Dados
                    if (turma.insereOrdenado(aluno)) {
                        System.out.println("Inser��o Ok!");
                    } else {
                        System.out.println("N�o foi poss�vel inserir!");
                    }

                    break;

                case '5':    // EXERC�CIO
                    aux_nome = leTec.leString("Nome do Aluno");
                    aluno = new Aluno(0, aux_nome, 0, 0);
                    if (turma.existe(aluno)) {
                        System.out.println("O aluno " + aluno.getNome() + " est� presente na lista.");
                    } else {
                        System.out.println("O aluno " + aluno.getNome() + " n�o est� presente na lista.");
                    }

                    break;

                case '6':
                    pos = leTec.leInt("Informe a Posi��o do Aluno na Lista");
                    aluno = turma.obtemAluno(pos);
                    if (aluno == null) {
                        System.out.println("Aluno n�o encontrado!");
                    } else {
                        System.out.println(aluno.toString());
                    }
                    break;

                case '7':
                    pos = leTec.leInt("Informe a Posi��o do Aluno na Lista");
                    aluno = turma.obtemAluno(pos);
                    if (aluno == null) {
                        System.out.println("Posi��o Inv�lida!");
                        System.out.println("Aluno n�o encontrado!");
                    } else {
                        if (turma.excluiPosicao(pos)) {
                            System.out.println("Exclus�o Ok!");
                        } else {
                            System.out.println("N�o foi poss�vel realizar a exclus�o!");
                        }
                    }
                    break;

                case '8':
                    aux_nome = leTec.leString("Nome do Aluno");
                    aluno = new Aluno(0, aux_nome, 0, 0);
                    if (turma.exclui(aluno)) {
                        System.out.println("Exclus�o Ok!");
                    } else {
                        System.out.println("N�o foi poss�vel realizar a exclus�o!");
                    }
                    break;
                case '9':
                    if (turma.excluiInicio()) {
                        System.out.println("Exclus�o Ok!");
                    } else {
                        System.out.println("N�o foi poss�vel realizar a exclus�o!");
                    }
                    break;
                case 'f':
                    if (turma.excluiFim()) {
                        System.out.println("Exclus�o Ok!");
                    } else {
                        System.out.println("N�o foi poss�vel realizar a exclus�o!");
                    }
                    break;
                case 'm':
                    System.out.println(" Informaçoes Válidas (Situação IMC):\n  - abaixo \n  - normal \n  - sobrepeso \n  - obesidade_I \n  - obesidade_II \n  - obesidade_III ");

                    String sit = leTec.leString("Situacao de IMC: ");

                    System.out.println(this.turma.alunosNoIMCInformado(sit));

                    break;
                case 'n':
                    System.out.println("A media de alturas da turma é: " + this.turma.mediaAlturas() + "cm");

                    break;
                case 'i':
                    if (turma.vazia()) {
                        System.out.println("N�o h� elementos na lista.");
                    } else {
                        for (int i = 0; i < turma.quantidadeAlunos(); i++) {
                            aluno = turma.obtemAluno(i);
                            System.out.println(aluno.toString());
                        }
                    }
                    break;
            }
            opcoes();
            opc = leTec.leChar("Digite a sua Op��o: ");
        }
    }
}