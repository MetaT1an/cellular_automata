package control;

import javafx.scene.paint.Color;
import model.Cell;
import view.CellsPane;

public class PaneControl {
    private PaneControl(){}
    private static Cell cell = Cell.getCells();
    private static CellsPane  cellsPane = CellsPane.getCellsPane();

    public static void draw(){
        for(int i=0; i<Cell.N; ++i)
            for(int j=0; j<Cell.N; ++j){
                if(cell.getStatus(i,j) == 1)
                    cellsPane.getGc().setFill(Color.GRAY);
                else if(cell.getStatus(i, j) == 2)
                    cellsPane.getGc().setFill((Color.rgb(36, 36, 36)));
                else
                    cellsPane.getGc().setFill(Color.WHITE);

                drawOneCell(i, j);
            }
    }

    public static void addCellsEvent(){
        cellsPane.getCanvas().setOnMouseClicked(event -> {
            //add operations after the mouse clicking on the board
            int x = (int)(event.getX() / (CellsPane.CELL_SIZE + CellsPane.CELL_PADDING)) - 1;
            int y = (int)(event.getY() / (CellsPane.CELL_SIZE + CellsPane.CELL_PADDING)) - 1;
            if(x < 0 || y < 0)
                return;
            if(cell.getStatus(x, y) > 0){
                cell.setStatus(x, y, 0);
                cellsPane.getGc().setFill(Color.WHITE);
            }
            else{
                cell.setStatus(x, y, 2);
                cellsPane.getGc().setFill(Color.rgb(36, 36, 36));
            }
            drawOneCell(x, y);
        });
    }

    private static void drawOneCell(int i, int j){
        double x = i*(CellsPane.CELL_SIZE+CellsPane.CELL_PADDING) + CellsPane.CELL_SIZE;
        double y = j*(CellsPane.CELL_SIZE+CellsPane.CELL_PADDING) + CellsPane.CELL_SIZE;
        cellsPane.getGc().fillRect(x, y, CellsPane.CELL_SIZE, CellsPane.CELL_SIZE);
    }
}
