package practica4.chess.Models;

/**
 *
 * @author colin
 * Esta clase va a registar el estado actual de un automata
 * teniendo como valroes el inicio, anterior y saber si es un estado valido
 */
public class EstadoActual {
    private int estadoActual;
    private boolean isValida;
    private int estadoValido;
    
    public EstadoActual(int estadoActual,int estadoValido)
    {
        this.isValida = false;
        this.estadoActual = estadoActual;
        this.estadoValido = estadoValido;
    }

    public int getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(int estadoActual) {
        this.estadoActual = estadoActual;
    }

    public boolean isIsValida() {
        return isValida;
    }

    public void setIsValida(boolean isValida) {
        this.isValida = isValida;
    }

    public int getEstadoValido() {
        return estadoValido;
    }

    public void setEstadoValido(int estadoValido) {
        this.estadoValido = estadoValido;
    }
    
}
