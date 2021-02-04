package Main;

import DAO.Dao_Livro;
import Leitura.Leitura;
import Log.Logger;
import Objects.Livro;

import java.sql.SQLException;
import java.util.List;

public class GerenciarLivros {

    private static final char OP_SAIR = '0';
    private static final char OP_ADICIONAR = '1';
    private static final char OP_CONSULTAR = '2';
    private static final char OP_ALTERAR = '3';
    private static final char OP_EXCLUIR = '4';

    public static void main(String[] args) {
        GerenciarLivros ta = new GerenciarLivros();
        Dao_Livro<Livro> dao = new Dao_Livro<>();

        char op = ta.menu();

        while (op != OP_SAIR) {
            System.out.println("\n");

            switch (op) {
                case OP_ADICIONAR:

                    try {
                        dao.adiciona(ta.lerLivro());
                    }catch (SQLException sql) {
                        Logger.logar(" Erro ao inserir os dados!", sql);

                        System.out.println(" Erro ao inserir os dados!");
                    }

                    break;
                case OP_CONSULTAR:

                    try {
                        List<Livro> livros = dao.pesquisaTodos();

                        livros.forEach(livro -> {
                            System.out.println(livro);
                            System.out.println(" ------------------------------------------------- ");
                        });

                        if(livros.isEmpty()){
                            System.out.println("\n Nada cadastrado no banco! \n");
                        }

                    }catch (SQLException sql) {
                        Logger.logar(" Erro ao resgatar os dados!", sql);

                        System.out.println(" Erro ao resgatar os dados!");
                    }

                    break;

                case OP_ALTERAR:

                    try {
                        dao.altera(ta.lerLivro());
                    }catch (SQLException sql) {
                        Logger.logar(" Erro ao alterar os dados!", sql);

                        System.out.println(" Erro ao alterar os dados!");
                    }

                    break;

                case OP_EXCLUIR:

                    try {
                        dao.remove(ta.lerISBN());

                    }catch (SQLException sql) {
                        Logger.logar(" Erro ao excluir os dados!", sql);

                        System.out.println(" Erro ao excluir os dados!");
                    }

                    break;

                default:
                    System.out.println(" Opção Inválida! ");
                    break;
            }

            System.out.println("\n");
            op = ta.menu();
        }

        System.out.println(" Saindo... ");
    }

    public Livro lerLivro() {
        Leitura letec = new Leitura();
        Livro livro = new Livro();

        livro.setISBN(letec.leString(" Insira o ISBN: "));
        livro.setTitulo(letec.leString(" Insira o nome da Obra: "));
        livro.setAutor(letec.leString(" Insira o nome do Autor: "));
        livro.setGenero(letec.leString(" Insira o Gênero: "));
        livro.setMidia(letec.leString(" Insira a Midia: "));
        livro.setIdioma(letec.leString(" Insira o Idioma: "));
        livro.setAno(letec.leString(" Insira o Ano: "));
        livro.setEditora(letec.leString(" Insira a Editora: "));

        return livro;
    }

    public Livro lerISBN() {
        Leitura letec = new Leitura();
        Livro livro = new Livro();

        livro.setISBN(letec.leString(" Insira o ISBN: "));

        return livro;
    }

    public char menu() {
        Leitura letec = new Leitura();

        System.out.println(" Digite: ");
        System.out.println(" " + OP_ADICIONAR + " - Adicionar Obra; ");
        System.out.println(" " + OP_CONSULTAR + " - Ver todas as obras; ");
        System.out.println(" " + OP_ALTERAR + " - Alterar uma obra; ");
        System.out.println(" " + OP_EXCLUIR + " - Excluir uma obra; ");
        System.out.println(" " + OP_SAIR + " - Sair \n");

        return letec.leChar(" Sua Opção: ");
    }
}
