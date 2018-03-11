package view;

import control.PaneControl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainFrame extends Application{
    public void start(Stage stage){
        BorderPane borderPane = new BorderPane();

        CellsPane cellsPane = CellsPane.getCellsPane();

        borderPane.setCenter(cellsPane.getCanvas());
        PaneControl.animation();

        Scene scene = new Scene(borderPane);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("cellular automata");
        stage.show();
    }
}
