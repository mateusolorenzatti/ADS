package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/ADS",
                            "aula", "aula");

            System.out.println("Conectado!");
            return con;

        } catch (SQLException e) {
            System.out.println("Erro ao conectar no banco de dados!");
            e.printStackTrace();
        }catch (ClassNotFoundException cnf) {
            System.out.println("Erro ao conectar no banco de dados!");
            cnf.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
