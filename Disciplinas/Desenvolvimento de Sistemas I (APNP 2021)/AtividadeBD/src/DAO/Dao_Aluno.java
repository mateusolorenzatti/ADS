package DAO;

import Database.ConnectionFactory;
import Database.SQL_Constantes;
import Objects.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao_Aluno<T> implements Dao<T> {

    @Override
    public void adiciona(T c) throws SQLException{
        Aluno contato = (Aluno) c;
        String sql = SQL_Constantes.INSERT;

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1, null);
            stmt.setString(2, contato.getNome());
            stmt.setFloat(3, contato.getNota1());
            stmt.setFloat(4, contato.getNota2());
            stmt.setFloat(5, contato.getNota3());
            stmt.setFloat(6, contato.getMedia());
            stmt.execute();
        }
    }

    @Override
    public List<T> pesquisaTodos() throws SQLException{
        List<T> contatos = new ArrayList();
        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement stmt = connection.prepareStatement(SQL_Constantes.SEARCH);
            ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Aluno contato = new Aluno();
                contato.setMatricula(rs.getInt("matricula"));
                contato.setNome(rs.getString("nome"));
                contato.setNota1(rs.getFloat("nota1"));
                contato.setNota2(rs.getFloat("nota2"));
                contato.setNota3(rs.getFloat("nota3"));
                contato.setMedia(rs.getFloat("media"));
                contatos.add((T)contato);
            }
        }
        return contatos;
    }

    @Override
    public void altera(T c) throws SQLException{
        Aluno contato = (Aluno) c;
        String sql = SQL_Constantes.UPDATE;
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
