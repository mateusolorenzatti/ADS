package ultimatemastermind2019;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.CadJogadores;
import model.Jogador;

public class RankingViewController {

    @FXML
    private Button botaoVoltar;

    @FXML
    private Label colunaAcumulado;

    @FXML
    private Label colunaPartidas;

    @FXML
    private Label colunaUltima;

    @FXML
    private Label colunaJogador;

    private int jogador;
    private CadJogadores lista;

    @FXML
    void initialize() {
        this.lista = new CadJogadores();

        this.lista.ordenar();
        
        this.colunaJogador.setText("");
        this.colunaAcumulado.setText("");
        this.colunaPartidas.setText("");
        this.colunaUltima.setText("");
        
        this.lista.imprimeValores();

        this.atualizaDadosTabela();
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        Stage stage2 = (Stage) this.botaoVoltar.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("JogoView.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        JogoViewController controller = fxmlLoader.<JogoViewController>getController();
        controller.setJogador(jogador);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    void setJogador(int jog) {
        this.jogador = jog;
    }

    private void atualizaDadosTabela() {
        for (int i = 0; i < this.lista.getTam(); i++) {
            this.colunaJogador.setText(this.colunaJogador.getText() + "\n" + this.lista.getElemento(i).getUsuario());
            this.colunaAcumulado.setText(this.colunaAcumulado.getText() + "\n" + this.lista.getElemento(i).getPontuacao().getAcumulado());
            this.colunaPartidas.setText(this.colunaPartidas.getText() + "\n" + this.lista.getElemento(i).getPontuacao().getPartidas());
            this.colunaUltima.setText(this.colunaUltima.getText() + "\n" + this.lista.getElemento(i).getPontuacao().getUltPartida());
        }

    }
}
