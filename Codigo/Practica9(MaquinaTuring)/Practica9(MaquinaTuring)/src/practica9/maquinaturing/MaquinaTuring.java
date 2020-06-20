package practica9.maquinaturing;

import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

/**
 *
 * @author colin
 */
public class MaquinaTuring {
    private String cadena;
    private int pos;
    private Text txtMenos1;
    private Text txtMenos2;
    private Text txtMas1;
    private Text txtMas2;
    private Text txtPosActual;
    private TextArea area;
    private ArchivosRutas archivo;
    private String estado;
    
    private boolean isValida;

    public MaquinaTuring(String cadena, Text txtMenos1, Text txtMenos2, Text txtMas1, Text txtMas2, Text txtPosActual, TextArea area) {
        this.cadena = cadena+"B";
        this.txtMenos1 = txtMenos1;
        this.txtMenos2 = txtMenos2;
        this.txtMas1 = txtMas1;
        this.txtMas2 = txtMas2;
        this.txtPosActual = txtPosActual;
        this.area = area;
        this.pos=0;
        this.isValida = false;
        this.initCinta();
        this.estado = "q0";
    }
    
    private void initCinta()
    {
        this.txtMenos1.setText("B");
        this.txtMenos2.setText("B");
        this.txtMas1.setText(String.valueOf(this.cadena.charAt(pos+1)));
        this.txtMas2.setText(String.valueOf(this.cadena.charAt(pos+2)));
        this.txtPosActual.setText(String.valueOf(this.cadena.charAt(pos)));
        
    }
    
    /*
        Algoritmo para la maquina de turing
        vamos terminando primero el estado ene l que estamos
        y dependiendo de cual es el caracter qye lee actuamos en 
        los cambios y movimiento de la maquina de turing
    */
    public boolean iniciarMaquina() throws InterruptedException
    {
        boolean procesando=true;
        while(procesando)
        {
            switch(this.estado)
            {
                case "q0":
                    switch(this.cadena.charAt(pos))
                    {
                        case '0':
                            // escribimos
                            this.area.appendText("(q0,0)->(q1,X,R)\n");
                            // (q0,0)->(q1,X,R)
                            this.estado = "q1";
                            this.cadena = this.cadena.replaceFirst("0", "X");
                            // mover a la derecha
                            this.pos++;
                            break;
                        case 'Y':
                            // escribimos
                            this.area.appendText("(q0,Y)->(q1,Y,R)\n");
                            // (q0,Y) -> (q3,Y,R)
                            this.estado = "q3";
                            // el caracter se queda en Y
                            // nos movemos a la derecha
                            this.pos++;
                            break;
                        default:
                            this.area.appendText("("+this.estado+","+this.cadena.charAt(pos)+")\n\n");
                            // (q0,1) -> muere
                            // (q0,X)-> muere
                            // (q0,B) -> muere
                            procesando = false;
                            break;
                    }
                    break;
                case "q1":
                    switch(this.cadena.charAt(pos))
                    {
                        case '0':
                            // escribimos
                            this.area.appendText("(q1,0)->(q1,0,R)\n");
                            // (q1,0)->(q1,0,R)
                            // el estado no cambia ni remplazamos caracteres
                            // solo nos movemos a la derecha
                            this.pos++;
                            break;
                        case '1':
                            this.area.appendText("(q1,1)->(q2,Y,R)\n");
                            // (q1,1) -> (q2,Y,R)
                            // cambiamos estado a q2 remplazamos 1 por Y
                            // y nos movemos a la derecha
                            this.estado = "q2";
                            this.cadena = this.cadena.replaceFirst("1","Y");
                            this.pos--;
                            break;
                        case 'Y':
                            this.area.appendText("(q1,Y)->(q1,Y,R)\n");
                            // (q1,Y) -> (q1,Y,R)
                            // nos quedamos en el mismo estado
                            // no remplazamos la Y solo nos movemos a la der
                            this.pos++;
                            break;
                        default:
                            // (q1,X) -> Muere
                            // (q1,B) -> Muere
                            this.area.appendText("("+this.estado+","+this.cadena.charAt(pos)+")\n\n");
                            procesando = false;
                            break;
                    }
                    break;
                case "q2":
                    switch(this.cadena.charAt(pos))
                    {
                        case '0':
                            this.area.appendText("(q2,0)->(q2,0,L)\n");
                            // (q2,0)->(q2,0,L)
                            // solo nos movemos a la izquierda
                            this.pos--;
                            break;
                        case 'X':
                            this.area.appendText("(q2,X)->(q0,X,R)\n");
                            // (q2,X) -> (q0,X,R)
                            // cambiamos estado a q0
                            // nos movemos a la derecha
                            this.estado = "q0";
                            this.pos++;
                            break;
                        case 'Y':
                            this.area.appendText("(q2,Y)->(q2,Y,L)\n");
                            // (q2,Y) -> (q2,Y,L)
                            // solo nos vamos a mover a la izq
                            this.pos--;
                            
                            break;
                        default:
                            this.area.appendText("("+this.estado+","+this.cadena.charAt(pos)+")\n\n");
                            // (q2,1) -> muere
                            // (q2,B) -> muere
                            procesando = false;
                            break;
                    }
                    break;
                case "q3":
                    switch(this.cadena.charAt(pos))
                    {
                        case 'Y':
                            this.area.appendText("(q3,Y)->(q3,Y,R)\n");
                            //(q3,Y) -> (q3,Y,R)
                            // solo nos movemos a la derecha
                            this.pos++;
                            break;
                        case 'B':
                            this.area.appendText("(q3,B)->(q4,B,R)\n");
                            // (q3,B) -> (q4,B,R)
                            // cambiamos estado. movemos a la derecha
                            this.estado = "q4";
                            this.pos++;
                            break;
                        default:
                            // (q3,0) -> muere
                            // (q3,1) -> muere
                            // (q3,X) -> muere
                            this.area.appendText("("+this.estado+","+this.cadena.charAt(pos)+")\n\n");
                            procesando = false;
                            break;
                    }
                    break;
                case "q4":
                    this.area.appendText("("+this.estado+","+this.cadena.charAt(pos-1)+")\n\n");
                    procesando = false;
                    this.isValida = true;
                default:
                    break;
                 
            }
        }
        return this.isValida;
    }
    
}
