package practica4.chess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author colintony
 */
public class Practica4Chess extends Application {
    
    //para iniciar la ventana principal de JAVAFX
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Views/FXMLMain.fxml")); // cargamos nuestra vista
        
        Scene scene = new Scene(root); // cargamos la scene
        // se pone el stage y se muestra al usuario
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
