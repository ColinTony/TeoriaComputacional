package practica4.chess.Controllers;

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
    
    public AutomataFND(EstadoActual qA)
    {
        this.qA = qA;
        this.cadena = "N";
        this.tablaTransicion = new TablaTR();
    }
    public void evaluarCaracter()
    {
        conjuntosEst = tablaTransicion.funcionTransicion(qA, cadena);
        for(int i = 0; i<conjuntosEst.getEstadosQ().size(); i++)
        {
            System.out.println(conjuntosEst.getEstadosQ().get(i));
        }
    }
}
