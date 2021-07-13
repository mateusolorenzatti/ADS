package janelas;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Janela1FXMLController implements Initializable {
    @FXML
    private DatePicker datepicker;
    @FXML
    private ImageView image_view;

    @FXML
    private void data_selecionada(ActionEvent e) {
        LocalDate date = datepicker.getValue();
        System.out.println("Selected date: " + date);
        Image image;

        if (date.getDayOfMonth() > 15) {
            System.out.println("Image 1");
            image = new Image(Janela1FXMLController.class.getResourceAsStream("imagem1.jpg"));
        } else {
            System.out.println("Image 2");
            image = new Image(Janela1FXMLController.class.getResourceAsStream("imagem2.jpg"));
        }
        image_view.setImage(image);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
