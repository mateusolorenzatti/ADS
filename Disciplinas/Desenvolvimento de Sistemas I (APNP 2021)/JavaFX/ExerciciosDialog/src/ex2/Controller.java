package ex2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    private String nome;
    private String regiao;
    private String exercicio;

    @FXML
    private Button botaoNome;

    @FXML
    private Button botaoRegiao;

    @FXML
    private Button botaoExercicio;

    @FXML
    private Button botaoResultados;

    @FXML
    void entradaExercicio(ActionEvent event) {
        Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);
        ButtonType btnSim = new ButtonType("Sim");
        ButtonType btnNao = new ButtonType("Não");
        ButtonType btnAsVezes = new ButtonType("As vezes");
        ButtonType btnNaoResponder = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);

        dialogoExe.setTitle("Pergunta sobre exercício");
        dialogoExe.setHeaderText("Informe se você faz exercício");
        dialogoExe.setContentText("Você faz exercício?");
        dialogoExe.getButtonTypes().setAll(btnSim, btnNao, btnAsVezes, btnNaoResponder);
        dialogoExe.showAndWait().ifPresent(b -> {
            if (b == btnSim) {
                exercicio = "Sim";
            } else if (b == btnNao) {
                exercicio = "Não";
            } else if (b == btnAsVezes) {
                exercicio = "As vezes";
            } else {
                exercicio = "Não respondeu";
            }
        });
    }

    @FXML
    void entradaNome(ActionEvent event) {
        TextInputDialog dialogoNome = new TextInputDialog();

        dialogoNome.setTitle("Entrada de nome");
        dialogoNome.setHeaderText("Entre com seu nome");
        dialogoNome.setContentText("Nome:");
        dialogoNome.showAndWait().ifPresent(v -> nome = v);
    }

    @FXML
    void entradaRegiao(ActionEvent event) {

        ChoiceDialog dialogoRegiao = new ChoiceDialog("Serra", "Campanha", "Missões", "Litoral Sul", "POA", "Litoral Norte");

        dialogoRegiao.setTitle("Entrada de Região");
        dialogoRegiao.setHeaderText("Informe sua região abaixo");
        dialogoRegiao.setContentText("Região:");
        dialogoRegiao.showAndWait().ifPresent(r -> regiao = r.toString());
    }

    @FXML
    void exibirResultados(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);

        a.setTitle("Resultados");
        a.setHeaderText("Resultados");
        a.setContentText(" Nome: " + nome + " \n Região: " + regiao + "\n Faz exercício? " + exercicio);
        a.show();
    }

}
