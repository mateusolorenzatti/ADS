package Main;

import DAO.Dao_Livro;
import Helpers.FXAssistant;
import Objects.Livro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class FormController {

    Boolean novoLivro = true;
    Dao_Livro<Livro> dao;
    Livro livro;

    HomeController meuHome;

    public void setLivro(Livro livro){
        novoLivro = false;

        this.livro = livro;

        this.fieldISBN.setDisable(true);
        this.fieldISBN.setText(livro.getISBN());
        this.fieldTitulo.setText(livro.getTitulo());
        this.fieldAutor.setText(livro.getAutor());
        this.fieldMidia.setText(livro.getMidia());
        this.fieldAno.setText(livro.getAno());
        this.fieldIdioma.setText(livro.getIdioma());
        this.fieldGenero.setText(livro.getGenero());
        this.fieldEditora.setText(livro.getEditora());
    }

    public void setHome(HomeController home){
        this.meuHome = home;
    }

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
    private TextField fieldIdioma;

    @FXML
    private TextField fieldGenero;

    @FXML
    private TextField fieldEditora;

    @FXML
    private Button botaoSalvar1;

    @FXML
    public void initialize() {
        livro = new Livro();
        dao = new Dao_Livro<>();
    }

    @FXML
    void salvar(ActionEvent event) {

        if (
                !fieldISBN.getText().equals("") &&
                !fieldTitulo.getText().equals("") &&
                !fieldAutor.getText().equals("") &&
                !fieldMidia.getText().equals("") &&
                !fieldAno.getText().equals("") &&
                !fieldIdioma.getText().equals("") &&
                !fieldGenero.getText().equals("") &&
                !fieldEditora.getText().equals("")
        ) {
            // Salvar

            this.livro = new Livro(
                    fieldISBN.getText(),
                    fieldTitulo.getText(),
                    fieldMidia.getText(),
                    fieldGenero.getText(),
                    fieldIdioma.getText(),
                    fieldAno.getText(),
                    fieldAutor.getText(),
                    fieldEditora.getText()
            );

            try {
                if (novoLivro){
                    dao.adiciona(this.livro);
                }else{
                    dao.altera(this.livro);
                }

            } catch (SQLException throwables) {
                FXAssistant.mostrarDialogo(
                        Alert.AlertType.ERROR,
                        "Erro na Operação!",
                        "Verifique os valores e tente novamente."
                );
            } finally {
                meuHome.atualizaTabela();

                Stage stage = (Stage) botaoVoltar.getScene().getWindow();
                stage.close();
            }

        } else {
            FXAssistant.mostrarDialogo(
                    Alert.AlertType.ERROR,
                    "Preencha todos os campos!",
                    "Alguns campos não foram preenchidos. Assegure-se de que estão preenchidos para prosseguir"
            );
        }
    }

    @FXML
    void voltar(ActionEvent event) {
        Stage stage = (Stage) botaoVoltar.getScene().getWindow();
        stage.close();
    }

}
