package expresionregular;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class FXMLMainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton btnGenerarCadenas;

    @FXML
    private JFXButton btnSalir;

    @FXML
    private JFXTextArea areaText;

    @FXML
    private JFXTextArea areaTextEstados;
    
    private RE expresionR;
    
    @FXML
    void generarCadenas(ActionEvent event) throws IOException {
        this.expresionR.generar();
    }

    @FXML
    void salir(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() throws IOException {
        this.expresionR = new RE(areaTextEstados, areaText);

    }
}
