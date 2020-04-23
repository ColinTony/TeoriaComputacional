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
    public AutomataFND(EstadoActual qA) throws IOException
    {
        this.qA = qA;
        this.cadena = "N";
        this.tablaTransicion = new TablaTR();
        this.archivoRutas = new ArchivoRutas("Prueba");
    }
    
    public void evaluarCaracter() throws IOException
    {
        conjuntosEst = tablaTransicion.funcionTransicion(qA, cadena);
        mandarRuta();
    }
    public void mandarRuta() throws IOException
    {
        // aqui debemos escribir el algoritmo para todas las rutas
    }
}
