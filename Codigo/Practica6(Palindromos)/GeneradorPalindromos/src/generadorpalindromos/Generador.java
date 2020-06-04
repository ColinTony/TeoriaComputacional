package generadorpalindromos;

import java.io.IOException;
import java.util.Random;
import javafx.scene.control.TextArea;

/**
 *
 * @author colin
 */
public class Generador {
    // Esta clase es la que hace la generacion del palindromo
    private int tamPal;
    private int cantPals;
    private TextArea areaEstados;
    private TextArea areaPalindromos;
    private ArchivoRutas archivoEstados;
    private ArchivoRutas archivoPalindromos;
    private Random rand;

    public Generador(int tamPal, int cantPals, TextArea areaEstados, TextArea areaPalindromos) throws IOException {
        this.tamPal = tamPal;
        this.cantPals = cantPals;
        this.areaEstados = areaEstados;
        this.areaPalindromos = areaPalindromos;
        
        this.archivoEstados = new ArchivoRutas("estados");
        this.archivoPalindromos = new ArchivoRutas("palindromos");
        this.rand = new Random();
    }
    
    public void generar()
    {
        
    }
    public void reiniciarTodo()
    {
        
    }
}
