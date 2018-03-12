package view;

import control.PaneControl;
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
        PaneControl.animation();

        Scene scene = new Scene(borderPane);

        stage.setScene(scene);
        //stage.setResizable(false);
        stage.setTitle("cellular automata");
        stage.show();
    }
}
