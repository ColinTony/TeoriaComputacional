package practica4.chess.Controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author colin
 * Clase que se dedicara a escribir los archivos de caminos posibles
 */
public class ArchivoRutas {
    private String ruta;
    private String nombreArchivo;
    private String pathCompleto;
    // variables para lectura y escritura
    private File file;
    private FileWriter fw;
    private BufferedWriter bw;
    
    
    // nombre del archivo sin el txt
    public ArchivoRutas(String nombreArchivo) throws IOException
    {
        this.ruta = "./src/practica4/chess/Controllers/txtRutas/";
        this.nombreArchivo = nombreArchivo;
        this.pathCompleto = ruta+nombreArchivo+".txt";
        
        this.file = new File(this.pathCompleto);
        System.out.println(this.file.getPath());
        // si el archivo no existe crearlo
        if(!file.exists())
            file.createNewFile();
    }
    
    public void escribirArchivo(String contenido) throws IOException
    {
        this.fw = new FileWriter(this.file);
        this.bw = new BufferedWriter(fw);
        this.bw.write(contenido);
        this.bw.close();
    }
}
