package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FormController {

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextField fieldISBN;

    @FXML
    private TextField fieldTitulo;

    @FXML
    private TextField fieldAutor;

    @FXML
    private TextField fieldMidia;

    @FXML
    private TextField fieldAno;

    @FXML
    private TextField fieldGenero;

    @FXML
    private TextField fieldEditora;

    @FXML
    private Button botaoSalvar;

    @FXML
    void salvar(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
        Stage stage = (Stage) botaoVoltar.getScene().getWindow();
        stage.close();
    }

}
