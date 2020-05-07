package practica4.chess.Models;

import java.util.ArrayList;

/**
 *
 * @author colin
 * En esta clase se guardara la informacion de la tabla de transicion
 * tendra su funcion transicion donde recibira un estado actual
 * y devolvera el siguiente estado o el conjunto de estados posibles
 */
public class TablaTR {
    private ArrayList<ArrayList<Estados>> estadosTR;
    private Estados conjunto;
    
    // Este constructor lo que hace es construir la tabla de
    // transicion. Es una lista de listas. La tabla de transicion
    // se realizo con el tablero de 4x4.
    public TablaTR()
    {
        
        // constructor
        this.estadosTR = new ArrayList<>();
        this.conjunto = new Estados();
        
        // Colummna de la N (Negro)
        // q1 -> N -> q2,q5
        this.conjunto.getEstadosQ().add(2); // recordar que en la tabla es q1 y debemos restarle uno por el array
        this.conjunto.getEstadosQ().add(5);
        this.estadosTR.add(new ArrayList<Estados>());
        this.estadosTR.get(0).add(conjunto); // la columna N esta en el index 0
        
        // q2 -> N -> q5,q7
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(5);
        this.conjunto.getEstadosQ().add(7);
        this.estadosTR.get(0).add(conjunto);
        
        // q3 -> N -> q2,q4,q7
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(2);
        this.conjunto.getEstadosQ().add(4);
        this.conjunto.getEstadosQ().add(7);
        this.estadosTR.get(0).add(conjunto);
        
        //q4 -> N -> q7
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(7);
        this.estadosTR.get(0).add(conjunto);
        
        // q5 -> N ->q2,q10
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(2);
        this.conjunto.getEstadosQ().add(10);
        this.estadosTR.get(0).add(conjunto);
        
        // q6 -> N -> q2,q5,q7,q10
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(2);
        this.conjunto.getEstadosQ().add(5);
        this.conjunto.getEstadosQ().add(7);
        this.conjunto.getEstadosQ().add(10);
        this.estadosTR.get(0).add(conjunto);
        
        // q7 -> N -> q2,q4,q10,q12
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(2);
        this.conjunto.getEstadosQ().add(4);
        this.conjunto.getEstadosQ().add(10);
        this.conjunto.getEstadosQ().add(12);
        this.estadosTR.get(0).add(conjunto);
        
        // q8 -> N -> q4,q7,q12
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(4);
        this.conjunto.getEstadosQ().add(7);
        this.conjunto.getEstadosQ().add(12);
        this.estadosTR.get(0).add(conjunto);
        
        // q9 -> N -> q5,q10,q13
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(5);
        this.conjunto.getEstadosQ().add(10);
        this.conjunto.getEstadosQ().add(13);
        this.estadosTR.get(0).add(conjunto);
        
        // q10->N->q5,q7,q13,q15
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(5);
        this.conjunto.getEstadosQ().add(7);
        this.conjunto.getEstadosQ().add(13);
        this.conjunto.getEstadosQ().add(15);
        this.estadosTR.get(0).add(conjunto);
        // q11->N->q7,q10,q12,q15
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(7);
        this.conjunto.getEstadosQ().add(10);
        this.conjunto.getEstadosQ().add(12);
        this.conjunto.getEstadosQ().add(15);
        this.estadosTR.get(0).add(conjunto);
        // q12->N->q7,q15
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(7);
        this.conjunto.getEstadosQ().add(15);
        this.estadosTR.get(0).add(conjunto);
        // q13->N->q10
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(10);
        this.estadosTR.get(0).add(conjunto);
        // q14->N->q10,q13,q15
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(10);
        this.conjunto.getEstadosQ().add(13);
        this.conjunto.getEstadosQ().add(15);
        this.estadosTR.get(0).add(conjunto);
        // q15->N->q10,q12
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(10);
        this.conjunto.getEstadosQ().add(12);
        this.estadosTR.get(0).add(conjunto);
        // q16->N->q12,q15
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(12);
        this.conjunto.getEstadosQ().add(15);
        this.estadosTR.get(0).add(conjunto);
        
       
        // Columna de B ( blanco )
        // q1 - > B -> q6
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(6);
        this.estadosTR.get(1).add(conjunto);
        
        //q2->B ->q1,q3,q6
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(1);
        this.conjunto.getEstadosQ().add(3);
        this.conjunto.getEstadosQ().add(6);
        this.estadosTR.get(1).add(conjunto);
        
        // q3->B->q6,q8
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(6);
        this.conjunto.getEstadosQ().add(8);
        this.estadosTR.get(1).add(conjunto);
        
        // q4 -> B ->q3,q8
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(3);
        this.conjunto.getEstadosQ().add(8);
        this.estadosTR.get(1).add(conjunto);
        
        // q5 -> B ->q1,q6,q9
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(1);
        this.conjunto.getEstadosQ().add(6);
        this.conjunto.getEstadosQ().add(9);
        this.estadosTR.get(1).add(conjunto);
        
        // q6 -> B -> q1,q3,q9,q11     
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(1);
        this.conjunto.getEstadosQ().add(3);
        this.conjunto.getEstadosQ().add(9);
        this.conjunto.getEstadosQ().add(11);
        this.estadosTR.get(1).add(conjunto);
        
        // q7-> B -> q3,q6,q8,q11    
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(3);
        this.conjunto.getEstadosQ().add(6);
        this.conjunto.getEstadosQ().add(8);
        this.conjunto.getEstadosQ().add(11);
        this.estadosTR.get(1).add(conjunto);
        
        // q8 -> B -> q3,q11
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(3);
        this.conjunto.getEstadosQ().add(11);
        this.estadosTR.get(1).add(conjunto);
        
        // q9 -> B -> q6,q14      
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(6);
        this.conjunto.getEstadosQ().add(14);
        this.estadosTR.get(1).add(conjunto);
        
        //q10->B->q6,q9,q11,q14
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(6);
        this.conjunto.getEstadosQ().add(9);
        this.conjunto.getEstadosQ().add(11);
        this.conjunto.getEstadosQ().add(14);
        this.estadosTR.get(1).add(conjunto);
        //q11->B->q6,q8,q14,q16
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(6);
        this.conjunto.getEstadosQ().add(8);
        this.conjunto.getEstadosQ().add(14);
        this.conjunto.getEstadosQ().add(16);
        this.estadosTR.get(1).add(conjunto);
        //q12->B->q8,q11,q16
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(8);
        this.conjunto.getEstadosQ().add(11);
        this.conjunto.getEstadosQ().add(16);
        this.estadosTR.get(1).add(conjunto);
        //q13->B->q9,q14
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(9);
        this.conjunto.getEstadosQ().add(14);
        this.estadosTR.get(1).add(conjunto);
        //q14->B->q9,q11
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(9);
        this.conjunto.getEstadosQ().add(11);
        this.estadosTR.get(1).add(conjunto);
        //q15->B->q11,q14,q16
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(11);
        this.conjunto.getEstadosQ().add(14);
        this.conjunto.getEstadosQ().add(16);
        this.estadosTR.get(1).add(conjunto);
        //q16->B->q11
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(11);
        this.estadosTR.get(1).add(conjunto);
    }
    
    // nuestra funcion de transicion lo que hace es recibir un estado actual
    // y una cadena que contiene B o N. La cual la evalua en la tabla de transicion
    // haciendo la interseccion del estado actual con N o B de ahi regresara
    // el conjunto de estados que puede tomar el automata.
    public Estados funcionTransicion(EstadoActual qA,String nOrB)
    {
        // Se recibe un estado actual y se busca en la interseccion 
        // en la tabla de transicion.
        int colu = 0;
        
        // verificamos que sea N
        if(nOrB.equalsIgnoreCase("B"))
            colu = 1;
        
        this.conjunto = this.estadosTR.get(colu).get(qA.getEstadoActual()-1);
        return this.conjunto;
    }
}
