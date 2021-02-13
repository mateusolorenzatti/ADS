/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlesbasicos;

import java.net.URL;
import java.util.ResourceBundle;

import Log.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author coelho
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField text_field;
    @FXML
    private TextArea text_area;

    @FXML
    private void sair_button_event(ActionEvent event) {
        Logger.logar(text_area.getText());

        Platform.exit();
    }

    @FXML
    private void ok_button_event(ActionEvent event) {
        text_area.appendText(text_field.getText() + "\n");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        text_field.setOnMouseClicked((javafx.scene.input.MouseEvent event) -> {
            text_field.setText("");
        });
    }

}
