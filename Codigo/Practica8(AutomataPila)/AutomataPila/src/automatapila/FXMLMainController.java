package automatapila;

import java.io.IOException;
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
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
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
    private PDA automataDePila;
    //generador de cadenas
    private GeneradorCadenas generador;
    private String cad;
    
    @FXML
    void iniciar(ActionEvent event) throws IOException {
        
        if(this.chkAuto.isSelected()) // generacion automatica
            this.automataDePila = new PDA(this.cad,this.textAreaProceso);
        else{
            // cadena manual
            this.textCadenaEvaluar.setText(this.textCadena.getText().trim());
            this.automataDePila = new PDA(this.textCadena.getText().trim(),this.textAreaProceso);
        }
        
        if(this.automataDePila.empezarEvaluacion()){
            this.textMensaje.setText("La cadena es valida");
            this.textMensaje.setFill(Color.web("#40FF00"));
        }
        else{
            this.textMensaje.setText("La cadena es invalida");
            this.textMensaje.setFill(Color.web("#FF0000"));
        }
    }

    @FXML
    void isAuto(ActionEvent event) {
        this.textCadena.setDisable(this.chkAuto.isSelected());
        this.btnGenearCadena.setDisable(!this.chkAuto.isSelected());
    }
    @FXML
    void generarCad(ActionEvent event)
    {
        this.cad = this.generador.generarCadena(this.longitudCadena.getValue());
        this.textCadenaEvaluar.setText(this.cad);
    }

    @FXML
    void initialize() {
       SpinnerValueFactory values = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 10000,1);
       this.longitudCadena.setValueFactory(values);
       this.generador = new GeneradorCadenas();
       this.btnGenearCadena.setDisable(!this.chkAuto.isSelected());
       this.btnStart.setDisable(false);
    }
}
