package DAO;

import Database.ConnectionFactory;
import Database.SQL_Constantes;
import Helpers.FXAssistant;
import Objects.Livro;
import javafx.scene.control.Alert;

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
        }catch (Exception ne){
            FXAssistant.mostrarDialogo(Alert.AlertType.ERROR, "Erro ao conectar no banco!", "Verifique a conexão");
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
        }catch (Exception ne){
            FXAssistant.mostrarDialogo(Alert.AlertType.ERROR, "Erro ao conectar no banco!", "Verifique a conexão");
        }

        return livros;
    }

    @Override
    public void altera(T c) throws SQLException{
        Livro livro = (Livro) c;

        String sql = SQL_Constantes.UPDATE_LIVRO;

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, livro.getMidia());
            stmt.setString(2, livro.getGenero());
            stmt.setString(3, livro.getIdioma());
            stmt.setString(4, livro.getAno());
            stmt.setString(5, livro.getAutor());
            stmt.setString(6, livro.getEditora());
            stmt.setString(7, livro.getTitulo());

            stmt.setString(8, livro.getISBN());

            stmt.execute();
        }catch (Exception ne){
            FXAssistant.mostrarDialogo(Alert.AlertType.ERROR, "Erro ao conectar no banco!", "Verifique a conexão");
        }
    }

    @Override
    public void remove(T c) throws SQLException{
        Livro livro = (Livro) c;

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement stmt = connection.prepareStatement(SQL_Constantes.REMOVE_LIVRO)){

            stmt.setString(1, livro.getISBN());

            stmt.execute();
        }catch (Exception ne){
            FXAssistant.mostrarDialogo(Alert.AlertType.ERROR, "Erro ao conectar no banco!", "Verifique a conexão");
        }
    }

    @Override
    public boolean pesquisa(T c) throws SQLException{
        Livro livro = (Livro) c;
        List<T> todos = pesquisaTodos();

        for (Object cc : todos) {
            if (((Livro)cc).equals(livro)) {
                return true;
            }
        }
        return false;
    }

    public String buscaId(T modelo) throws SQLException{
        List<Object> livros = new Dao_Livro().pesquisaTodos();

        for (Object mod : livros) {
            Livro l = (Livro) mod;

            if (((Livro)modelo).getISBN().equals(l.getISBN()))
                return l.getISBN();
        }
        return "";
    }

    public String buscaId(String nome) throws SQLException{
        List<Object> contatos = new Dao_Livro().pesquisaTodos();

        for (Object mod : contatos) {
            Livro l = (Livro) mod;

            if (nome.equals(l.getTitulo()))
                return l.getISBN();
        }
        return "";
    }

    public Livro pesquisaLivro(String nome) throws SQLException{
        List<T> contatos = new Dao_Livro().pesquisaTodos();

        for (Object mod : contatos) {
            Livro c = (Livro) mod;
            if (c.getTitulo().equals(nome))
                return c;
        }
        return null;
    }
}
