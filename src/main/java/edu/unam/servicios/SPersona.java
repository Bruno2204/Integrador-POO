package edu.unam.servicios;

import edu.unam.modelo.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private
    TextField nameField;
    @FXML
    private
    TextField surnameField;
    @FXML
    private
    TextField cuilField;
    @FXML
    private
    TableView<Persona> tableView;
    @FXML
    private
    Button btRemove;
    @FXML
    private
    Button btModify;
    @FXML
    private TableColumn<Persona, String> colNombre;
    @FXML
    private TableColumn<Persona, String> colApellido;
    @FXML
    private TableColumn<Persona, String> colCUIL;
    private ObservableList<Persona> personas;

    public void agregar(){
        String nombre = nameField.getText();
        String apellido = surnameField.getText();
        String cuil = cuilField.getText();
        Persona p = new Persona(nombre,apellido,cuil);
        personas.add(p);
        this.tableView.setItems(personas);
    }


    public void eliminar() {

        Persona p = tableView.getSelectionModel().getSelectedItem();

        if (p != null) {
            personas.remove(p);
            tableView.refresh();
            tableView.getSelectionModel().clearSelection();
            btModify.setDisable(true);
            btRemove.setDisable(true);
            nameField.setText("");
            surnameField.setText("");
            cuilField.setText("");
        }

    }
    public void seleccionar(){
        Persona p = tableView.getSelectionModel().getSelectedItem();
        if (p != null){
            btModify.setDisable(false);
            btRemove.setDisable(false);
            nameField.setText(p.getNombre());
            surnameField.setText(p.getApellido());
            cuilField.setText(p.getCuil());
        }
    }
    public void modificar(){
        Persona p = tableView.getSelectionModel().getSelectedItem();
        String nombre = nameField.getText();
        String apellido = surnameField.getText();
        String cuil = cuilField.getText();

        p.setNombre(nombre);
        p.setApellido(apellido);
        p.setCuil(cuil);

        tableView.refresh();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        personas = FXCollections.observableArrayList(
                new Persona("Roberto","Carlos","30-45213671-2"),
                new Persona("Lionel","Messi","20-33451278-1")
        );
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        colCUIL.setCellValueFactory(new PropertyValueFactory<>("cuil"));
        tableView.setItems(personas);
    }

}
