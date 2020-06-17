/*
    Cree esta clase para tambien usarla en
    la maquina de turing junto con la de ArchivosRutas
*/
package automatapila;

import java.util.Random;

/**
 *
 * @author colin
 */
public class GeneradorCadenas {
    private Random rand;
    private String cad;
    
    public GeneradorCadenas()
    {
        this.rand = new Random();
        this.cad = "";
    }
    
    /*
        Usaria las reglas de produccion
        1)S->0S1
        2)S->01
        Pero solo generaria cadenas validas
        lo cual mejor lo hare aleatoriamente asi pueden ser
        cadenas valiadas y no validas.
    */
    public String generarCadena(int tam)
    {
        this.cad = "";
        int cantCeros = rand.nextInt(tam);
        int cantUnos = tam-cantCeros;
        // ceros
        for(int i = 0; i <cantCeros; i++)
            this.cad +="0";
        // unos
        for(int i = 0; i<cantUnos; i++)
            this.cad += "1";
        
        return this.cad;
    }
}
