package janelas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    @FXML
    private Button button1;
    @FXML
    private Button button2;

    @FXML
    private void handleButtonAction1(ActionEvent event) {
        //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        //stage.close();
        //ou 
        // button1.getScene().getWindow().hide();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Janela1FXML.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage1 = new Stage();
            
            stage1.setTitle("Janela Secundária");
            stage1.setScene(scene);
            stage1.show();
        } catch (IOException ex) {
            System.err.println("Erro ao abrir Janela 1");
        }
    }
    @FXML
    private void handleButtonAction2(ActionEvent event) {
        Alert dialogo = new Alert(Alert.AlertType.INFORMATION, "Janela 2 Selecionada!");
        dialogo.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
