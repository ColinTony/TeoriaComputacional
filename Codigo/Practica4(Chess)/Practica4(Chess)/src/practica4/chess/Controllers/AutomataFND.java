package practica4.chess.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.TextArea;
import practica4.chess.Models.CaminosValidos;
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
    private ArrayList<String> caminos;
    private CaminosValidos caminoValido;
    private ArrayList<CaminosValidos> caminosValidos;
    
    public AutomataFND(int estadoActual,int estadoValido, String nameArchivo,String cadena) throws IOException
    {
        this.caminos = new ArrayList<String>();
        this.caminosValidos = new ArrayList<CaminosValidos>();
        this.qA = new EstadoActual(estadoActual,estadoValido);
        this.caminos.add("q"+this.qA.getEstadoActual());
        this.tablaTransicion = new TablaTR();
        this.archivoRutas = new ArchivoRutas(nameArchivo);
        this.conjuntosEst = new Estados();
        this.cadena = cadena;
    }
    
    public void evaluarCadena() throws IOException
    {
        this.cadena = cadena;
        // mandar cada caracyer a evaluar el caracter
        for(int i=0; i<this.cadena.toCharArray().length; i++)
        {
            char cadChar = this.cadena.toCharArray()[i];
            evaluarCaracter(cadChar,i);
        }
    }
    private void evaluarCaracter(char caracter,int i) throws IOException
    {
        // solo nos queda determinar el valor de qA para que tome todos los valores
        // que ha tenido en el conjunto.
        int caminosCount= this.caminos.size();
        if(i == 0)
        {
            this.conjuntosEst = tablaTransicion.funcionTransicion(qA, String.valueOf(caracter));
            //mandarRuta();
            escribirCaminos(i);
        }else
        {
            for(int j = 0; j<caminosCount; j++)
            {
                // pasamos entre los estados obtenidoss
                // debemos obtenerlos de los caminos. Es el la ultima posicion
                // convertirmos a un entero para pasarlo al estado actual
                String SestadoAux = "";
                // determinamos si es un caracter de dos cifras el ultimo estado del camino
                if(Character.isDigit(this.caminos.get(j).charAt(this.caminos.get(j).length()-2)))
                    SestadoAux = this.caminos.get(j).substring(this.caminos.get(j).length()-2);
                else
                    SestadoAux = this.caminos.get(j).substring(this.caminos.get(j).length()-1);
                // se lo mandamos como nuevo estado actual
                this.qA.setEstadoActual(Integer.valueOf(SestadoAux));
                this.conjuntosEst = tablaTransicion.funcionTransicion(qA, String.valueOf(caracter));
                //mandarRuta();
                escribirCaminos(j);
            }
        }
    }
    private void escribirCaminos(int puntoReferencia)
    {
        String cadAux;
        cadAux = this.caminos.get(puntoReferencia);

        this.caminos.set(puntoReferencia, cadAux+"->q"+this.conjuntosEst.getEstadosQ().get(0));
        if(this.conjuntosEst.isMoreOne())
            for(int k = 1; k < this.conjuntosEst.getEstadosQ().size(); k++)
                this.caminos.add(cadAux+"->q"+this.conjuntosEst.getEstadosQ().get(k));
                
    }
    
    // para determinar que camino tomar sin interrumpir al otra piza
    public void guardarRutas(TextArea areaText) throws IOException
    {
        areaText.clear(); // limpiamos el textArea
        this.archivoRutas.borrarContenido(); // borramos tambien el contenido del archivo
        this.caminosValidos.clear();
        for(int i = 0; i<this.caminos.size(); i++){
            // determinamos los caracteres del estado final
            if(Character.isDigit(this.caminos.get(i).charAt(this.caminos.get(i).length()-2)))
                this.qA.setIsValida(this.caminos.get(i).substring(this.caminos.get(i).length()-2).equals(String.valueOf(this.qA.getEstadoValido())));
            else
                this.qA.setIsValida(this.caminos.get(i).substring(this.caminos.get(i).length()-1).equals(String.valueOf(this.qA.getEstadoValido())));
            
            if(this.qA.isIsValida())
            {
                // guardamos el indice del camino correcto
                this.caminoValido = new CaminosValidos();
                this.caminoValido.setIndexCaminos(i);
                this.caminoValido.setCaminoValido(this.caminos.get(i));
                this.caminosValidos.add(this.caminoValido);
                this.archivoRutas.escribirArchivo(caminos.get(i)+"*"+"\n");
                areaText.appendText(this.caminos.get(i)+"*"+"\n");
            }else
            {
                this.archivoRutas.escribirArchivo(caminos.get(i)+"\n");
                areaText.appendText(this.caminos.get(i)+"\n");
            }
        }
            
    }
    
    // getters para los caminos

    public ArrayList<CaminosValidos> getCaminosValidos() {
        return caminosValidos;
    }
    
}
