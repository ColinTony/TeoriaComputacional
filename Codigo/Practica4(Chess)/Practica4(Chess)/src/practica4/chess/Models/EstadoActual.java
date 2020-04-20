package practica4.chess.Models;

/**
 *
 * @author colin
 * Esta clase va a registar el estado actual de un automata
 * teniendo como valroes el inicio, anterior y saber si es un estado valido
 */
public class EstadoActual {
    private int estadoActual;
    private int estadoAnterior;
    private boolean isValida;
    
    public EstadoActual(int estadoActual, int estadoAnterior)
    {
        this.isValida = false;
        this.estadoActual = estadoActual;
        this.estadoAnterior = estadoAnterior;
    }
}
