package practica4.chess.Models;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
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
    
    public Pieza(ImageView imagenPieza,int posEstActual) {
        this.imagenPieza = imagenPieza;
        this.posEstActual = posEstActual;
        this.posX = 0;
        this.posY = 0;
    }
    //
    public void moverX(boolean isReverse)
    {
        if(isReverse){
            this.posEstActual--;
            this.posX -= 115;
            this.imagenPieza.setX(this.posX);
        }
        else{
            this.posEstActual++;
            this.posX += 115;
            this.imagenPieza.setX(this.posX);
        }
        this.posEstActual = Math.abs(posEstActual);
    }
    
    public void moverY(boolean isReverse)
    {
        if(isReverse){
            this.posEstActual-=4;
            this.posY -=115;
            this.imagenPieza.setY(this.posY);
        }else{
            this.posEstActual+=4;
            this.posY+=115;
            this.imagenPieza.setY(this.posY);
        }
        this.posEstActual = Math.abs(posEstActual);
    }
    
    public void diagonalArriba(boolean isReverse)
    {
        if(isReverse){
            this.posEstActual+=3;
            this.posX -= 115;
            this.posY += 115;
            this.imagenPieza.setX(this.posX);
            this.imagenPieza.setY(this.posY);
        }else
        {
            this.posEstActual-=3;
            this.posX += 115;
            this.posY -= 115;
            this.imagenPieza.setX(this.posX);
            this.imagenPieza.setY(this.posY);
        }        
        this.posEstActual = Math.abs(posEstActual);
    }
    public void diagonalAbajo(boolean isReverse)
    {
        if(isReverse)
        {
            this.moverX(true);
            this.moverY(true);
        }else
        {
            this.moverX(false);
            this.moverY(false);
        }
        this.posEstActual = Math.abs(posEstActual);
    }
    // restamos la posicion actual con la nueva y dependiendo el valor
    // es el movimiento que haremos el movimiento de la pieza
    public void moverPieza(int posNueva)
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
    
    /*
    // funciones de movimiento
    public void moverX(boolean izq) throws InterruptedException
    {
        AudioClip audio = new AudioClip(getClass().getResource("/practica4/chess/Views/Assets/sounds/moverP.aiff").toString());
        audio.play();
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1500), this.imagenPieza);
        if(izq)
            translateTransition.setByX(-110);
        else
            translateTransition.setByX(+110);
        
        translateTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(izq)
                    posActualX--;
                else
                    posActualX++;
            }
        });
        translateTransition.play();
    }
    
    public void moverY(boolean abj) throws InterruptedException
    {
        AudioClip audio = new AudioClip(getClass().getResource("/practica4/chess/Views/Assets/sounds/moverP.aiff").toString());
        audio.play();
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1500), this.imagenPieza);
        if(abj)
            translateTransition.setByY(-110);
        else
            translateTransition.setByY(+110);
        
        translateTransition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               if(abj)
                   posActualY--;
               else
                   posActualY++;
            }
        });
        translateTransition.play();
        
    }
    
    */
}
