package practica9.maquinaturing;

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
    private TextField txtCadena;

    @FXML
    private Spinner<Integer> sppinerNum;

    @FXML
    private CheckBox chkAuto;

    @FXML
    private Button btnGenerear;

    @FXML
    private Text txtCadAna;

    @FXML
    private Text txtm2;

    @FXML
    private Text txtm1;

    @FXML
    private Text txt1;

    @FXML
    private Text txt2;

    @FXML
    private Text txt0;
    @FXML
    private Text txtValida;
    
    @FXML
    private TextArea textAreaDatos;
    
    @FXML
    private Button btnReset;
    
    // variables para la Maquina de turing
    MaquinaTuring maquinaT;
    GeneradorCadenas gen;
    String cadena;

    @FXML
    void automatico(ActionEvent event) {
        this.btnGenerear.setDisable(!this.chkAuto.isSelected());
        this.txtCadena.setDisable(this.chkAuto.isSelected());
        this.sppinerNum.setDisable(!this.chkAuto.isSelected());
    }

    @FXML
    void generarCadena(ActionEvent event) {
        this.cadena = this.gen.generarCadena(this.sppinerNum.getValue());
        this.txtCadAna.setText(cadena);
    }

    @FXML
    void iniciarMaquina(ActionEvent event) throws InterruptedException {
        
        if(this.chkAuto.isSelected())
        {
            // modo automatico
            this.txtCadAna.setText(this.cadena);
            this.maquinaT = new MaquinaTuring(this.cadena, this.txtm1, this.txtm2, this.txt1, this.txt2, this.txt0, this.textAreaDatos);
            this.validar();
        }else
        {
            // modo manual
            this.txtCadAna.setText(this.txtCadena.getText());
            this.maquinaT = new MaquinaTuring(this.txtCadena.getText(), this.txtm1, this.txtm2, this.txt1, this.txt2, this.txt0, this.textAreaDatos);
            this.validar();
        }
    }
    
    @FXML
    void limpiar(ActionEvent event) {
        this.textAreaDatos.clear();
    }

    @FXML
    void initialize() {
        this.btnGenerear.setDisable(!this.chkAuto.isSelected());
        this.txtCadena.setDisable(this.chkAuto.isSelected());
        this.sppinerNum.setDisable(!this.chkAuto.isSelected());
        SpinnerValueFactory value = new SpinnerValueFactory.IntegerSpinnerValueFactory(2, 10000);
        this.sppinerNum.setValueFactory(value);
        this.gen = new GeneradorCadenas();
    }
    
    public void validar() throws InterruptedException
    {
        if(this.maquinaT.iniciarMaquina()){
            this.txtValida.setText("cadena valida");
         }else
         {
             this.txtValida.setText("Cadena invalida");
         }
    }
}
