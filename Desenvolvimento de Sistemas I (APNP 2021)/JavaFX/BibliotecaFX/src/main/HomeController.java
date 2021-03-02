package main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button botaoSair;

    @FXML
    private Button botaoInfo;

    @FXML
    private Button botaoNovo;

    @FXML
    private TableView<?> tabelaLivros;

    @FXML
    private TableColumn<?, ?> colunaISBN;

    @FXML
    private TableColumn<?, ?> colunaTitulo;

    @FXML
    private TableColumn<?, ?> colunaAutor;

    @FXML
    private TableColumn<?, ?> colunaAno;

    @FXML
    private TableColumn<?, ?> conulaEditora;

    @FXML
    private Text textTitulo;

    @FXML
    private Text textAutor;

    @FXML
    private Text textISBN;

    @FXML
    private Text textAno;

    @FXML
    private Text textIdioma;

    @FXML
    private Text textMidia;

    @FXML
    private Text textGenero;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoExcluir;

    @FXML
    private Pane paneDados;

    @FXML
    void initialize() {
        this.paneDados.setVisible(false);
    }

    @FXML
    void editar(ActionEvent event) {

    }

    @FXML
    void excluir(ActionEvent event) {

    }

    @FXML
    void info(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);

        a.setHeaderText("Informações");
        a.setContentText(
                "Feito por Mateus Orlandin Lorenzatti \n \n" +
                "Professor: Rafael Vieira Coelho \n" +
                "Instituição: IFRS Campus Farroupilha \n" +
                "Curso: Análise e Desenvolvimento de Sistemas \n");
        a.show();
    }

    @FXML
    void novo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("formView.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage1 = new Stage();

            stage1.setTitle("Novo Livro");
            stage1.setScene(scene);
            stage1.show();

        } catch (IOException ex) {
            System.err.println("Erro ao abrir Janela 1");
        }
    }

    @FXML
    void sair(ActionEvent event) {
        Platform.exit();
    }

}
