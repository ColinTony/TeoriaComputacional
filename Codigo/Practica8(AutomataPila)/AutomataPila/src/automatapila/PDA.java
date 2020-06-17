package automatapila;
import java.io.IOException;
import java.util.Stack;
/**
 *
 * @author colin
 */
public class PDA {
    // aqui estara escrito el codigo para el automata de pila.
    private String estado;
    private String cadena;
    private Stack<String> pila;
    private boolean isValida;
    private ArchivosRutas secuencia;
    
    public PDA(String cadena) throws IOException
    {
        // constructor
        this.secuencia = new ArchivosRutas("secuencia");
        this.cadena = cadena;
        this.estado = "q";
        this.pila = new Stack();
        this.isValida = false;
        
    }
    /*
        Empezara el proceso del automata
        para determinar si la cadena es valida
        devolvera un true o false si la cadena es o no valida
    */
    public boolean empezarEvaluacion()
    {
        
        return this.isValida;
    }
    
    /*
        Esta funcion evalua el caracter
        Hace pop o push dependiendo del valor
        y cambia el estado actual.
    */
    private void transicion(String estado,String cadena){
        
    }
    
    /*
        Determina si la cadena es valida
        Se ejecuta esta funcion cuando el estado
        sea el f y verifica que el top de la pila sea Z
    */
    private boolean isValida()
    {
       
       return this.isValida;        
    }
}
