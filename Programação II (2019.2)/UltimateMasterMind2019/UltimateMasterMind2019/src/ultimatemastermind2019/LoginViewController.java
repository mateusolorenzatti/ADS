package ultimatemastermind2019;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.*;

public class LoginViewController {

    @FXML
    private Button criarContaBotao;

    @FXML
    private TextField usuarioField;

    @FXML
    private Button logarBotao;

    @FXML
    private PasswordField senhaField;

    @FXML
    void logar(ActionEvent event) throws IOException {
        CadJogadores cj = new CadJogadores();
        
        String usuario = this.usuarioField.getText();
        String senha = this.senhaField.getText();
        int encontrado = -1;
        
        for (int i = 0; i < cj.getTam(); i++) {
            Jogador jogador = cj.getElemento(i);
            
            if ((jogador.getUsuario().equals(usuario)) && (jogador.getSenha().equals(senha))){
                encontrado = i;
            }
        }
        
        if(encontrado >= 0){
            Stage stage2 = (Stage) usuarioField.getScene().getWindow();
            stage2.close();
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("JogoView.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            
            JogoViewController controller = fxmlLoader.<JogoViewController>getController();
            controller.setJogador(encontrado);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
            
        }else{
            Alert dialogo = new Alert(Alert.AlertType.WARNING, "Usuário ou senha incorretos, tente novamente!");
            dialogo.showAndWait();
            
            this.usuarioField.clear();
            this.senhaField.clear();
        }
    }

    @FXML
    void criarConta(ActionEvent event) throws IOException {
        Stage stage2 = (Stage) usuarioField.getScene().getWindow();
        stage2.close();
        
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CriarContaView.fxml"));
        Parent root = (Parent) fxmlLoader.load();

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

}
