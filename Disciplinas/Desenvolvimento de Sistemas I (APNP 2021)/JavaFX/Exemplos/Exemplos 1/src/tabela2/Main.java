package tabela2;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("FXMLDocument.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Scene scene = new Scene(page);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Table Cell Rendering");
            primaryStage.show();
        } catch (IOException e) {
            System.err.println("Erro ao abrir a janela");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
