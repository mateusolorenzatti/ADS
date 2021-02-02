package Teste;

import DAO.Dao_Livro;
import Leitura.Leitura;
import Objects.Livro;

import java.sql.SQLException;
import java.util.ArrayList;

public class TesteLivro {

    public static void main(String[] args) {
        TesteLivro ta = new TesteLivro();
        Dao_Livro<Livro> dao = new Dao_Livro<>();

        char op = ta.menu();

        while (op != '0') {

            switch (op) {
                case '1':

                    try {
                        dao.adiciona(ta.lerLivro());
                    }catch (SQLException sql) {
                        System.out.println(" Erro ao inserir os dados!");
                        sql.printStackTrace();
                    }

                    break;
                case '2':

                    try {
                        dao.pesquisaTodos().forEach( livro -> {
                            System.out.println(livro);
                            System.out.println(" ------------------------------------------------- ");
                        });

                    }catch (SQLException sql) {
                        System.out.println(" Erro ao resgatar os dados!");
                    }

                    break;
                default:
                    System.out.println(" Opção Inválida! ");
                    break;
            }

            op = ta.menu();
        }

        System.out.println(" Saindo... ");
    }

    public Livro lerLivro() {
        Leitura letec = new Leitura();

        String ISBN = letec.leString(" Insira o ISBN: ");
        String titulo = letec.leString(" Insira o nome da Obra: ");
        String autor = letec.leString(" Insira o nome do Autor: ");
        String genero = letec.leString(" Insira o Gênero: ");
        String midia = letec.leString(" Insira a Midia: ");
        String idioma = letec.leString(" Insira o Ano: ");
        String ano = letec.leString(" Insira o Idioma: ");
        String editora = letec.leString(" Insira a Editora: ");

        return new Livro(ISBN, titulo, midia, genero, idioma, ano, autor, editora);
    }

    public char menu() {
        Leitura letec = new Leitura();

        System.out.println(" Digite: ");
        System.out.println(" 1 - Adicionar Obra; ");
        System.out.println(" 2 - Ver todas as obras; ");
        System.out.println(" 0 - Sair \n");

        return letec.leChar(" Sua Opção: ");
    }
}
