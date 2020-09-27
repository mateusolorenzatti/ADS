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
        System.out.println("1 - Inserir Aluno no Fim da Lista");
        System.out.println("2 - Inserir Aluno em uma Posi��o");
        System.out.println("3 - Retorna um Aluno de uma Posi��o Informada");
        System.out.println("4 - Excluir um Aluno de uma Posi��o Informada");
        System.out.println("5 - Excluir Aluno por Nome");
        System.out.println("6 - Incluir Aluno no Início");
        System.out.println("7 - Incluir aluno Ordenadamente");
        System.out.println("8 - Verificar se um aluno Existe");
        System.out.println("9 - Listar os Alunos");
        System.out.println("A - Excluir aluno do Início");
        System.out.println("B - Excluir aluno do Fim");
        System.out.println("C - Excluir aluno se Existir\n");
        System.out.println("0 - Sair\n");
    }


    private Aluno leDados() {
        Aluno aux_aluno = new Aluno();
        aux_aluno.setMatricula(leTec.leInt("Matr�cula do Aluno: "));
        aux_aluno.setNome(leTec.leString("Nome do Aluno: "));
        aux_aluno.setPeso(leTec.leInt("Peso do Aluno: "));
        aux_aluno.setAltura(leTec.leInt("Altura do Aluno: "));
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
                    if (turma.insereFim(aluno)) {
                        System.out.println("Inser��o Ok!");
                    } else {
                        System.out.println("N�o foi poss�vel inserir!");
                    }
                    break;

                case '2':
                    aluno = leDados();        // Leitura de Dados
                    pos = leTec.leInt("Informe a Posi��o Para Inser��o do Aluno");
                    if (turma.inserePosicao(aluno, pos)) {
                        System.out.println("Inser��o Ok!");
                    } else {
                        System.out.println("N�o foi poss�vel inserir!");
                    }
                    break;

                case '3':
                    pos = leTec.leInt("Informe a Posi��o do Aluno na Lista");
                    aluno = turma.obtemAluno(pos);
                    if (aluno == null) {
                        System.out.println("Aluno n�o encontrado!");
                    } else {
                        System.out.println(aluno.toString());
                    }
                    break;

                case '4':
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

                case '5':
                    aux_nome = leTec.leString("Nome do Aluno");
                    aluno = new Aluno(0, aux_nome, 0, 0);
                    if (turma.exclui(aluno)) {
                        System.out.println("Exclus�o Ok!");
                    } else {
                        System.out.println("N�o foi poss�vel realizar a exclus�o!");
                    }
                    break;

                case '6':
                    aluno = leDados();        // Leitura de Dados
                    if (turma.insereInicio(aluno)) {
                        System.out.println("Inser��o Ok!");
                    } else {
                        System.out.println("N�o foi poss�vel inserir!");
                    }
                    break;

                case '7':
                    aluno = leDados();        // Leitura de Dados
                    if (turma.insereOrdenado(aluno)) {
                        System.out.println("Inser��o Ok!");
                    } else {
                        System.out.println("N�o foi poss�vel inserir!");
                    }
                    break;

                case '8':
                    aux_nome = leTec.leString("Nome do Aluno");
                    aluno = new Aluno(0, aux_nome, 0, 0);

                    if (turma.existe(aluno)) {
                        System.out.println("Aluno existe!");
                    } else {
                        System.out.println("Aluno não existe!");
                    }
                    break;

                case '9':
                    if (turma.vazia()) {
                        System.out.println("N�o h� elementos na lista.");
                    } else {
                        for (int i = 0; i < turma.quantidadeAlunos(); i++) {
                            aluno = turma.obtemAluno(i);
                            System.out.println(aluno.toString());
                        }
                    }
                    break;

                case 'A':
                    if (turma.excluiInicio(new Aluno())) {
                        System.out.println("Exclus�o Ok!");
                    } else {
                        System.out.println("N�o foi poss�vel realizar a exclus�o!");
                    }
                    break;

                case 'B':
                    if (turma.excluiFim(new Aluno())) {
                        System.out.println("Exclus�o Ok!");
                    } else {
                        System.out.println("N�o foi poss�vel realizar a exclus�o!");
                    }
                    break;

                case 'C':
                    aux_nome = leTec.leString("Nome do Aluno");
                    aluno = new Aluno(0, aux_nome, 0, 0);

                    if (turma.excluiAluno(aluno)) {
                        System.out.println("Exclus�o Ok!");
                    } else {
                        System.out.println("Aluno Inexistente!");
                    }
                    break;
            }
            opcoes();
            opc = leTec.leChar("Digite a sua Op��o: ");
        }
    }
}