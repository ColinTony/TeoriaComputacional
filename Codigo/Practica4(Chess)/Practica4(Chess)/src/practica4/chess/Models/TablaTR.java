package practica4.chess.Models;

import java.util.ArrayList;

/**
 *
 * @author colin
 * En esta clase se guardara la ingormacion de las tablas
 * tendra una funcion donde recibira un estado actual
 * y devolvera el siguiente estado o el conjunto de estados posibles
 */
public class TablaTR {
    private int tablaT [][];
    private ArrayList<Integer> conjunto;
    public TablaTR()
    {
        this.conjunto = new ArrayList<Integer>(2);
        tablaT[0][0] = 5;
        conjunto.add(2);
        conjunto.add(4);
    }
}
