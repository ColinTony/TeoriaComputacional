package automatapila;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class FXMLMainController {
    @FXML
    private CheckBox chkAuto;
    @FXML
    private TextField textCadena;
    @FXML
    private Spinner<Integer> longitudCadena;
    @FXML
    private Button btnGenearCadena;
    @FXML
    private Text textCadenaEvaluar;
    @FXML
    private TextArea textAreaProceso;
    @FXML
    private Text textMensaje;
    @FXML
    private Button btnStart;
    
    
    //Automata de pila
    private AutomataPila PDA;
    //generador de cadenas
    private GeneradorCadenas generador;
    
    @FXML
    void iniciar(ActionEvent event) {
        PDA = new AutomataPila();
    }

    @FXML
    void isAuto(ActionEvent event) {
        this.textCadena.setDisable(this.chkAuto.isSelected());
        this.btnGenearCadena.setDisable(!this.chkAuto.isSelected());
    }
    @FXML
    void generarCad(ActionEvent event)
    {
        String cad = this.generador.generarCadena(this.longitudCadena.getValue());
        this.textCadenaEvaluar.setText(cad);
    }

    @FXML
    void initialize() {
       SpinnerValueFactory values = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 10000,1);
       this.longitudCadena.setValueFactory(values);
       this.generador = new GeneradorCadenas();
    }
}
