package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import log.Logger;

public class Controller {
    private final String AZUL = "#1d3eaa";
    private final String CINZA = "#64676d";

    @FXML
    private TextField campoNome;

    @FXML
    private Button botaoLinux;

    @FXML
    private Button botaoWindows;

    @FXML
    private Button botaoMac;

    @FXML
    private ToggleGroup lingProgPreferida;

    @FXML
    private CheckBox checkProgramaTodoDia;

    @FXML
    private CheckBox checkGostaDeProg;

    @FXML
    private Button botaoSubmit;

    private String sistemaOperacional;

    @FXML
    void escolheuLinux(ActionEvent event) {
        botaoLinux.setStyle("-fx-background-color: " + AZUL);
        botaoMac.setStyle("-fx-background-color: " + CINZA);
        botaoWindows.setStyle("-fx-background-color: " + CINZA);

        this.sistemaOperacional = "Linux";
    }

    @FXML
    void escolheuMac(ActionEvent event) {
        botaoMac.setStyle("-fx-background-color: " + AZUL);
        botaoLinux.setStyle("-fx-background-color: " + CINZA);
        botaoWindows.setStyle("-fx-background-color: " + CINZA);

        this.sistemaOperacional = "Mac";
    }

    @FXML
    void escolheuWindows(ActionEvent event) {
        botaoWindows.setStyle("-fx-background-color: " + AZUL);
        botaoMac.setStyle("-fx-background-color: " + CINZA);
        botaoLinux.setStyle("-fx-background-color: " + CINZA);

        this.sistemaOperacional = "Windows";
    }

    @FXML
    void submeterPesquisa(ActionEvent event) {
        Pesquisa pes = new Pesquisa();

        pes.setNome(this.campoNome.getText());
        pes.setSO(this.sistemaOperacional);

        RadioButton selectedRadioButton = (RadioButton) this.lingProgPreferida.getSelectedToggle();
        pes.setLinguagem(selectedRadioButton.getText());

        pes.setGostaProgramacao(this.checkGostaDeProg.isSelected() ? "Sim" : "Nao");
        pes.setProgramaTodoDia(this.checkProgramaTodoDia.isSelected() ? "Sim" : "Nao");

        System.out.println(pes);
        Logger.registrarPesquisa(pes);

        Alert a = new Alert(Alert.AlertType.INFORMATION);

        a.setHeaderText("Obrigado!");
        a.setContentText("Obrigado por responder, " + pes.getNome() + "! ");
        a.show();
    }

    @FXML
    void sair(ActionEvent event) {
        Platform.exit();
    }
}
