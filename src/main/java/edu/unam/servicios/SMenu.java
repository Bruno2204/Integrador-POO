package edu.unam.servicios;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SMenu {
    @FXML
    Button btPersonas;
    public void switchToPersonas(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/edu/unam/Persona.fxml"));
            Stage stage = (Stage) btPersonas.getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.show();
//            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Persona.fxml"));
//            Scene scene = new Scene(fxmlLoader.load());
//            stage.setScene(scene);
//            stage.show();
//            URL url = getClass().getResource("/edu/unam/sample.fxml");
//            Parent root = FXMLLoader.load(url);
//            Scene scene = new Scene(root);
//            Stage stage = (Stage) btPersonas.getScene().getWindow();
//            stage.setScene(scene);
//            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
