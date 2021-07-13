package tabela1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FXMLTableView extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("FXML TableView Example");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml_tableview.fxml"));
        Pane myPane = (Pane)loader.load();
        Scene myScene = new Scene(myPane);
        FXMLTableViewController controller = loader.getController();
        
        controller.setStage(primaryStage);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
