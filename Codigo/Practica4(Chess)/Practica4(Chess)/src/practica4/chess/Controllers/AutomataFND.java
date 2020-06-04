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
 * Esta es la clase mas importante
 * ya que lleva el algoritmo del calculo de las rutas
 * usando la tabla y funcion de transicion.
 */
public class AutomataFND {
    private String cadena;
    private TablaTR tablaTransicion;
    private EstadoActual qA;
    private Estados conjuntosEst;
    private ArchivoRutas archivoRutas;
    private ArchivoRutas archivoRutasValidas;
    private ArrayList<String> caminos;
    private CaminosValidos caminoValido;
    private ArrayList<CaminosValidos> caminosValidos;
    
    // constructor
    // se debe inicializar con un estado actual, y su estado valido
    // tambien necesitamos el nombre del archivo para guardar las rutas
    // como parametro final es la cadena a evaluar.
    public AutomataFND(int estadoActual,int estadoValido, String nameArchivo,String cadena) throws IOException
    {
        this.caminos = new ArrayList<String>();
        this.caminosValidos = new ArrayList<CaminosValidos>();
        this.qA = new EstadoActual(estadoActual,estadoValido);
        this.caminos.add("q"+this.qA.getEstadoActual());
        this.tablaTransicion = new TablaTR();
        this.archivoRutas = new ArchivoRutas(nameArchivo);
        this.archivoRutasValidas = new ArchivoRutas(this.archivoRutas.getNameArchivo()+"Validas");
        this.conjuntosEst = new Estados();
        this.cadena = cadena;
    }
    
    // Algoritmo para evaluar la cadena
    // esta funcion recorre la cadena caracter por caracter
    // cada caracter lo manda a evaluarCaracter
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
    // En esta funcion recibimos el contador del for de evaluarCadena
    // lo necesitamos para saber si es la primera evaluacion o no
    // si es la primera evaluacion, no hay conjuntos de estados que puede tomar
    // solo se evalua directamente el primer caracter con el estado inicial
    private void evaluarCaracter(char caracter,int i) throws IOException
    {
        int caminosCount= this.caminos.size(); // se obtiene el tamaño de los caminos
        // si no lo hacemos asi se añadiran mas caminos y el size ira creciendo en el for
        // por eso usamos una variable con el tamaño.
        
        // La primera evaluacion es directa ya no tenemos conjuntos a los que
        // podamos ir.
        if(i == 0)
        {
            this.conjuntosEst = tablaTransicion.funcionTransicion(qA, String.valueOf(caracter));
            escribirCaminos(i);
        }else
        {
            for(int j = 0; j<caminosCount; j++)
            {
                // pasamos entre el conjunto de los estados obtenidos
                // debemos obtenerlos de los caminos que ya tenemos es el la ultima posicion
                // donde se guardara el estado que vamos a tomar.
                
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
                
                // escribimos los caminos
                escribirCaminos(j);
            }
        }
    }
    // para escribir el camino tomamos el punto de referencia 
    // que en realidad es el index del camino en el que vamos
    private void escribirCaminos(int puntoReferencia)
    {
        String cadAux;
        cadAux = this.caminos.get(puntoReferencia); // tomamos el cmaino
        // en posicion 0 siempre sera igual tomar del camino tomado le
        // pegamos el estado de los conjunto de estados
        this.caminos.set(puntoReferencia, cadAux+"->q"+this.conjuntosEst.getEstadosQ().get(0));
        // le vamos agregando el nuevo estado a los caminos. y listo.
        if(this.conjuntosEst.isMoreOne())
            for(int k = 1; k < this.conjuntosEst.getEstadosQ().size(); k++)
                this.caminos.add(cadAux+"->q"+this.conjuntosEst.getEstadosQ().get(k));         
    }
    
    // para guardar las rutas 
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
                this.archivoRutasValidas.escribirArchivo(this.caminos.get(i)+"\n");
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
