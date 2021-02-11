package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private RadioButton radio1, radio2, radio3;
    private List<RadioButton> opcoes;
    private ToggleGroup group;
    @FXML
    private ChoiceBox<String> choicebox;
    private ObservableList<String> escolhas;
    @FXML
    private TextArea texto;

    @FXML
    public void initialize() {
        opcoes = new ArrayList();
        opcoes.add(radio1);
        opcoes.add(radio2);
        opcoes.add(radio3);
        group = new ToggleGroup();
        radio1.setToggleGroup(group);
        radio1.setSelected(true);
        radio2.setToggleGroup(group);
        radio3.setToggleGroup(group);
        group.selectedToggleProperty().addListener((ov, oldValue, newValue) -> {
            String radioButtonText = ((RadioButton) group.getSelectedToggle()).getText();
            texto.appendText(radioButtonText + " foi selecionada. \n");
        });
        escolhas = FXCollections.observableArrayList();
        escolhas.add("Escolha 1");
        escolhas.add("Escolha 2");
        escolhas.add("Escolha 3");
        choicebox.setItems(escolhas);
        choicebox.getSelectionModel().select(0);
    }

    @FXML
    private void ok(ActionEvent e) {
        texto.appendText(choicebox.getSelectionModel().getSelectedItem() + "\n");
        for (RadioButton radio : opcoes) {
            if (radio.isSelected()) {
                texto.appendText(radio.getText() + "\n");
                break;
            }
        }
    }

    @FXML
    public void fechar(ActionEvent event) {
        Stage stage = (Stage) texto.getScene().getWindow();
        stage.close();
    }
}
