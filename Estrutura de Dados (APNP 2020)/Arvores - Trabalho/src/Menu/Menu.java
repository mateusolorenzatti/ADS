package Menu;

import Arvores.ArvorePessoas;
import Leitura.Leitura;
import Objetos.Pessoa;

public class Menu {
    Leitura leTec;
    ArvorePessoas ar;

    public Menu() {
        leTec = new Leitura();
        ar = new ArvorePessoas();
        menu();
    }

    private void opcoes() {
        System.out.println("");
        System.out.println(" Arvore de Amizades -----------------------------  ");
        System.out.println(" 1 - Inserir um novo membro na rede (inserir uma pessoa na árvore); ");
        System.out.println(" 2 - Estabelecer uma relação de amizade entre dois membros da rede (entre dois nodos da árvore); ");
        System.out.println(" 3 - Listar os amigos de um membro da rede; ");
        System.out.println(" 4 - Listar toda a rede – os membros da rede com os seus amigos – em ordem alfabética;  ");
        System.out.println(" 5 - Alterar o nome de um membro da rede; ");
        System.out.println(" 6 - Excluir uma relação de amizade; ");
        System.out.println(" 7 - Excluir um membro da rede; \n");

        System.out.println(" Verificação -----------------------------  ");
        System.out.println(" 8 - Visualizar Arvore; \n");

        System.out.println(" Sistema ----------------------------------------  ");
        System.out.println(" 0 - Sair\n");
    }

    private Pessoa leDadosPessoa() {
        Pessoa aux_pes = new Pessoa();
        aux_pes.setNome(leTec.leString("Nome da pessoa: "));
        return aux_pes;
    }

    public void menu() {
        String aux_nome;
        int pos = 0;
        char opc;
        Pessoa pessoa_aux = null;
        Pessoa pessoa_aux2 = null;

        opcoes();
        opc = leTec.leChar("Digite a sua Opção: ");
        while (opc != '0') {
            switch (opc) {
                case '1':
                    Pessoa p = leDadosPessoa();
                    ar.insNodo(p);
                    System.out.println("Inserido com sucesso!");
                    break;

                case '2':
                    System.out.println(" Preencha os dados dos envolvidos: ");
                    Pessoa p1 = leDadosPessoa();
                    Pessoa p2 = leDadosPessoa();

                    if (ar.inserirAmizade(p1, p2)) {
                        System.out.println(" Amizade entre " + p1.getNome() + " e " + p2.getNome() + " registrada com sucesso! ");
                    } else {
                        System.out.println(" Ocorreu um erro ao inserir. Confira se ambas as pessoas exitem. ");
                    }
                    break;

                case '3':
                    pessoa_aux = leDadosPessoa();

                    System.out.println(ar.dadosIndividual(pessoa_aux));

                    break;

                case '4':
                    ar.relatorioGeralAmizades();
                    break;

                case '5':
                    System.out.println(" Preencha o nome atual, e após o novo nome: ");
                    String nomeAntigo = leTec.leString(" Nome atual: ");
                    String nomeNovo = leTec.leString(" Novo nome: ");

                    if(ar.renomearPessoa(nomeAntigo, nomeNovo)){
                        System.out.println(" Renomeado a pessoa " + nomeAntigo + " para " + nomeNovo);
                    }else{
                        System.out.println(" Ocorreu um erro. Revise os nomes inseridos.");
                    }

                    break;
//
//                case '6':
//                    aluno = leDadosAlu();
//
//                    System.out.println(uni.dadosDisciplinaPorAluno(aluno));
//                    break;
//
                case '7':
                    pessoa_aux = leDadosPessoa();

                    if(ar.removeSeguramente(pessoa_aux)){
                        System.out.println(" Removido " + pessoa_aux.getNome() + " com sucesso!");
                    }else{
                        System.out.println(" Ocorreu um erro. Revise o nome inserido.");
                    }

                    break;

                case '8':
                    System.out.print("\n Pre-Fixado: [ ");
                    ar.preFixado( );

                    System.out.print("]\n Central: [ ");
                    ar.central( );

                    System.out.print("]\n Pos-Fixado: [ ");
                    ar.posFixado( );
                    System.out.println("]\n");
                    break;
            }

            opcoes();
            opc = leTec.leChar("Digite a sua Opção: ");
        }
    }
}