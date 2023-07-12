package edu.unam.vistas;

import edu.unam.modelo.Accion;
import edu.unam.modelo.Expediente;
import edu.unam.modelo.Persona;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ExpedienteABM extends Application {
    private ObservableList<Expediente> expedientes = FXCollections.observableArrayList();
    private ListView<Expediente> expedientesListView; // Mover la declaración aquí

    private TextField notaField;
    private DatePicker fechaIngresoPicker;
    private ComboBox<Persona> inicianteComboBox;
    private ListView<Persona> involucradosListView;
    private ListView<Accion> accionesListView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ABM de Expedientes");


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);

        // Etiquetas
        Label notaLabel = new Label("Nota:");
        grid.add(notaLabel, 0, 0);

        Label fechaIngresoLabel = new Label("Fecha de ingreso:");
        grid.add(fechaIngresoLabel, 0, 1);

        Label inicianteLabel = new Label("Iniciante:");
        grid.add(inicianteLabel, 0, 2);

        Label involucradosLabel = new Label("Involucrados:");
        grid.add(involucradosLabel, 0, 3);

        Label accionesLabel = new Label("Acciones:");
        grid.add(accionesLabel, 0, 4);

        // Campos de entrada
        notaField = new TextField();
        grid.add(notaField, 1, 0);

        fechaIngresoPicker = new DatePicker();
        grid.add(fechaIngresoPicker, 1, 1);

        inicianteComboBox = new ComboBox<>();
        grid.add(inicianteComboBox, 1, 2);

        involucradosListView = new ListView<>();
        grid.add(involucradosListView, 1, 3);

        accionesListView = new ListView<>();
        grid.add(accionesListView, 1, 4);

        // Botones
        Button addButton = new Button("Agregar");
        addButton.setOnAction(e -> agregarExpediente());
        grid.add(addButton, 0, 5);

        Button updateButton = new Button("Modificar");
        updateButton.setOnAction(e -> modificarExpediente());
        grid.add(updateButton, 1, 5);

        Button deleteButton = new Button("Eliminar");
        deleteButton.setOnAction(e -> eliminarExpediente());
        grid.add(deleteButton, 2, 5);

        // Configurar la lista de personas iniciantes
        inicianteComboBox.setItems(FXCollections.observableArrayList(
                new Persona("Juan", "Perez", "123456789"),
                new Persona("María", "López", "987654321")
        ));

        // Configurar la visualización de los expedientes
        expedientesListView = new ListView<>(expedientes);
        expedientesListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                mostrarExpedienteSeleccionado(newValue));
        grid.add(expedientesListView, 2, 0, 1, 5);

        Scene scene = new Scene(grid, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void agregarExpediente() {
        String nota = notaField.getText();
        LocalDate fechaIngreso = fechaIngresoPicker.getValue();
        Persona iniciante = inicianteComboBox.getValue();

        if (nota.isEmpty() || fechaIngreso == null || iniciante == null) {
            mostrarAlerta("Todos los campos son requeridos");
            return;
        }

        Expediente expediente = new Expediente(nota, fechaIngreso, iniciante);
        expedientes.add(expediente);
        limpiarCampos();
    }

    private void modificarExpediente() {
        Expediente expedienteSeleccionado = obtenerExpedienteSeleccionado();

        if (expedienteSeleccionado != null) {
            String nota = notaField.getText();
            LocalDate fechaIngreso = fechaIngresoPicker.getValue();
            Persona iniciante = inicianteComboBox.getValue();

            if (nota.isEmpty() || fechaIngreso == null || iniciante == null) {
                mostrarAlerta("Todos los campos son requeridos");
                return;
            }

            expedienteSeleccionado.setNota(nota);
            expedienteSeleccionado.setFechaIngreso(fechaIngreso);
            expedienteSeleccionado.setIniciante(iniciante);
            limpiarCampos();
        }
    }

    private void eliminarExpediente() {
        Expediente expedienteSeleccionado = obtenerExpedienteSeleccionado();

        if (expedienteSeleccionado != null) {
            expedientes.remove(expedienteSeleccionado);
            limpiarCampos();
        }
    }

    private void mostrarExpedienteSeleccionado(Expediente expediente) {
        if (expediente != null) {
            notaField.setText(expediente.getNota());
            fechaIngresoPicker.setValue(expediente.getFechaIngreso());
            inicianteComboBox.setValue(expediente.getIniciante());
        }
    }

    private Expediente obtenerExpedienteSeleccionado() {
        return expedientesListView.getSelectionModel().getSelectedItem();
    }

    private void limpiarCampos() {
        notaField.clear();
        fechaIngresoPicker.setValue(null);
        inicianteComboBox.setValue(null);
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
