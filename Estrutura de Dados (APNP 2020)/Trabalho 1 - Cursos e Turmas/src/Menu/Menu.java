package Menu;

import Leitura.Leitura;
import Objetos.Aluno;
import Objetos.Disciplina;
import Objetos.Universidade;

public class Menu {
    Leitura leTec;
    Universidade uni;

    public Menu() {
        leTec = new Leitura();
        uni = new Universidade();
        menu();
    }

    private void opcoes() {
        System.out.println("");
        System.out.println(" Cadastro ---------------------------------------  ");
        System.out.println(" 1 - Cadastrar uma Disciplina; ");
        System.out.println(" 2 - Matricular um aluno em uma Disciplina; ");
        System.out.println(" 3 - Inserir uma nota para um aluno em uma Disciplina; \n");

        System.out.println(" Consultas --------------------------------------  ");
        System.out.println(" 4 - Listar Disciplinas e a quantidade de Alunos nelas;  ");
        System.out.println(" 5 - Relatório de Alunos por Disciplina com média de notas; ");
        System.out.println(" 6 - Relatório de Disiplinas por Aluno com a média de notas; \n");

        System.out.println(" Exclusão ---------------------------------------  ");
        System.out.println(" 7 - Excluir uma Disciplina (Precisa estar sem alunos); ");
        System.out.println(" 8 - Excluir um aluno matriculado em uma disciplina; ");
        System.out.println(" 9 - Excluir um aluno de todas das disciplinas; \n");

        System.out.println(" Sistema ----------------------------------------  ");
        System.out.println(" 0 - Sair\n");
    }


    private Aluno leDadosAlu() {
        Aluno aux_aluno = new Aluno();
        aux_aluno.setNome(leTec.leString("Nome do Aluno: "));
        return aux_aluno;
    }

    private Disciplina leDadosDis() {
        Disciplina aux_dis = new Disciplina();
        aux_dis.setNome(leTec.leString("Título da Disciplina: "));
        return aux_dis;
    }

    public void menu() {
        String aux_nome;
        int pos = 0;
        char opc;
        Aluno aluno;
        Disciplina disciplina;

        opcoes();
        opc = leTec.leChar("Digite a sua Opção: ");
        while (opc != '0') {
            switch (opc) {
                case '1':
                    disciplina = leDadosDis();

                    if (uni.insereFim(disciplina)) {
                        System.out.println("Inserido com sucesso!");
                    } else {
                        System.out.println("Não foi possível inserir!");
                    }
                    break;

                case '2':
                    aluno = leDadosAlu();
                    disciplina = leDadosDis();

                    if (uni.inserirAlunoEmDisciplina(aluno, disciplina)) {
                        System.out.println("Aluno inserido em " + disciplina.getNome() + " !");
                    } else {
                        System.out.println("Ocorreu um erro ao inserir. Confira se a disciplina existe ou se o aluno já está nela. ");
                    }
                    break;

                case '3':
                    aluno = leDadosAlu();
                    disciplina = leDadosDis();
                    Double nota = leTec.leDouble(" Insira a nota do aluno: ");

                    if (uni.inserirNotaAluno(aluno, disciplina, nota)) {
                        System.out.println("Nota atribuída com sucesso! ");
                    } else {
                        System.out.println("Ocorreu um erro ao inserir. Confira se a disciplina existe ou se o aluno já está nela. ");
                    }
                    break;

                case '4':
                    System.out.println(uni.relatorioDisciplinas());
                    break;

                case '5':
                    disciplina = leDadosDis();

                    System.out.println(uni.dadosAlunosPorDisciplina(disciplina));
                    break;

                case '6':
                    aluno = leDadosAlu();

                    System.out.println(uni.dadosDisciplinaPorAluno(aluno));
                    break;

                case '7':
                    disciplina = leDadosDis();

                    if (uni.removeDisciplina(disciplina)) {
                        System.out.println("Removido com sucesso!");
                    } else {
                        System.out.println("Ocorreu um erro ao excluir. Confira se a disciplina existe ou se está vazia.");
                    }
                    break;

                case '8':
                    aluno = leDadosAlu();
                    disciplina = leDadosDis();

                    if (uni.removerAlunoDaDisciplina(aluno, disciplina)) {
                        System.out.println("Aluno removido de " + disciplina.getNome() + " !");
                    } else {
                        System.out.println("Ocorreu um erro ao remover. Confira se a disciplina existe ou se o aluno está nela. ");
                    }
                    break;

                case '9':
                    aluno = leDadosAlu();

                    if (uni.removerAlunoDasDisciplinas(aluno)) {
                        System.out.println("Aluno removido de todas as disciplinas!");
                    } else {
                        System.out.println("Ocorreu um erro ao remover. Confira se o aluno foi cadastrado em alguma. ");
                    }
                    break;

            }
            opcoes();
            opc = leTec.leChar("Digite a sua Opção: ");
        }
    }
}