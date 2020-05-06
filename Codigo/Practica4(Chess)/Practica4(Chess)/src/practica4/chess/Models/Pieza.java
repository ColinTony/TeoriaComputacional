package practica4.chess.Models;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

/**
 *
 * @author colin
 */
public class Pieza {
   
    private ImageView imagenPieza;
    private int posEstActual;
    private int posX;
    private int posY;
    private int posAnteriorX;
    private int posAntoerioY;
    private SequentialTransition animSecuencia;
    
    public Pieza(ImageView imagenPieza,int posEstActual) {
        this.imagenPieza = imagenPieza;
        this.posEstActual = posEstActual;
        this.posX = 0;
        this.posY = 0;
        this.posAnteriorX = 0;
        this.posAntoerioY = 0;
        
        this.animSecuencia = new SequentialTransition();
    }
    //
    public void moverX(boolean isReverse) throws InterruptedException
    {
        if(isReverse){
            this.posEstActual--;
            this.posAnteriorX = posX;
            this.posX -= 115;
            this.addAnim(posAnteriorX, posX);
        }
        else{
            this.posEstActual++;
            this.posAnteriorX = this.posX;
            this.posX += 115;
            this.addAnim(this.posAnteriorX, this.posX);
        }
        this.posEstActual = Math.abs(posEstActual);
    }
    
    public void moverY(boolean isReverse) throws InterruptedException
    {
        if(isReverse){
            this.posEstActual-=4;
            this.posAntoerioY = this.posY;
            this.posY -=115;
            this.addAnimY(this.posAntoerioY, this.posY);
        }else{
            this.posEstActual+=4;
            this.posAntoerioY = this.posY;
            this.posY+=115;
            this.addAnimY(this.posAntoerioY, this.posY);
        }
        this.posEstActual = Math.abs(posEstActual);
    }
    
    public void diagonalArriba(boolean isReverse) throws InterruptedException
    {
        if(isReverse){
            this.posEstActual+=3;
            this.posAnteriorX = this.posX;
            this.posAntoerioY = this.posY;
            this.posX -= 115;
            this.posY += 115;
            this.addAnim(posAnteriorX, posX, posAntoerioY, posY);
        }else
        {
            this.posEstActual-=3;
            this.posAnteriorX = this.posX;
            this.posAntoerioY = this.posY;
            this.posX += 115;
            this.posY -= 115;
            this.addAnim(posAnteriorX, posX, posAntoerioY, posY);
        }        
        this.posEstActual = Math.abs(posEstActual);
    }
    
    public void diagonalAbajo(boolean isReverse) throws InterruptedException
    {
        if(isReverse)
        {
            this.posEstActual-=5;
            this.posAnteriorX = this.posX;
            this.posAntoerioY = this.posY;
            this.posX -= 115;
            this.posY -= 115;
            this.addAnim(posAnteriorX, posX, posAntoerioY, posY);
        }else
        {
            this.posEstActual+=5;
            this.posAnteriorX = this.posX;
            this.posAntoerioY = this.posY;
            this.posX +=115;
            this.posY +=115;
            this.addAnim(posAnteriorX, posX, posAntoerioY, posY);
        }
        this.posEstActual = Math.abs(posEstActual);
    }
    // restamos la posicion actual con la nueva y dependiendo el valor
    // es el movimiento que haremos el movimiento de la pieza
    public void moverPieza(int posNueva) throws InterruptedException
    {
       int movimiento = this.posEstActual-posNueva;
       switch(movimiento)
       {
            case 5:
                // si la diferencia es 5 es un movimiento diagonal abajo hacia atras
                this.diagonalAbajo(true);
                break;
            case 4:
                // si la diferencia es 4 es solo subir en el tablero
                this.moverY(true);
                break;
            case 3:
                // si la diferencia es 3 es diagonal arriba
                this.diagonalArriba(false);
                break;
            case 1:
                // si la diferencia es uno entonces nos regresamos una posicion
                this.moverX(true);
                break;
            case -1:
                // menos uno es movernos en X hacia delante
                this.moverX(false);
                break;
            case -3:
                // diagonal arriba hacia atras
                this.diagonalArriba(true);
                break;
            case -4:
                // es bajar en el tablero
                this.moverY(false);
                break;
            case -5:
                // diagonal abajo 
                this.diagonalAbajo(false);
                break;
            default:
                // se queda en el mismo lugar
                break;
       }
       System.out.println(this.posEstActual);
    }
    
    private void addAnim(int posInicial, int posFinal) throws InterruptedException
    {
        // audio de movimiento
        //AudioClip audio = new AudioClip(getClass().getResource("/practica4/chess/Views/Assets/sounds/moverP.aiff").toString());
        //audio.play();
        
        TranslateTransition movimiento = new TranslateTransition(Duration.millis(1700), imagenPieza);
        movimiento.setFromX(posInicial);
        movimiento.setToX(posFinal);
        
        this.animSecuencia.getChildren().add(movimiento);
    }
    
    private void addAnimY(int posInicial, int posFinal)
    {
        TranslateTransition movimiento = new TranslateTransition(Duration.millis(1700), imagenPieza);
        movimiento.setFromY(posInicial);
        movimiento.setToY(posFinal);
        this.animSecuencia.getChildren().add(movimiento);
    }
    private void addAnim(int posInicialX, int posFinalX,int posInicialY, int posFinalY) throws InterruptedException
    {
        TranslateTransition movimiento = new TranslateTransition(Duration.millis(1700), imagenPieza);
        movimiento.setFromX(posInicialX);
        movimiento.setToX(posFinalX);
        movimiento.setFromY(posInicialY);
        movimiento.setToY(posFinalY);
        
        this.animSecuencia.getChildren().add(movimiento);
    }
    public void cargarAnimacion(String rutaElegida) throws InterruptedException
    {
        this.animSecuencia = new SequentialTransition();
        // se escribe el codigo para animar la ruta elegida
        System.out.println(rutaElegida);
        rutaElegida = rutaElegida.substring(5);
        rutaElegida = rutaElegida.replace(">", "");
        rutaElegida = rutaElegida.replace("q", "");
        System.out.println(rutaElegida);
        String valor = "";
        
        for(int i=0; i<rutaElegida.length(); i++)
        {
            if(rutaElegida.charAt(i) == '-'){
                moverPieza(Integer.valueOf(valor));
                valor = "";
            }else
                valor += rutaElegida.charAt(i);
        }
        // para el ultimo digito encontrado
        moverPieza(Integer.valueOf(valor));
    }
    
    public void iniciarAnimacion()
    {
        this.animSecuencia.play();
    }
    
    public void reiniciar()
    {
        this.animSecuencia = new SequentialTransition();
        TranslateTransition movimiento = new TranslateTransition(Duration.millis(900), imagenPieza);
        movimiento.setFromX(this.posX);
        movimiento.setToX(0);
        movimiento.setFromY(this.posY);
        movimiento.setToY(0);
        
        this.animSecuencia.getChildren().add(movimiento);
        this.animSecuencia.play();
        
    }

    public SequentialTransition getAnimSecuencia() {
        return animSecuencia;
    }
    
}
