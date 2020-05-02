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
        this.caminos.add("1");
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
            evaluarCaracter(cadChar);
        }
    }
    private void evaluarCaracter(char caracter) throws IOException
    {
        // solo nos queda determinar el valor de qA para que tome todos los valores
        // que ha tenido en el conjunto.
        this.conjuntosEst = tablaTransicion.funcionTransicion(qA, String.valueOf(caracter));
        
        if(this.conjuntosEst.isMoreOne())
        {
            String cadAux; 
            int limite = this.caminos.size();
            
            // escribinedo los cmainos distintos
            for(int i=0; i<limite; i++)
            {
                cadAux = this.caminos.get(i);
                for(int j = 0; j < this.conjuntosEst.getEstadosQ().size(); j++)
                {
                    if(j>limite)
                        this.caminos.add(cadAux+this.conjuntosEst.getEstadosQ().get(j));
                    else
                        this.caminos.add(j, cadAux+this.conjuntosEst.getEstadosQ().get(j));
                }
            }
        }else{
            // si solo tinene un estado de respuesta solo lo añadimos a la cadena
            
        }
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
        ruta+="]-";
        System.out.print(ruta);
        
        //this.archivoRutas.escribirArchivo(ruta);
    }
    
    // para determinar que camino tomar sin interrumpir al otra piza
    public void imprimirCamino()
    {
        for(int i = 0; i<this.caminos.size(); i++)
        {
            System.out.println(caminos.get(i));
        }
    }
}
