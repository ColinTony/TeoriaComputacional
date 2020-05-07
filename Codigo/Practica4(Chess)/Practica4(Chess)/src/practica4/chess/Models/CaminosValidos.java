package practica4.chess.Models;

/**
 *
 * @author colin
 * Esta clase sera usada para guardar rutas validas y su index
 */
public class CaminosValidos {
    private String caminoValido;
    private int indexCaminos;
    
    // constructor
    public CaminosValidos() {
    }
    
    // getters and setters
    public String getCaminoValido() {
        return caminoValido;
    }

    public void setCaminoValido(String caminoValido) {
        this.caminoValido = caminoValido;
    }

    public int getIndexCaminos() {
        return indexCaminos;
    }

    public void setIndexCaminos(int indexCaminos) {
        this.indexCaminos = indexCaminos;
    }
}
