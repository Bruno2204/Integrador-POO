package edu.unam.servicios;

import edu.unam.modelo.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class SPersona implements Initializable {
    @FXML
    TextField nameField;
    @FXML
    TextField surnameField;
    @FXML
    TextField cuilField;
    @FXML
    TableView<Persona> tableView;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellido;
    @FXML
    private TableColumn colCUIL;
    public ObservableList<Persona> personas = FXCollections.observableArrayList();

    public void agregar(ActionEvent e){
        String nombre = nameField.getText();
        String apellido = surnameField.getText();
        String cuil = cuilField.getText();
        Persona p = new Persona(nombre,apellido,cuil);
        personas.add(p);
        this.tableView.setItems(personas);
    }
    public void eliminar(){
        System.out.println(personas.get(0).nombre);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        this.colNombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
        this.colApellido.setCellValueFactory(new PropertyValueFactory("Apellido"));
        this.colCUIL.setCellValueFactory(new PropertyValueFactory("cuil"));
    }
}
