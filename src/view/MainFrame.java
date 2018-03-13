package view;

import control.AnimationControl;
import control.ConsoleControl;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainFrame extends Application{
    public void start(Stage stage){
        BorderPane borderPane = new BorderPane();

        CellsPane cellsPane = CellsPane.getCellsPane();
        ConsolePane consolePane = ConsolePane.getConsolePane();

        borderPane.setCenter(cellsPane.getCanvas());
        borderPane.setRight(consolePane.getGridPane());
        BorderPane.setMargin(borderPane.getRight(), new Insets(0, 20, 0, 0));

        AnimationControl.animation();
        ConsoleControl.addSetEvent();

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setTitle("cellular automata");
        stage.show();
    }
}
