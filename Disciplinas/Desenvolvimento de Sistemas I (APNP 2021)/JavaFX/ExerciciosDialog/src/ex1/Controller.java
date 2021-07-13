package ex1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button info;

    @FXML
    private Button erro;

    @FXML
    private Button aviso;

    @FXML
    void mostrarAviso(ActionEvent event) {
        this.mostrarDialogo(Alert.AlertType.WARNING, "Aviso!", "Isso é um aviso.");
    }

    @FXML
    void mostrarErro(ActionEvent event) {
        this.mostrarDialogo(Alert.AlertType.ERROR, "Erro!", "Isso é um erro.");
    }

    @FXML
    void mostrarInfo(ActionEvent event) {
        this.mostrarDialogo(Alert.AlertType.INFORMATION, "Info!", "Isso é uma informação.");
    }

    private void mostrarDialogo(Alert.AlertType tipo, String titulo, String conteudo){
        Alert a = new Alert(tipo);

        a.setHeaderText(titulo);
        a.setContentText(conteudo);
        a.show();
    }

}
