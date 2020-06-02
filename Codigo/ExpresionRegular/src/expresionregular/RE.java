package expresionregular;

import com.jfoenix.controls.JFXTextArea;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author colin
 */
public class RE {
    private Random rand;
    private ArchivoRutas estados;
    private ArchivoRutas cadenas;
    private JFXTextArea areaEstados;
    private JFXTextArea areaCadenas;
    
    /*
        Constructor
    */
    public RE(JFXTextArea estados,JFXTextArea cadenas) throws IOException
    {
        this.rand = new Random();
        this.estados = new ArchivoRutas("estados");
        this.cadenas = new ArchivoRutas("cadenas");
        this.areaCadenas = cadenas;
        this.areaEstados = estados;
    }
    /*
        Generando la cadena en base a la expresion
        regular
    */
    private void generar(int contador) throws IOException
    {
        boolean parteIzq;
        boolean parteDer;
        int numCad = contador+1;
        boolean cerradura;
        int copias;
        String cadena ="";
        
        // determinamos si entramos a la cerradura
        cerradura = this.rand.nextBoolean();
        this.estados.escribirArchivo("Generando la cadena: " + numCad+"\n");
        this.areaEstados.appendText("Generando la cadena :" + numCad+"\n");
        
        if(cerradura)
        {
            // se entra a la parte de la cerradura (0+01)*
            // las copias de la cerradura seran
            copias = rand.nextInt(11)+1; // maximo de copias 1000
            this.areaEstados.appendText("Entramos a la cerradura \n");
            this.estados.escribirArchivo("Entramos a la cerradura \n");
            
            // de la parte izquiereda (0+01)* saber que vamos a añadir a la cadena
            // si es verdarero sera 01 su no solo 0
            parteIzq = rand.nextBoolean();
            // de la parte derecha (e + 1) donde si es verdadero se pondra 1
            // si es falso sera e
            parteDer = rand.nextBoolean();
            if(parteIzq)
            {
                this.estados.escribirArchivo("Valor a escribir 10 -> se haran " + copias + " copias en la cadena concatenandolas\n");
                this.areaEstados.appendText("Valor a escribir 10 -> se haran " + copias + " copias en la cadena concatenandolas\n");
                for(int i=1; i<=copias; i++)
                    cadena += "01";
            }else
            {
                this.estados.escribirArchivo("Valor a escribir 0 -> se haran " + copias + " copias en la cadena concatenandolas\n");
                this.areaEstados.appendText("Valor a escribir 0 -> se haran " + copias + " copias en la cadena concatenandolas\n");
                for(int i=1; i<=copias; i++)
                    cadena += "0";
            }
            // para la parte ( e + 1)
            if(parteDer)
            {
                this.estados.escribirArchivo("Valor a escribir 1 en la cadena.\n");
                this.areaEstados.appendText("Vamos a escribir un 1 en la cadena.\n");
                cadena += "1";
            }else
            {
                this.estados.escribirArchivo("Valor a escribir e, como es vacio no lo pondremos.\n");
                this.areaEstados.appendText("Valor a escribir e, como es vacio no lo pondremos.\n");
            }
        }else
        {
            // no entra a la cerradura
            this.estados.escribirArchivo("No entramos a la cerradura se concidera e. \n");
            this.areaEstados.appendText("No entramos a la cerradura se concidera e. \n");
            parteDer = rand.nextBoolean();
            if(parteDer)
            {
                this.estados.escribirArchivo("Valor a escribir 1 en la cadena. \n");
                this.areaEstados.appendText("Vamos a escribir un 1 en la cadena. \n");
                cadena += "1";
            }else
            {
                this.estados.escribirArchivo("Toca el valor 'e' vacio , no lo pondremos en la cadena.\n");
                this.areaEstados.appendText("Toca el valor 'e' vacio , no lo pondremos en la cadena.\n");
            }
        }
        // colocamos la cadena
        
        if(cadena != "")
        {
            this.cadenas.escribirArchivo(numCad+".-"+cadena+"\n");
            this.areaCadenas.appendText(numCad+".-"+cadena+"\n");
        }else
        {
            this.cadenas.escribirArchivo(numCad+".-e\n");
            this.areaCadenas.appendText(numCad+".-e\n");
        }
    }
    
    public void generar() throws IOException
    {
        for(int i = 0; i<10; i++)
            generar(i);
    }
}
