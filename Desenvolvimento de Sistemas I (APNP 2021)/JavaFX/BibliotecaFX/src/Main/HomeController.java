package Main;

import DAO.Dao_Livro;
import Helpers.FXAssistant;
import Objects.Livro;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    Dao_Livro<Livro> dao;
    Livro livro;
    Boolean exc;

    @FXML
    private Button botaoSair;

    @FXML
    private Button botaoInfo;

    @FXML
    private Button botaoNovo;

    @FXML
    private TableView<Livro> tabelaLivros;

    @FXML
    private TableColumn<Livro, String> colunaISBN;

    @FXML
    private TableColumn<Livro, String> colunaTitulo;

    @FXML
    private TableColumn<Livro, String> colunaAutor;

    @FXML
    private TableColumn<Livro, String> colunaAno;

    @FXML
    private TableColumn<Livro, String> conulaEditora;

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
    private Text textEditora;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoExcluir;

    @FXML
    private Pane paneDados;

    public HomeController() {
        dao = new Dao_Livro<>();
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.paneDados.setVisible(false);

        initTable();
    }

    void initTable() {
        colunaISBN.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("Titulo"));
        colunaAutor.setCellValueFactory(new PropertyValueFactory<>("Autor"));
        colunaAno.setCellValueFactory(new PropertyValueFactory<>("Ano"));
        conulaEditora.setCellValueFactory(new PropertyValueFactory<>("Editora"));

        atualizaTabela();
    }

    public void atualizaTabela(){
        tabelaLivros.setItems(listaDeLivros());
        atualizaPaneInfo();
    }

    private ObservableList<Livro> listaDeLivros() {
        try {
            return FXCollections.observableArrayList(dao.pesquisaTodos());

        } catch (SQLException throwables) {
            FXAssistant.mostrarDialogo(Alert.AlertType.ERROR, "Erro!", "Ocorreu um erro ao consultar os dados!");
        }
        return FXCollections.observableArrayList();
    }

    @FXML
    void editar(ActionEvent event) {
        if (livro != null){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("formView.fxml"));
                Parent root = loader.load();

                FormController controller = loader.<FormController>getController();
                controller.setHome(this);
                controller.setLivro(livro);

                Scene scene = new Scene(root);
                Stage stage1 = new Stage();

                stage1.setTitle("Editar Livro " + livro.getTitulo());
                stage1.setScene(scene);
                stage1.show();

            } catch (IOException ex) {
                System.err.println("Erro ao abrir Janela 1");
            }
        }
    }

    @FXML
    void excluir(ActionEvent event) {
        this.confirmaExclusao();

        if(exc){
            try {
                dao.remove(livro);
            } catch (SQLException throwables) {
                FXAssistant.mostrarDialogo(
                        Alert.AlertType.ERROR,
                        "Erro na Operação!",
                        "Nao foi possível excluir."
                );
            } finally {
                this.atualizaTabela();
            }
        }

    }

    private void confirmaExclusao(){
        Alert dialogoExe = new Alert(Alert.AlertType.CONFIRMATION);

        ButtonType btnSim = new ButtonType("Sim");
        ButtonType btnNao = new ButtonType("Não");

        dialogoExe.setTitle("Exclusao");
        dialogoExe.setHeaderText("Tem certeza?");
        dialogoExe.setContentText("Você quer mesmo excluir esse livro?");
        dialogoExe.getButtonTypes().setAll(btnSim, btnNao);
        dialogoExe.showAndWait().ifPresent(b -> {
            if (b == btnSim) {
                exc = true;
            } else if (b == btnNao) {
                exc = false;
            }
        });
    }

    @FXML
    void info(ActionEvent event) {

        FXAssistant.mostrarDialogo(Alert.AlertType.INFORMATION,
                "Informações",
                "Feito por Mateus Orlandin Lorenzatti \n \n" +
                        "Professor: Rafael Vieira Coelho \n" +
                        "Instituição: IFRS Campus Farroupilha \n" +
                        "Curso: Análise e Desenvolvimento de Sistemas \n");
    }

    @FXML
    void novo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("formView.fxml"));
            Parent root = loader.load();

            FormController controller = loader.<FormController>getController();
            controller.setHome(this);

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

    @FXML
    void selecionadoLinha(MouseEvent event) {
        atualizaPaneInfo();
    }

    private void atualizaPaneInfo(){
        if (tabelaLivros.getSelectionModel().getSelectedItem() != null){
            this.livro = tabelaLivros.getSelectionModel().getSelectedItem();
            preencherDados(livro);
            this.paneDados.setVisible(true);

        }else {
            this.paneDados.setVisible(false);
        }
    }

    private void preencherDados(Livro livro) {
        textTitulo.setText(livro.getTitulo());
        textAutor.setText(livro.getAutor());
        textISBN.setText(livro.getISBN());
        textAno.setText(livro.getAno());
        textIdioma.setText(livro.getIdioma());
        textMidia.setText(livro.getMidia());
        textGenero.setText(livro.getGenero());
        textEditora.setText(livro.getEditora());
    }


}
