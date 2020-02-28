package ultimatemastermind2019;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;

public class JogoViewController {

    @FXML
    private TextField campoEntrada;

    @FXML
    private Button botaoTenteSorte;

    @FXML
    private Button botaoRankings;

    @FXML
    private Button botaoNovoJogo;

    @FXML
    private Button botaoSair;

    @FXML
    private Label colunaJogadas;

    @FXML
    private Label colunaPosicoes;

    @FXML
    private Label colunaCaracteres;

    private String senha;
    private int jogador;
    private CadJogadores cad;
    private ArrayList<Jogada> jogadas;

    @FXML
    void initialize() {
        this.jogadas = new ArrayList();
        this.cad = new CadJogadores();

        this.iniciarPartida();
    }

    @FXML
    void abrirRankings(ActionEvent event) throws IOException {
        Stage stage2 = (Stage) this.botaoNovoJogo.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RankingView.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        RankingViewController controller = fxmlLoader.<RankingViewController>getController();
        controller.setJogador(jogador);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void criarNovoJogo(ActionEvent event) {
        this.iniciarPartida();
    }

    @FXML
    void lancarJogada(ActionEvent event) {
        String entrada = this.campoEntrada.getText();
        int caracteres = 0, posicoes = 0;

        for (int i = 0; i < 4; i++) {
            if (entrada.contains("" + senha.charAt(i))) {
                caracteres++;
            }
            if (entrada.charAt(i) == this.senha.charAt(i)) {
                posicoes++;
            }
        }

        this.jogadas.add(new Jogada(entrada, posicoes, caracteres));

        this.atualizaJogadas();

        if ((entrada.equals(this.senha)) || (this.jogadas.size() > 10)) {
            this.finalizarPartida(entrada.equals(this.senha));
        }
    }

    @FXML
    void sair(ActionEvent event) throws IOException {
        Stage stage2 = (Stage) this.botaoNovoJogo.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginView.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    void setJogador(int jogador) {
        this.jogador = jogador;
    }

    void iniciarPartida() {
        senha = "";

        this.jogadas.clear();

        this.campoEntrada.setText("");

        this.colunaJogadas.setText("");
        this.colunaCaracteres.setText("");
        this.colunaPosicoes.setText("");

        this.gerarSenha();

        System.out.println(this.senha);
    }

    void finalizarPartida(boolean venceu) {
        int pontuacao = 10 - (this.jogadas.size() - 1);

        this.cad.getElemento(jogador).getPontuacao().setAcumulado(this.cad.getElemento(jogador).getPontuacao().getAcumulado() + pontuacao);
        this.cad.getElemento(jogador).getPontuacao().setPartidas(this.cad.getElemento(jogador).getPontuacao().getPartidas() + 1);
        this.cad.getElemento(jogador).getPontuacao().setUltPartida(pontuacao);
        
        this.cad.gravarObjeto();

        if (venceu) {
            Alert dialogo = new Alert(Alert.AlertType.INFORMATION, "Você acertou! Sua pontuacao: " + pontuacao + ". Confira o ranking para mais informações! ");
            dialogo.showAndWait();
        } else {
            Alert dialogo = new Alert(Alert.AlertType.INFORMATION, "Se esgoratam as tentativas e você não pontuou dessa vez... Tente novamente!");
            dialogo.showAndWait();
        }

        this.iniciarPartida();
    }

    private void gerarSenha() {
        String[] lista = {"A", "B", "C", "D", "E", "F", "G", "H"};
        String[] senhaGerada = {"", "", "", ""};
        Random r = new Random();
        boolean repeticao = true;

        for (int i = 0; i < senhaGerada.length; i++) {
            while (repeticao) {
                String letra = lista[r.nextInt(lista.length)];
                boolean repetido = false;

                for (int j = 0; j < senhaGerada.length; j++) {
                    if (senhaGerada[j].equals(letra)) {
                        repetido = true;
                    }
                }

                if (!repetido) {
                    senhaGerada[i] = letra;
                    break;
                }
            }
        }

        for (int i = 0; i < senhaGerada.length; i++) {
            this.senha += senhaGerada[i];
        }
    }

    private void atualizaJogadas() {
        Jogada jos = this.jogadas.get(this.jogadas.size() - 1);

        this.colunaJogadas.setText(this.colunaJogadas.getText() + "\n" + jos.getSenha());
        this.colunaPosicoes.setText(this.colunaPosicoes.getText() + "\n" + jos.getPosicoes());
        this.colunaCaracteres.setText(this.colunaCaracteres.getText() + "\n" + jos.getCaracteres());
    }

}
