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

    public static void addControlEvent(Stage stage){

        // Set Button was clicked
        consolePane.getButtons(0).setOnAction(event -> {
            String selection = consolePane.getModeBox().getValue();
            String instance = consolePane.getInstanceBox().getValue();

            //update model part
            Cell.resetArgs(getSize(), getBirthRate());

            if("mode 1".equals(selection)){
                cell.resetCells();
            }else if("mode 2".equals(selection)){
                cell.empty();
            } else if("mode 3".equals(selection)){
                cell.generate(instance);
                PaneControl.draw();
            }

            //update view part
            cellsPane.resetCanvas();
            PaneControl.draw();

            //update the stage size
            resetStage(stage);
        });

        consolePane.getModeBox().setOnAction(event -> {
            String selection = consolePane.getModeBox().getValue();
            if("mode 1".equals(selection)){
                PaneControl.delCellsEvent();
            }else if("mode 2".equals(selection)){
                PaneControl.addCellsEvent();
            }else if("mode 3".equals(selection)){
                setSize(3);
                PaneControl.delCellsEvent();
            }else{
                
            }
            loadBtns(selection);
        });
    }

    private static int getSize(){
        String item = consolePane.getSizeBox().getValue();
        int value;

        if("20 × 20".equals(item))
            value = 20;
        else if("30 × 30".equals(item))
            value = 30;
        else if("40 × 40".equals(item))
            value = 40;
        else
            value = 50;
        return value;
    }

    private static void setSize(int i){
        String select = consolePane.getSizeBox().getItems().get(i);
        consolePane.getSizeBox().setValue(select);
    }

    private static double getBirthRate(){
        return consolePane.getBirthRateBox().getValue();
    }

    private static void resetStage(Stage stage){
        double canvasSize = cellsPane.getCanvas().getWidth();
        double width = canvasSize + consolePane.getvBox().getWidth() + 20;
        double height = canvasSize + 30;
        stage.setWidth(width);
        stage.setHeight(height);
    }

    private static void loadBtns(String mode){
        if("mode 1".equals(mode)){
            consolePane.getBirthRateBox().setDisable(false);
            consolePane.getSizeBox().setDisable(false);
            consolePane.getInstanceBox().setDisable(true);
        } else if("mode 2".equals(mode)){
            consolePane.getBirthRateBox().setDisable(true);
            consolePane.getSizeBox().setDisable(false);
            consolePane.getInstanceBox().setDisable(true);
        } else if("mode 3".equals(mode)){
            consolePane.getBirthRateBox().setDisable(true);
            consolePane.getSizeBox().setDisable(true);
            consolePane.getInstanceBox().setDisable(false);
        }
    }
}
