package practica4.chess.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.animation.SequentialTransition;
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
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
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
    private Button bntVerRutaA1;
    @FXML
    private Button btnVerRutaA2;
    @FXML
    private Button btnAmbasAnim;
    @FXML
    private Spinner<Integer> spinerNumber;
    @FXML
    private Button btnGenerarCadenas;
    
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
            if(!this.tableRutasVA2.getItems().isEmpty())
            {
                // si no hay rutas validas
                this.tableRutasVA2.getSelectionModel().select(0);
                this.tableRutasVA2.getSelectionModel().focus(0);
                this.btnAnim2A.setDisable(false);
                this.btnVerRutaA2.setDisable(false);
            }else
                alerta("NO HAY RUTAS", "La cadena ingresada no tiene una ruta valida");
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
            
            // llenamos la tabla
            this.tableRutasVA1.getItems().setAll(this.automata1.getCaminosValidos());
            if(!this.tableRutasVA1.getItems().isEmpty())
            {
                // si hay rutas validas
                this.tableRutasVA1.getSelectionModel().select(0);
                this.tableRutasVA1.getSelectionModel().focus(0);
                // habilitamos su boton para iniciar la animacion
                this.btnAnim1A.setDisable(false);
                this.bntVerRutaA1.setDisable(false);
            }else
                alerta("NO HAY RUTAS", "La cadena ingresada no tiene una ruta valida");
        }
        else{
            // si esta vacio el texto
            btnAnim1A.setDisable(true);
            alerta("!ERROR¡", "Debes escribir una cadena para el automata 1");
        }
    }

    @FXML
    void iniciarAnimA1(ActionEvent event) throws IOException, InterruptedException {
        
        CaminosValidos camino = this.tableRutasVA1.getSelectionModel().getSelectedItem();
        // se elige una animacion
        this.pieza1AObj.cargarAnimacion(camino.getCaminoValido());
        this.pieza1AObj.iniciarAnimacion();
    }

    @FXML
    void iniciarAnimA2(ActionEvent event) throws InterruptedException {
        CaminosValidos camino2 = this.tableRutasVA2.getSelectionModel().getSelectedItem();
        this.pieza2AObj.cargarAnimacion(camino2.getCaminoValido());
        this.pieza2AObj.iniciarAnimacion();
    }
    
    @FXML
    void animA1A2(ActionEvent event) throws InterruptedException {
        
        if(this.btnAnim1A.isDisable() || this.btnAnim2A.isDisable())
            alerta("Error", "Una de las cadenas no es correcta");
        else
        {
            SequentialTransition sq = new SequentialTransition();
            CaminosValidos caminos = this.tableRutasVA1.getSelectionModel().getSelectedItem();
            CaminosValidos caminos2 = this.tableRutasVA2.getSelectionModel().getSelectedItem();

            this.pieza1AObj.cargarAnimacion(caminos.getCaminoValido());
            this.pieza2AObj.cargarAnimacion(caminos2.getCaminoValido());

            int sizeA1= this.pieza1AObj.getAnimSecuencia().getChildren().size();
            int sizeA2 =this.pieza2AObj.getAnimSecuencia().getChildren().size();
            if(sizeA1>=sizeA2)   // cual tiene mas animaciones
                for(int i=0; i<sizeA1; i++)
                {
                    sq.getChildren().add(this.pieza1AObj.getAnimSecuencia().getChildren().get(i));
                    if(i<sizeA2)
                        sq.getChildren().add(this.pieza2AObj.getAnimSecuencia().getChildren().get(i));
                }
            if(sizeA1<sizeA2)   // cual tiene mas animaicones
                for(int i = 0; i<sizeA2; i++)
                {
                    sq.getChildren().add(this.pieza2AObj.getAnimSecuencia().getChildren().get(i));
                    if(i<sizeA1)
                        sq.getChildren().add(this.pieza1AObj.getAnimSecuencia().getChildren().get(i));
                }
            
            sq.play();
        }
        
    }

    @FXML
    void reiniciar(ActionEvent event) throws InterruptedException, IOException {
        this.pieza1AObj.reiniciar();
        this.pieza2AObj.reiniciar();
        this.pieza1AObj = new Pieza(pieza1, 1);
        this.pieza2AObj = new Pieza(pieza2, 4);
    }

    @FXML
    void salir(ActionEvent event) {
        Stage stageActual = (Stage)this.btnSalir.getScene().getWindow();
        stageActual.close();
    }

    @FXML
    void verRutaA1(ActionEvent event) {
        Alert dialogAlert = new Alert(Alert.AlertType.INFORMATION); // creamos el dialogo de alreta
        dialogAlert.setTitle("RUTA ELEGIDA");
        dialogAlert.setContentText(this.tableRutasVA1.getSelectionModel().getSelectedItem().getCaminoValido());
        dialogAlert.setHeaderText(null);
        dialogAlert.initStyle(StageStyle.UTILITY);
        dialogAlert.showAndWait();
    }
    
    @FXML
    void verRutaA2(ActionEvent event) {
        Alert dialogAlert = new Alert(Alert.AlertType.INFORMATION); // creamos el dialogo de alreta
        dialogAlert.setTitle("RUTA ELEGIDA");
        dialogAlert.setContentText(this.tableRutasVA2.getSelectionModel().getSelectedItem().getCaminoValido());
        dialogAlert.setHeaderText(null);
        dialogAlert.initStyle(StageStyle.UTILITY);
        dialogAlert.showAndWait();
    }
    
    @FXML
    void generarCadenas(ActionEvent event) {
        int azar =0;
        Random r = new Random();
        int maxCad = Integer.valueOf(this.spinerNumber.getEditor().getText());
        String nuevaCad = "";
        if(maxCad>0){
            for(int j=0; j<2; j++)
            {
                for(int i = 0; i<maxCad; i++)
                {
                    azar = r.nextInt(2);
                    System.out.println(azar);
                    if(azar == 1)
                        nuevaCad += "N";
                    else
                        nuevaCad += "B";
                }
                
                if(j == 0)
                    this.txtCadenaA1.setText(nuevaCad);
                else
                    this.txtCadenaA2.setText(nuevaCad);
                nuevaCad = "";
            }
        }
        else
            alerta("ERROR", "Debes elegir una cadena mayor a 0");
    }
    
    @FXML
    void initialize() {
        // inicializando las piezas y diciendoles cuales son para animarlas con
        // la clase Pieza
        this.pieza1AObj = new Pieza(this.pieza1,1);
        this.pieza2AObj = new Pieza(this.pieza2,4);
        // inicializamos las columnas de las tablas
        this.columnRVA1.setCellValueFactory(new PropertyValueFactory<>("caminoValido"));
        this.columnIndexA1.setCellValueFactory(new PropertyValueFactory<>("indexCaminos"));
        this.columnRVA2.setCellValueFactory(new PropertyValueFactory<>("caminoValido"));
        this.columnIndexA2.setCellValueFactory(new PropertyValueFactory<>("indexCaminos"));
        this.tableRutasVA1.setPlaceholder(new Label("No hay caminos validos"));
        this.tableRutasVA2.setPlaceholder(new Label("No hay caminos validos"));
        SpinnerValueFactory<Integer> valuesFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 15, 0);
        this.spinerNumber.setValueFactory(valuesFactory);
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
