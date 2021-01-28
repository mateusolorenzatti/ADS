package DAO;

import java.sql.SQLException;
import java.util.List;

public interface Dao<T> {

    public void adiciona(T m) throws SQLException;

    public void altera(T m) throws SQLException;

    public void remove(T m) throws SQLException;

    public boolean pesquisa(T m) throws SQLException;

    public List<T> pesquisaTodos() throws SQLException;
}
