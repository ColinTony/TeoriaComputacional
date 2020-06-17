package generadorpalindromos;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class FXMLMainController {

    @FXML
    private TextArea areaPalindromos;

    @FXML
    private TextArea areaEstados;

    @FXML
    private Spinner<Integer> spinerTam;

    @FXML
    private Spinner<Integer> spinerCant;

    @FXML
    private Button btnGenerar;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnReinicio;

     @FXML
    private CheckBox chkAuto;
     
     // Generador class
     Generador gen;

    @FXML
    void automaticoEnable(ActionEvent event) {
        if(chkAuto.isSelected())
            this.spinerTam.setDisable(true);
        else
            this.spinerTam.setDisable(false);
    }
    @FXML
    void generar(ActionEvent event) throws IOException {
        if(!this.chkAuto.isSelected())
            this.gen.generar(this.spinerCant.getValue(),this.spinerTam.getValue());
        else
            this.gen.generar(this.spinerCant.getValue());
        
        this.btnReinicio.setDisable(false);
    }

    @FXML
    void reinicio(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText("Esta accion borrara el archivo de estados y palindromos anteriores,¿Estas seguro?");
        Optional<ButtonType> action = alert.showAndWait();
        
        // Si hemos pulsado en aceptar
        if(action.get() == ButtonType.OK){
            this.gen.reiniciarTodo();
            this.btnReinicio.setDisable(true);
        }
            
    }

    @FXML
    void salir(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() throws IOException {
        // inicializamos los spinners
        SpinnerValueFactory<Integer> valueF = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10); // numero de cadenas
        SpinnerValueFactory<Integer> valueF2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 100000); // minimo 3 hasta 100,000
        this.spinerTam.setValueFactory(valueF2);
        this.spinerCant.setValueFactory(valueF);
        this.spinerCant.setEditable(false);
        this.spinerTam.setEditable(false);
        this.btnReinicio.setDisable(true);
        this.gen = new Generador(this.spinerCant.getValue(), this.spinerTam.getValue(), areaEstados, areaPalindromos);
    }
}
