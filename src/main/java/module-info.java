module edu.unam {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens edu.unam to javafx.fxml;
    opens edu.unam.servicios to javafx.fxml;
    opens edu.unam.modelo to javafx.base;

    exports edu.unam;
    exports edu.unam.vistas;
    exports edu.unam.servicios;
}