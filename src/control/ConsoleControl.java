package control;

import javafx.stage.Stage;
import model.Cell;
import view.CellsPane;
import view.ConsolePane;

public class ConsoleControl {
    private ConsoleControl(){}

    private static Cell cell = Cell.getCells();
    private static CellsPane cellsPane= CellsPane.getCellsPane();
    private static ConsolePane consolePane = ConsolePane.getConsolePane();

    public static void addSetEvent(Stage stage){
        consolePane.getButtons(0).setOnAction(event -> {

            //update model part
            Cell.resetArgs(getSize(), getBirthRate());
            cell.resetCells();

            //update view part
            cellsPane.resetCanvas();
            PaneControl.draw();

            //update the stage size
            resetStage(stage);
        });
    }

    private static int getSize(){
        String item = consolePane.getSizeBox().getValue();
        int value;

        if("20 × 20".equals(item))
            value = 20;
        else if("30 × 30".equals(item))
            value = 30;
        else
            value = 40;
        return value;
    }

    private static double getBirthRate(){
        return consolePane.getBirthRateBox().getValue();
    }

    private static void resetStage(Stage stage){
        double canvasSize = cellsPane.getCanvas().getWidth();
        double width = canvasSize + consolePane.getGridPane().getWidth() + 20;
        double height = canvasSize + 30;
        stage.setWidth(width);
        stage.setHeight(height);
    }
}
