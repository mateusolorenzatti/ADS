module ExerciciosDialog {

    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports Objects;
    opens Objects to javafx.base;

    opens Main;
}