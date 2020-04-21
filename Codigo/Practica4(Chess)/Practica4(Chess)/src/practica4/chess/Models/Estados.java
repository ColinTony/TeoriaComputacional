package practica4.chess.Models;

import java.util.ArrayList;

/**
 *
 * @author colin
 * Este es un objeto Estado que determinara el
 * valor del estado o valor del conjunto de estados
 */
public class Estados {
    private ArrayList<Integer> estadosQ;
    
    public Estados()
    {
        this.estadosQ = new ArrayList<>();
    }

    public ArrayList<Integer> getEstadosQ() {
        return estadosQ;
    }

    public void setEstadosQ(ArrayList<Integer> estadosQ) {
        this.estadosQ = estadosQ;
    }
}
