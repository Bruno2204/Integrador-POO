package edu.unam.servicios;

import edu.unam.modelo.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    Button btRemove;
    @FXML
    Button btModify;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellido;
    @FXML
    private TableColumn colCUIL;
    public ObservableList<Persona> personas;

    public void agregar(ActionEvent e){
        String nombre = nameField.getText();
        String apellido = surnameField.getText();
        String cuil = cuilField.getText();
        Persona p = new Persona(nombre,apellido,cuil);
        personas.add(p);
        this.tableView.setItems(personas);
    }


    public void eliminar() {

        // Obtengo la persona seleccionada
        Persona p = tableView.getSelectionModel().getSelectedItem();

        // Si la persona es nula, lanzo error
        if (p != null) {
            personas.remove(p);
            tableView.refresh();
        }

    }
    public void botonChanges(){
        Persona p = tableView.getSelectionModel().getSelectedItem();
        if (p != null){
            btModify.setDisable(false);
            btRemove.setDisable(false);
            nameField.setText(p.nombre);
            surnameField.setText(p.apellido);
            cuilField.setText(p.cuil);
        }
    }
    public void modificar(){
        Persona p = tableView.getSelectionModel().getSelectedItem();
        String nombre = nameField.getText();
        String apellido = surnameField.getText();
        String cuil = cuilField.getText();

        p.nombre = nombre;
        p.apellido = apellido;
        p.cuil = cuil;

        tableView.refresh();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        personas = FXCollections.observableArrayList();
        colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory("apellido"));
        colCUIL.setCellValueFactory(new PropertyValueFactory("cuil"));
    }
}
