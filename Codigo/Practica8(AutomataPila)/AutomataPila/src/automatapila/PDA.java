package automatapila;
import java.io.IOException;
import java.util.Stack;
import javafx.scene.control.TextArea;
/**
 *
 * @author colin
 */
public class PDA {
    // aqui estara escrito el codigo para el automata de pila.
    private final String letraG;
    private String estado;
    private String cadena;
    private Stack<String> pila;
    private boolean isValida;
    private ArchivosRutas secuencia;
    private TextArea area;
    
    public PDA(String cadena , TextArea area)
    {
        // constructor
        this.letraG = "\u03B4";
        this.area = area;
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
    boolean empezarEvaluacion() throws IOException
    {
        // metemos la Z0 y nuestro estado es q
        this.pila.push("Z");
        String cadAux = this.cadena;
        this.secuencia = new ArchivosRutas("secuencia");
        
        // Primero verifico que empiece con 0 y termine con 1
        this.area.appendText("\n"+this.letraG+"["+this.estado+" , "+this.cadena+", "+this.pila.toString()+"]\n");
        this.secuencia.escribirArchivo("\n"+this.letraG+"["+this.estado+", "+this.cadena+", "+this.pila.toString()+"]\n");
        
        if(this.cadena.endsWith("1") && this.cadena.startsWith("0"))
        {
            this.cadena += " "; // agregamos el caracter nulo para leerlo
            for(int i=0; i < this.cadena.length(); i++)
            {
                // si leemos un 0
                if(this.cadena.charAt(i) == '0')
                {
                    // checamos que sea estado q, si es un estado f o p 
                    // no seria una cadena valida ya que viene de sacar un 1
                    // o viene de leer el final de la cadena
                    if(this.estado.equals("q"))
                    {
                        
                        this.estado = "q"; // el estado se mantiene en q
                        // hacemos push a la pila con X
                        this.pila.push("X");
                        cadAux = cadAux.replaceFirst("0", ""); // remplzamos el cero por vacio
                        // imprimimos
                        this.imprimirDatos(cadAux);
                    }else
                        break;
                }
                // si leemos un 1
                if(this.cadena.charAt(i) == '1')
                {
                    // verificamos que sea de un estado q o p
                    if(this.estado.equals("q") || this.estado.equals("p"))
                    {
                        // checamos que al hacer pop no sea z
                        if(!this.pila.pop().equals("Z"))
                        {
                            this.estado = "p";
                            cadAux = cadAux.replaceFirst("1", "");
                            // imprimimos
                            this.imprimirDatos(cadAux);
                        }else   // si saca la Z sera una cadena invalida
                            break;
                        
                    }else   // si viene de f la funcion no esta definca
                        break;
                }
                
                // si llega el caracter vacio ya leyo toda la cadena
                if(this.cadena.charAt(i) == ' ')
                {
                    this.estado = "f";
                    // si la pila al inicio tiene la Z
                    if(this.pila.peek().equals("Z") && this.estado.equals("f"))
                    {
                        this.isValida = true;
                        // imprimimos
                        this.imprimirDatos(cadAux);
                    }
                    else // si no es la Z entonces la cadena es invalida
                        break;
                }
            }
        }else
            this.isValida = false;
        
        return this.isValida;
    }
    
    private void imprimirDatos(String datos) throws IOException
    {
        StringBuilder pilaDatos;
        String auxPila = this.pila.toString();
        auxPila = auxPila.replace("[", "");
        auxPila = auxPila.replace("]", "");
        auxPila = auxPila.replaceAll(",", "");
        pilaDatos = new StringBuilder(auxPila);
        pilaDatos = pilaDatos.reverse();
        
        this.area.appendText(this.letraG+"["+this.estado+" , "+datos+", "+pilaDatos+"]\n");
        this.secuencia.escribirArchivo(this.letraG+"["+this.estado+", "+datos+", "+pilaDatos+"]\n");
    }
}
