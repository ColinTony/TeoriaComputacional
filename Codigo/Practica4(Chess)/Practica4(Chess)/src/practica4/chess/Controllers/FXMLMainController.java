package practica4.chess.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class FXMLMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnInicio;

    @FXML
    private ImageView pieza1;

    @FXML
    private ImageView pieza2;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnReiniciar;

    @FXML
    void iniciar(ActionEvent event) {

    }

    @FXML
    void reiniciar(ActionEvent event) {

    }

    @FXML
    void salir(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnInicio != null : "fx:id=\"btnInicio\" was not injected: check your FXML file 'FXMLMain.fxml'.";
        assert pieza1 != null : "fx:id=\"pieza1\" was not injected: check your FXML file 'FXMLMain.fxml'.";
        assert pieza2 != null : "fx:id=\"pieza2\" was not injected: check your FXML file 'FXMLMain.fxml'.";
        assert btnSalir != null : "fx:id=\"btnSalir\" was not injected: check your FXML file 'FXMLMain.fxml'.";
        assert btnReiniciar != null : "fx:id=\"btnReiniciar\" was not injected: check your FXML file 'FXMLMain.fxml'.";

    }
}
