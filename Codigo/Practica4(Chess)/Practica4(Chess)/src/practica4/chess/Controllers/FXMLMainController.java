package practica4.chess.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
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
    
    // variables fuera de la vista
    private Pieza pieza1AObj;
    private Pieza pieza2AObj;
    
    // funciones para el funcionamiento del automata.
    @FXML
    void GenerarRutasA2(ActionEvent event) {

    }

    @FXML
    void generarRutasA1(ActionEvent event) {

    }

    @FXML
    void iniciarAmbasAnim(ActionEvent event) {

    }

    @FXML
    void iniciarAnimA1(ActionEvent event) {

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
    }
}
