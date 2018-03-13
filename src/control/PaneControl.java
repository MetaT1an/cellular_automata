package control;

import javafx.scene.paint.Color;
import model.Cell;
import view.CellsPane;

public class PaneControl {
    private PaneControl(){}
    private static Cell cell = Cell.getCells();
    private static CellsPane  cellsPane= CellsPane.getCellsPane();

    public static void draw(){
        for(int i=0; i<Cell.N; ++i)
            for(int j=0; j<Cell.N; ++j){
                if(cell.getStatus(i,j) == 1)
                    cellsPane.getGc().setFill(Color.GRAY);
                else
                    cellsPane.getGc().setFill(Color.WHITE);

                double x = i*(CellsPane.CELL_SIZE+CellsPane.CELL_PADDING) + CellsPane.CELL_SIZE;
                double y = j*(CellsPane.CELL_SIZE+CellsPane.CELL_PADDING) + CellsPane.CELL_SIZE;
                cellsPane.getGc().fillRect(x, y, CellsPane.CELL_SIZE, CellsPane.CELL_SIZE);
            }
    }

}
