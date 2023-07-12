module edu.unam {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens edu.unam to javafx.fxml;
    exports edu.unam;
    exports edu.unam.vistas;
}