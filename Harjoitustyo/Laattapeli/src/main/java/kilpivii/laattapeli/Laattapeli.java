
package kilpivii.laattapeli;

import javafx.application.Application;
import javafx.stage.Stage;

public class Laattapeli extends Application {
    
   @Override
    public void start(Stage ikkuna) {
        ikkuna.setTitle("TileGame");
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(Laattapeli.class);
        System.out.println("Hello World");
    } 
}
