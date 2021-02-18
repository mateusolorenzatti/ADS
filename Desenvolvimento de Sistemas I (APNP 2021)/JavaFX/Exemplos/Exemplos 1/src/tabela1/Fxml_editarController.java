package tabela1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class Fxml_editarController implements Initializable {

    @FXML
    private TextField first_name;
    @FXML
    private TextField last_name;
    @FXML
    private TextField email;

    private FXMLTableViewController mainController;

    @FXML
    private void sair(ActionEvent e) {
        mainController.mostrar();
        first_name.getScene().getWindow().hide();
    }

    @FXML
    private void salvar(ActionEvent e) {
        String first = first_name.getText();
        String last = last_name.getText();
        String mail = email.getText();
        FXMLTableViewController.data.add(new Person(first, last, mail));
        mainController.mostrar();
        first_name.getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setPerson(Person p) {
        first_name.setText(p.getFirstName());
        last_name.setText(p.getLastName());
        email.setText(p.getEmail());
    }

    void setMainController(FXMLTableViewController aThis) {
        this.mainController = aThis;
    }
}
