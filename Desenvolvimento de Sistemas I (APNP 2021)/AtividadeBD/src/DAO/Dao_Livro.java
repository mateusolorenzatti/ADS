package DAO;

import Database.ConnectionFactory;
import Database.SQL_Constantes;
import Objects.Aluno;
import Objects.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao_Livro<T> implements Dao<T> {

    @Override
    public void adiciona(T c) throws SQLException{
        Livro livro = (Livro) c;
        String sql = SQL_Constantes.INSERT_LIVRO;

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, livro.getMidia());
            stmt.setString(2, livro.getGenero());
            stmt.setString(3, livro.getIdioma());
            stmt.setString(4, livro.getAno());
            stmt.setString(5, livro.getAutor());
            stmt.setString(6, livro.getEditora());
            stmt.setString(7, livro.getTitulo());
            stmt.setString(8, livro.getISBN());
            stmt.execute();
        }
    }

    @Override
    public List<T> pesquisaTodos() throws SQLException{
        List<T> livros = new ArrayList();

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL_Constantes.SEARCH_LIVRO);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Livro livro = new Livro();

                livro.setMidia(rs.getString("midia"));
                livro.setGenero(rs.getString("genero"));
                livro.setIdioma(rs.getString("idioma"));
                livro.setAno(rs.getString("ano"));
                livro.setAutor(rs.getString("autor"));
                livro.setEditora(rs.getString("editora"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setISBN(rs.getString("isbn"));

                livros.add((T) livro);
            }
        }
        return livros;
    }

    @Override
    public void altera(T c) throws SQLException{
        Aluno contato = (Aluno) c;
        String sql = SQL_Constantes.UPDATE_LIVRO;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setFloat(1, contato.getNota1());
            stmt.setFloat(2, contato.getNota2());
            stmt.setFloat(3, contato.getNota3());
            stmt.setFloat(4, contato.getMedia());
            stmt.setInt(5, contato.getMatricula());
            stmt.execute();
        }
    }

    @Override
    public void remove(T c) throws SQLException{
        Aluno contato = (Aluno) c;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL_Constantes.REMOVE)){
            stmt.setInt(1, contato.getMatricula());
            stmt.execute();
        }
    }

    @Override
    public boolean pesquisa(T c) throws SQLException{
        Aluno contato = (Aluno) c;
        List<T> todos = pesquisaTodos();

        for (Object cc : todos) {
            if (((Aluno)cc).equals(contato)) {
                return true;
            }
        }
        return false;
    }

    public int buscaId(T modelo) throws SQLException{
        List<Object> contatos = new Dao_Aluno().pesquisaTodos();

        for (Object mod : contatos) {
            Aluno c = (Aluno) mod;
            if (((Aluno)modelo).getNome().equals(c.getNome()))
                return c.getMatricula();
        }
        return -1;
    }

    public int buscaId(String nome) throws SQLException{
        List<Object> contatos = new Dao_Aluno().pesquisaTodos();

        for (Object mod : contatos) {
            Aluno c = (Aluno) mod;
            if (nome.equals(c.getNome()))
                return c.getMatricula();
        }
        return -1;
    }

    public Aluno pesquisaAluno(String nome) throws SQLException{
        List<T> contatos = new Dao_Aluno().pesquisaTodos();

        for (Object mod : contatos) {
            Aluno c = (Aluno) mod;
            if (c.getNome().equals(nome))
                return c;
        }
        return null;
    }
}
