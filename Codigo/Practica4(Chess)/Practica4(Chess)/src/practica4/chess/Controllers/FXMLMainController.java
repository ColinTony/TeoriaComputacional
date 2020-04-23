package practica4.chess.Controllers;

import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import practica4.chess.Models.EstadoActual;
import practica4.chess.Models.Pieza;

public class FXMLMainController {
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
    
    private Pieza pieza1Object;
    private Pieza pieza2Object;
    
    private EstadoActual qA;
    
    @FXML
    void iniciar(ActionEvent event) throws InterruptedException, IOException {
        this.qA = new EstadoActual(1);
        AutomataFND automata = new AutomataFND(qA,"Prueba");
        automata.evaluarCadena("BN");
    }
    
    @FXML
    void reiniciar(ActionEvent event) {
        this.pieza1Object = new Pieza(pieza1);
        this.pieza2Object = new Pieza(pieza2);
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
        this.pieza1Object = new Pieza(pieza1);
        this.pieza2Object = new Pieza(pieza2);
    }
}
