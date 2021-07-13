package Helpers;

import javafx.scene.control.Alert;

public class FXAssistant {

    public static void mostrarDialogo(Alert.AlertType tipo, String titulo, String conteudo) {
        Alert a = new Alert(tipo);

        a.setHeaderText(titulo);
        a.setContentText(conteudo);
        a.show();
    }
}
