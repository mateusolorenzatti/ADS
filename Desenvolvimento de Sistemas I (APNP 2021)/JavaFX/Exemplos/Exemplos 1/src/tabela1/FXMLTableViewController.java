package tabela1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLTableViewController implements Initializable {

    @FXML
    public static ObservableList<Person> data;
    @FXML
    private TableView<Person> tableView;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private Label first_name;
    @FXML
    private Label last_name;
    @FXML
    private Label email;
    
    private Stage stage;

    @FXML
    public void addPerson(ActionEvent event) {
        data.add(new Person(firstNameField.getText(),
                lastNameField.getText(),
                emailField.getText()
        ));

        firstNameField.setText("");
        lastNameField.setText("");
        emailField.setText("");
    }

    @FXML
    public void deletePerson(ActionEvent e) {
        Person p = tableView.getSelectionModel().getSelectedItem();

        remove_person(p);
    }

    private void remove_person(Person pessoa_selecionada) {
        if (pessoa_selecionada != null) {
            data.remove(pessoa_selecionada);
            first_name.setText("");
            last_name.setText("");
            email.setText("");
        }
    }

    @FXML
    public void editPerson(ActionEvent e) {
        Person p = tableView.getSelectionModel().getSelectedItem();
        remove_person(p);
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml_editar.fxml"));
            Parent root = loader.load();
            Fxml_editarController controlador = loader.getController();

            Scene scene = new Scene(root);
            Stage stage1 = new Stage();

            controlador.setPerson(p);
            controlador.setMainController(FXMLTableViewController.this);
            stage1.setTitle("Edit Person");
            stage1.setScene(scene);
            stage1.setAlwaysOnTop(true);
            stage1.show();
            tableView.getScene().getWindow().hide();
        } catch (IOException ex) {
            System.err.println("Erro ao abrir Janela de Edição");
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        data = tableView.getItems();

        tableView.setOnMouseClicked(e -> {
            Person pessoa_selecionada = tableView.getSelectionModel().getSelectedItem();

            if (pessoa_selecionada != null) {
                first_name.setText(pessoa_selecionada.getFirstName());
                last_name.setText(pessoa_selecionada.getLastName());
                email.setText(pessoa_selecionada.getEmail());
            } else {
                first_name.setText("");
                last_name.setText("");
                email.setText("");
            }
        });
    }

    public void setStage(Stage primaryStage) {
        this.stage = primaryStage;
    }
    
    public void mostrar() {
        this.stage.show();
    }
}
