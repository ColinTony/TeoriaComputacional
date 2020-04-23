package practica4.chess.Controllers;

import java.io.IOException;
import practica4.chess.Models.EstadoActual;
import practica4.chess.Models.Estados;
import practica4.chess.Models.TablaTR;

/**
 *
 * @author colin
 */
public class AutomataFND {
    private String cadena;
    private TablaTR tablaTransicion;
    private EstadoActual qA;
    private Estados conjuntosEst;
    private ArchivoRutas archivoRutas;
    
    public AutomataFND(EstadoActual qA, String nameArchivo) throws IOException
    {
        this.qA = qA;
        this.tablaTransicion = new TablaTR();
        this.archivoRutas = new ArchivoRutas("Pruebas");
        this.conjuntosEst = new Estados();
    }
    public void evaluarCadena(String cadena) throws IOException
    {
        this.cadena = cadena;
        // mandar cada caracyer a evaluar el caracter
        for(int i=0; i<this.cadena.toCharArray().length; i++)
        {
            char cadChar = this.cadena.toCharArray()[i];
            evaluarCaracter(cadChar);
        }
    }
    private void evaluarCaracter(char caracter) throws IOException
    {
        this.conjuntosEst = tablaTransicion.funcionTransicion(qA, String.valueOf(caracter));
        mandarRuta();
    }
    private void mandarRuta() throws IOException
    {
         String ruta="[";
        // aqui debemos escribir el algoritmo para todas las rutas
        for(int i = 0; i<this.conjuntosEst.getEstadosQ().size(); i++)
        {
            ruta += "q"+conjuntosEst.getEstadosQ().get(i).toString()+",";
            // para determinar mas rutas debemos analizar el tamaño de los conjuntos
            // debemos revisar que el estado actual tambien cambie dependiendo de la desicion
            // tomada en la ruta seleccionada.
        }
        ruta+="]";
        System.out.println(ruta);
        this.archivoRutas.escribirArchivo(ruta);
    }
}
