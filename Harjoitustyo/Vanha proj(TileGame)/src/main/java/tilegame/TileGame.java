package tilegame;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TileGame extends Application {
    
    @Override 
    public void start(Stage window) {
        
        window.setTitle("TILEGAME");
        Label firstIntroduction = new Label("Pelaaja 1 kirjoita nimimerkkisi.");
        TextField p1name = new TextField("");
        Label secondIntroduction = new Label("Pelaaja 2 kirjoita nimimerkkisi.");
        TextField p2name = new TextField("");
        Button startGame = new Button("Start");
        
        GridPane setting = new GridPane();
        
        setting.add(startGame, 0, 0);
        setting.add(firstIntroduction, 0, 2);
        setting.add(p1name, 0, 3);
        setting.add(secondIntroduction, 0, 4);
        setting.add(p2name, 0, 5);
        
        setting.setPrefSize(500, 400);
        setting.setAlignment(Pos.CENTER);
        setting.setHgap(15);
        setting.setVgap(15);
        setting.setPadding(new Insets(20, 20, 20, 20));
        
        Scene firstScene = new Scene(setting);
        
        Label gameBegin = new Label();
        
        StackPane gameBeginning = new StackPane();
        
        gameBeginning.setPrefSize(800, 800);
        gameBeginning.getChildren().add(gameBegin);
        gameBeginning.setAlignment(Pos.TOP_CENTER);
        
        Scene gameScene = new Scene(gameBeginning);
        
        startGame.setOnAction((event) -> {
            String P1 = p1name.textProperty().get();
            String P2 = p2name.textProperty().get();
            gameBegin.setText("Pelaajan "+P1+" vuoro!");
            window.setScene(gameScene);
        });
        
        
        
        window.setScene(firstScene);
        
        window.show();
        
    }
    
    public static void main(String[] args) {
        launch(TileGame.class);
        System.out.println("Worked..");
    }
}
