package practica4.chess.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import practica4.chess.Models.CaminosValidos;
import practica4.chess.Models.Pieza;

public class FXMLMainController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private Button btnAnim1A;
    @FXML
    private ImageView pieza1;
    @FXML
    private ImageView pieza2;
    @FXML
    private Button btnSalir;
    @FXML
    private Button btnReiniciar;
    @FXML
    private TextField txtCadenaA1;
    @FXML
    private TextArea areaTxtA1;
    @FXML
    private TextField txtCadenaA2;
    @FXML
    private Button btnGenRutasA2;
    @FXML
    private TextArea areaTxtA2;
    @FXML
    private Button btnAnim2A;
    @FXML
    private Button btnGenRutasA1;
    @FXML
    private Button btnAnimacionA1A2;
    
    @FXML
    private TableView<CaminosValidos> tableRutasVA1;
    @FXML
    private TableColumn<CaminosValidos, Integer> columnIndexA1;
    @FXML
    private TableColumn<CaminosValidos, String> columnRVA1;
    @FXML
    private TableView<CaminosValidos> tableRutasVA2;
    @FXML
    private TableColumn<CaminosValidos, Integer> columnIndexA2;
    @FXML
    private TableColumn<CaminosValidos, String> columnRVA2;
    
    // variables fuera de la vista
    private Pieza pieza1AObj;
    private Pieza pieza2AObj;
    
    // automatas
    private AutomataFND automata1;
    private AutomataFND automata2;
    
    // funciones para el funcionamiento del automata.
    @FXML
    void GenerarRutasA2(ActionEvent event) throws IOException {
        
        // determinamos si no esta vacio el texto del TextField para automata 1
        if(!txtCadenaA2.getText().isEmpty())
        {
            // si no esta vacio
            // convertimos el texto a mayusculas
            // se inicializa empezando en 1 y terminando en 9 como estado valido
            this.automata2 = new AutomataFND(4,13,"automata2", txtCadenaA2.getText().toString().trim().toUpperCase());
            this.automata2.evaluarCadena();
            this.automata2.guardarRutas(this.areaTxtA2); // se guardan las rutas en el archivo
            // habilitamos su boton para iniciar la animacion
            this.btnAnim2A.setDisable(false);
            // lenamos la tabla
            this.tableRutasVA2.getItems().setAll(this.automata2.getCaminosValidos());
        }
        else{
            // si esta vacio el texto
            btnAnim2A.setDisable(true);
            alerta("!ERROR¡", "Debes escribir una cadena para el automata 2");
        }
    }

    @FXML
    void generarRutasA1(ActionEvent event) throws IOException {
        // determinamos si no esta vacio el texto del TextField para automata 1
        if(!txtCadenaA1.getText().isEmpty())
        {
            // si no esta vacio
            // convertimos el texto a mayusculas
            // se inicializa empezando en 1 y terminando en 9 como estado valido
            this.automata1 = new AutomataFND(1,16,"automata1", txtCadenaA1.getText().toString().trim().toUpperCase());
            this.automata1.evaluarCadena();
            this.automata1.guardarRutas(this.areaTxtA1); // se guardan las rutas en el archivo
            // habilitamos su boton para iniciar la animacion
            this.btnAnim1A.setDisable(false);
            // llenamos la tabla
            this.tableRutasVA1.getItems().setAll(this.automata1.getCaminosValidos());
        }
        else{
            // si esta vacio el texto
            btnAnim1A.setDisable(true);
            alerta("!ERROR¡", "Debes escribir una cadena para el automata 1");
        }
    }

    @FXML
    void iniciarAmbasAnim(ActionEvent event){
        
    }

    @FXML
    void iniciarAnimA1(ActionEvent event) throws IOException {
        // cheamos los caminos validos
        Parent root = FXMLLoader.load(this.getClass().getResource("/practica4/chess/Views/FXMLMensaje.fxml"));
        // asignamos la escena
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void iniciarAnimA2(ActionEvent event) {
        
    }

    @FXML
    void reiniciar(ActionEvent event) {
        
    }

    @FXML
    void salir(ActionEvent event) {
        Stage stageActual = (Stage)this.btnSalir.getScene().getWindow();
        stageActual.close();
    }

    @FXML
    void initialize() {
        // inicializando las piezas y diciendoles cuales son para animarlas con
        // la clase Pieza
        this.pieza1AObj = new Pieza(this.pieza1);
        this.pieza2AObj = new Pieza(this.pieza2);
        // inicializamos las columnas de las tablas
        this.columnRVA1.setCellValueFactory(new PropertyValueFactory<>("caminoValido"));
        this.columnIndexA1.setCellValueFactory(new PropertyValueFactory<>("indexCaminos"));
        this.columnRVA2.setCellValueFactory(new PropertyValueFactory<>("caminoValido"));
        this.columnIndexA2.setCellValueFactory(new PropertyValueFactory<>("indexCaminos"));
    }
    
    // funcion para mostrar alerta de digalogo
    public void alerta(String titulo,String contenido)
    {
        Alert dialogAlert = new Alert(Alert.AlertType.ERROR); // creamos el dialogo de alreta
        dialogAlert.setTitle(titulo);
        dialogAlert.setContentText(contenido);
        dialogAlert.setHeaderText(null);
        dialogAlert.initStyle(StageStyle.UTILITY);
        dialogAlert.showAndWait();
    }
}
