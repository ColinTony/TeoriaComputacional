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
    private ArrayList<Integer> posY;
    private ArrayList<Character> posX;
    private int posActualX;
    private int posActualY;
    private String posCompleta;
    
    public Pieza(ImageView imagenPieza) {
        this.imagenPieza = imagenPieza;
        this.posX = new ArrayList<>(4);
        this.posY = new ArrayList<>(4);
        this.posY.add(1);
        this.posY.add(2);
        this.posY.add(3);
        this.posY.add(4);
        
        this.posX.add('A');
        this.posX.add('B');
        this.posX.add('C');
        this.posX.add('D');
        
        this.posActualX = 0;
        this.posActualY = 0;
        
        this.posCompleta =""+this.posX.get(posActualX)+""+ this.posY.get(posActualY).toString().trim();
       
        this.imagenPieza.setX(this.imagenPieza.getX());
        this.imagenPieza.setY(this.imagenPieza.getY());
    }
    public String getPosCompleta()
    {
        this.posCompleta =""+this.posX.get(posActualX)+""+ this.posY.get(posActualY).toString().trim();
        return this.posCompleta;
    }
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
                System.out.println(getPosCompleta());
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
}
