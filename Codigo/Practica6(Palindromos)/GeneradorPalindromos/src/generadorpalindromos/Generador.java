package generadorpalindromos;

import java.io.IOException;
import java.util.Random;
import javafx.scene.control.TextArea;

/**
 *
 * @author colin
 */
public class Generador {
    // Esta clase es la que hace la generacion del palindromo
    private int tamPal;
    private int cantPals;
    private TextArea areaEstados;
    private TextArea areaPalindromos;
    private ArchivoRutas archivoEstados;
    private ArchivoRutas archivoPalindromos;
    private Random rand;
    private String palindromo;

    public Generador(int tamPal, int cantPals, TextArea areaEstados, TextArea areaPalindromos) throws IOException {
        this.tamPal = tamPal;
        this.cantPals = cantPals;
        this.areaEstados = areaEstados;
        this.areaPalindromos = areaPalindromos;
    }
    public Generador(int cantPals, TextArea areaEstados, TextArea areaPalindromos) throws IOException {
        this.cantPals = cantPals;
        this.areaEstados = areaEstados;
        this.areaPalindromos = areaPalindromos;
        this.tamPal = rand.nextInt(11)+1; // genear automaticamente el tam de cadena
    }
    /*
        Comenzaremos a generar
    */
    public void generar(int cantPals,int tam) throws IOException
    {
        this.archivoEstados = new ArchivoRutas("estados");
        this.archivoPalindromos = new ArchivoRutas("palindromos");
        boolean prodFiveFour; // si es verdadero tomara la regla 5 en otro caso la 4
        this.cantPals = cantPals;
        this.tamPal =tam;
        
        for(int j = 0; j<this.cantPals; j++){
            this.palindromo = "P"; // (0)-> P
            this.archivoEstados.escribirArchivo("(0)->P. \n");
            this.areaEstados.appendText("(0)->P. \n");
            this.rand = new Random();
            // se toma el tamaño menos uno para al final 
            // tomar una de las reglas 1,2 o 3
            for(int i = 0; i<this.tamPal; i++)
            {
                prodFiveFour = this.rand.nextBoolean();
                if(prodFiveFour)
                    reglasProd(5);
                else
                    reglasProd(4);
                // tomamos el nuevo tamaño de la cadena
                i = this.palindromo.length();
            }
            // cerramos nuestro palindromo
            int cerrar = rand.nextInt(3)+1;
            reglasProd(cerrar);
            System.out.println(cerrar);
            this.areaEstados.appendText("Se creó la cadena:"+this.palindromo+"\n");
            this.archivoEstados.escribirArchivo("Se creó la cadena:"+this.palindromo+"\n");
            this.archivoPalindromos.escribirArchivo(this.palindromo+"\n");
            this.areaPalindromos.appendText(this.palindromo+"\n");
        }
    }
    public void reiniciarTodo() throws IOException
    {
        this.areaEstados.clear();
        this.areaPalindromos.clear();
        this.archivoEstados.borrarContenido();
        this.archivoPalindromos.borrarContenido();
    }
    private void reglasProd(int regla) throws IOException
    {
        switch(regla)
        {
            case 1:
                // regla  P -> e
                // añadimos el texto a los arhcivos
                this.palindromo=this.palindromo.replace("P", "e");
                this.archivoEstados.escribirArchivo("("+regla+")->"+this.palindromo+". \n");
                this.areaEstados.appendText("("+regla+")->"+this.palindromo+". \n");
                this.archivoEstados.escribirArchivo("Tenemos:"+this.palindromo+"Quitamos la e. \n");
                this.palindromo = this.palindromo.replace("e","");
                
                break;
            case 2:
                // regla P -> 0
                this.palindromo = this.palindromo.replace("P", "0");
                this.archivoEstados.escribirArchivo("("+regla+")->"+this.palindromo+".\n");
                this.areaEstados.appendText("("+regla+")->"+this.palindromo+".\n");
               
                break;
            case 3:
                // regla P -> 1
                this.palindromo = this.palindromo.replace("P", "1");
                this.archivoEstados.escribirArchivo("("+regla+")->"+this.palindromo+".\n");
                this.areaEstados.appendText("("+regla+")->"+this.palindromo+".\n");
                break;
            case 4:
                // regla P -> 0P0
                this.archivoEstados.escribirArchivo("("+regla+")->0"+this.palindromo+"0.\n");
                this.areaEstados.appendText("("+regla+")->0"+this.palindromo+"0.\n");
                this.palindromo = "0"+this.palindromo+"0";
                break;
            case 5:
                // regla P -> 1P1
                this.archivoEstados.escribirArchivo("("+regla+")->1"+this.palindromo+"1.\n");
                this.areaEstados.appendText("("+regla+")->1"+this.palindromo+"1.\n");
                this.palindromo = "1"+this.palindromo+"1";
                break;
            default:
                // ninguna regla
                
                break;
             
        }
    }
}
