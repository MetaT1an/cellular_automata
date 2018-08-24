package control;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import model.Cell;
import view.CellsPane;
import view.ConsolePane;

public class AnimationControl {

    private AnimationControl(){}
    private static Cell cell = Cell.getCells();
    private static CellsPane cellsPane = CellsPane.getCellsPane();
    private static ConsolePane consolePane = ConsolePane.getConsolePane();

    public static void animation(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(240), event ->
        {
            cell.scan();
            PaneControl.draw();
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);

        consolePane.getButtons(1).setOnAction(event -> timeline.pause());
        consolePane.getButtons(2).setOnAction(event -> timeline.play());
    }
}
