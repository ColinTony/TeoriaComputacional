package practica4.chess.Controllers;

import java.io.IOException;
import java.util.ArrayList;
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
    
    public AutomataFND(EstadoActual qA, String nameArchivo,String cadena) throws IOException
    {
        this.caminos = new ArrayList<String>();
        this.caminos.add("q1");
        this.qA = qA;
        this.tablaTransicion = new TablaTR();
        this.archivoRutas = new ArchivoRutas("Pruebas");
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
            mandarRuta();
            escribirCaminos(i);
        }else
        {
            for(int j = 0; j<caminosCount; j++)
            {
                // pasamos entre los estados obtenidoss
                // debemos obtenerlos de los caminos. Es el la ultima posicion
                // convertirmos a un entero para pasarlo al estado actual
                
                String SestadoAux = this.caminos.get(j).substring(this.caminos.get(j).length()-1);
                this.qA.setEstadoActual(Integer.valueOf(SestadoAux));
                this.conjuntosEst = tablaTransicion.funcionTransicion(qA, String.valueOf(caracter));
                mandarRuta();
                escribirCaminos(j);
            }
        }
    }
    private void escribirCaminos(int puntoReferencia)
    {
        String cadAux;
        cadAux = this.caminos.get(puntoReferencia);
        
        this.caminos.set(puntoReferencia, cadAux+this.conjuntosEst.getEstadosQ().get(0));
        
        if(this.conjuntosEst.isMoreOne())
            for(int k = 1; k < this.conjuntosEst.getEstadosQ().size(); k++)
                this.caminos.add(cadAux+this.conjuntosEst.getEstadosQ().get(k));
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
        ruta+="],";
        //System.out.print(ruta);
        
        this.archivoRutas.escribirArchivo(ruta);
    }
    
    // para determinar que camino tomar sin interrumpir al otra piza
    public void guardarRutas() throws IOException
    {
        for(int i = 0; i<this.caminos.size(); i++)
            this.archivoRutas.escribirArchivo(caminos.get(i)+"\n");
    }
}
