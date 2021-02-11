package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private Text meu_texto;
    @FXML
    private Button meu_botao;

    @FXML
    private void quando_clicado(ActionEvent evento) {
        meu_texto.setText("Até logo, boa noite...");
    }
}
