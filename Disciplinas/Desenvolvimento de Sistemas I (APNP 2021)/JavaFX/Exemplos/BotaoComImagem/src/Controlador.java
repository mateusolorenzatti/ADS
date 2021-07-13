import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controlador implements Initializable {

    @FXML
    Button ok;
    @FXML
    Button cancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image img = new Image("ok.png");
        ImageView view = new ImageView(img);
        view.setFitHeight(80);
        view.setPreserveRatio(true);
        ok.setGraphic(view);

        Image img2 = new Image("cancel.png");
        ImageView view2 = new ImageView(img2);
        view2.setFitHeight(80);
        view2.setPreserveRatio(true);
        cancel.setGraphic(view2);
    }
}
