package practica4.chess.Models;

import java.util.ArrayList;

/**
 *
 * @author colin
 * En esta clase se guardara la ingormacion de las tablas
 * tendra una funcion donde recibira un estado actual
 * y devolvera el siguiente estado o el conjunto de estados posibles
 */
public class TablaTR {
    private ArrayList<ArrayList<Estados>> estadosTR;
    private Estados conjunto;
    
    public TablaTR()
    {
        
        // constructor
        this.estadosTR = new ArrayList<>();
        this.conjunto = new Estados();
        
        // Colummna de la N (Negro)
        // q1 -> N -> q5 -> pos (0)
        this.conjunto.getEstadosQ().add(5); // recordar que en la tabla es q1 y debemos restarle uno por el array
        this.estadosTR.add(new ArrayList<Estados>());
        this.estadosTR.get(0).add(conjunto); // la columna N esta en el index 0
        
        // q2 -> N -> q1,q3,q5 -> pos(1)
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(1);
        this.conjunto.getEstadosQ().add(3);
        this.conjunto.getEstadosQ().add(5);
        this.estadosTR.get(0).add(conjunto);
        // q3 -> N -> q5 - > pos (2)
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(5);
        this.estadosTR.get(0).add(conjunto);
        
        //q4 -> N -> q1,q5,q7 -> pos (3)
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(1);
        this.conjunto.getEstadosQ().add(5);
        this.conjunto.getEstadosQ().add(7);
        this.estadosTR.get(0).add(conjunto);
        
        // q5 -> N ->q1,q3,q7,q9 -> pos (4)
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(1);
        this.conjunto.getEstadosQ().add(3);
        this.conjunto.getEstadosQ().add(7);
        this.conjunto.getEstadosQ().add(9);
        this.estadosTR.get(0).add(conjunto);
        
        // q6 -> N -> q3,q5,q9 -> pos (5)
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(3);
        this.conjunto.getEstadosQ().add(5);
        this.conjunto.getEstadosQ().add(9);
        this.estadosTR.get(0).add(conjunto);
        
        // q7 -> N -> q5 -> pos (6)
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(5);
        this.estadosTR.get(0).add(conjunto);
        
        // q8 -> N -> q7,q5,q9 -> pos (7)
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(7);
        this.conjunto.getEstadosQ().add(5);
        this.conjunto.getEstadosQ().add(9);
        this.estadosTR.get(0).add(conjunto);
        
        // q9 -> N -> q5 -> pos (8)
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(5);
        this.estadosTR.get(0).add(conjunto);
        
        // Columna de B ( blanco )
        // q1 - > B -> q2,q4 -> pos (0)
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(2);
        this.conjunto.getEstadosQ().add(4);
        this.estadosTR.get(1).add(conjunto);
        
        //q2->B -> q4,q6 -> pos(1)
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(4);
        this.conjunto.getEstadosQ().add(6);
        this.estadosTR.get(1).add(conjunto);
        
        // q3->B->q2,q6 -> pos(2)
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(2);
        this.conjunto.getEstadosQ().add(6);
        this.estadosTR.get(1).add(conjunto);
        
        // q4 -> B ->q2,q8 -> pos (3)
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(2);
        this.conjunto.getEstadosQ().add(8);
        this.estadosTR.get(1).add(conjunto);
        
        // q5 -> B ->q2,q4,q6,q8 -> pos(4)
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(2);
        this.conjunto.getEstadosQ().add(4);
        this.conjunto.getEstadosQ().add(6);
        this.conjunto.getEstadosQ().add(8);
        this.estadosTR.get(1).add(conjunto);
        
        // q6 -> B -> q2,q8 -> pos (5)      
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(2);
        this.conjunto.getEstadosQ().add(8);
        this.estadosTR.get(1).add(conjunto);
        
        // q7-> B -> q4,q8 -> pos (6)    
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(4);
        this.conjunto.getEstadosQ().add(8);
        this.estadosTR.get(1).add(conjunto);
        
        // q8 -> B -> q4,q6 -> pos (7)
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(4);
        this.conjunto.getEstadosQ().add(6);
        this.estadosTR.get(1).add(conjunto);
        
        // q9 -> B -> q8,q6 -> pos (8)      
        this.conjunto = new Estados();
        this.estadosTR.add(new ArrayList<Estados>());
        this.conjunto.getEstadosQ().add(6);
        this.conjunto.getEstadosQ().add(8);
        this.estadosTR.get(1).add(conjunto);
    }
    
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
