package Database;

import Helpers.FXAssistant;
import Log.Logger;
import javafx.scene.control.Alert;

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
                            "aula", "aula1");

            //System.out.println("Conectado!");
            return con;

        } catch (SQLException e) {
            Logger.logar("Erro ao conectar no banco de dados!", e);

            System.out.println("Erro ao conectar no banco de dados!");

        }catch (ClassNotFoundException cnf) {
            Logger.logar("Erro ao conectar no banco de dados!", cnf);
        }

        return null;
    }

    public static void main(String[] args) {
        getConnection();

        Logger.logar("Sucesso!");
    }
}
