package ultimatemastermind2019;

import model.*;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

public class CriarContaViewController {

    @FXML
    private Button criarConta;

    @FXML
    private TextField usuarioFone;

    @FXML
    private Button voltarLogin;

    @FXML
    private TextField usuarioNome;

    @FXML
    private TextField usuarioField;

    @FXML
    private PasswordField senhaField;

    @FXML
    void criarConta(ActionEvent event) throws IOException {
        String senha2 = this.senhaField.getText().toUpperCase();
        String senha3 = this.senhaField.getText().toLowerCase();

        if (this.senhaField.getText().equals(senha2)) {
            Alert aviso = new Alert(Alert.AlertType.ERROR, "Senha não aceita!  A senha deve conter no máximo 8 caracteres, três caracteres maiúsculos, dois números e um caractere especial");
            aviso.showAndWait();
            this.senhaField.clear();
        } else if (this.senhaField.getText().equals(senha3)) {
            Alert aviso = new Alert(Alert.AlertType.ERROR, "Senha não aceita!  A senha deve conter no máximo 8 caracteres, três caracteres maiúsculos, dois números e um caractere especial");
            aviso.showAndWait();
            this.senhaField.clear();
        } else if (!(verificarCaracteresNumeros(this.senhaField.getText()))) {
            Alert aviso = new Alert(Alert.AlertType.ERROR, "Senha não aceita!  A senha deve conter no máximo 8 caracteres, três caracteres maiúsculos, dois números e um caractere especial");
            aviso.showAndWait();
            this.senhaField.clear();
        } else if (this.usuarioField.getText().length() > 10) {
            Alert aviso = new Alert(Alert.AlertType.ERROR, "O nome de usuário deve ser de no máximo 10 caracteres!");
            aviso.showAndWait();
            this.usuarioField.clear();
        } else if (verificarNomeRepetido(this.usuarioField.getText())) {
            Alert aviso = new Alert(Alert.AlertType.ERROR, "Nome de usuário Já existente! Escolha outro!");
            aviso.showAndWait();
            this.usuarioField.clear();
        } else if (this.usuarioNome.getText().length() > 30) {
            Alert aviso = new Alert(Alert.AlertType.ERROR, "O nome deve ser de no máximo 30 caracteres!");
            aviso.showAndWait();
            this.usuarioNome.clear();
        } else if (!(verificarFormatoTelefone(this.usuarioFone.getText()))) {
            Alert aviso = new Alert(Alert.AlertType.ERROR, "O formato do telefone deve ser em (99)99999-9999 !");
            aviso.showAndWait();
            this.usuarioFone.clear();
        } else {
            CadJogadores cj = new CadJogadores();

            cj.insere(new Jogador(this.usuarioField.getText(), this.senhaField.getText(), this.usuarioNome.getText(), this.usuarioFone.getText()));

            cj.imprimeValores();

            this.redirectLogin();
        }

    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        this.redirectLogin();
    }

    private void redirectLogin() throws IOException {
        Stage stage2 = (Stage) usuarioField.getScene().getWindow();
        stage2.close();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginView.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    private boolean verificarNomeRepetido(String nome) {
        CadJogadores cad = new CadJogadores();
        boolean repetido = false;

        for (int i = 0; i < cad.getTam(); i++) {
            if (cad.getElemento(i).getUsuario().equals(nome)) {
                repetido = true;
            }
        }

        return repetido;
    }

    //Retornará TRUE se todos os testes derem certo
    private boolean verificarFormatoTelefone(String telefone) {
        boolean aprovado = true;
        
        if((telefone.charAt(0) != '(') || (telefone.charAt(3) != ')') || (telefone.charAt(9) != '-')){
            aprovado = false;
        }
        
        return aprovado;
    }

    //Retornará TRUE se todos os testes derem certo
    private boolean verificarCaracteresNumeros(String text) {
        boolean b_numeros = false, b_chars = false;
        int i_numeros = 0, i_chars = 0;

        String[] numeros = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] caracteres = {"!", "@", "_", "$", "%", "&", "*", ".", "/", "#", "?", "{", "}", "[", "]", "(", ")"};

        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < numeros.length; j++) {
                //Testa os números  
                if (text.charAt(i) == numeros[j].charAt(0)) {
                    i_numeros++;
                }

                //Testa os caracteres
                if (text.charAt(i) == caracteres[j].charAt(0)) {
                    i_chars++;
                }
            }
        }

        if (i_numeros >= 2) {
            b_numeros = true;
        }

        if (i_chars >= 1) {
            b_chars = true;
        }

        return (b_numeros && b_chars);
    }

}
