package view;

import control.AnimationControl;
import control.ConsoleControl;
import control.PaneControl;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainFrame extends Application{
    public void start(Stage stage){
        BorderPane borderPane = new BorderPane();

        //get Integral parts(Singleton Pattern)
        CellsPane cellsPane = CellsPane.getCellsPane();
        ConsolePane consolePane = ConsolePane.getConsolePane();

        //layout
        borderPane.setCenter(cellsPane.getCanvas());
        borderPane.setRight(consolePane.getvBox());
        BorderPane.setMargin(borderPane.getRight(), new Insets(0, 20, 0, 0));

        //event
        AnimationControl.animation();
        ConsoleControl.addControlEvent(stage);

        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.setTitle("cellular automata");

        //run
        stage.show();
    }
}
