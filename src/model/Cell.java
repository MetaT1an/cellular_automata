package model;

public class Cell {

    private int[][] cells;
    private int[][] oldCells;
    public static  int N = 30;
    private static double birthRate = 0.2;

    private Cell(){
        resetCells();
    }

    private static Cell cell = null;

    public static Cell getCells(){
        if(cell == null)
            cell = new Cell();
        return cell;
    }
    /*
    after the new size or new birthRate was set,
    this method will be called to redefine the cells
     */
    public void resetCells(){
        cells = new int[N][N];
        oldCells = new int[N][N];
        init();
    }

    public static void resetArgs(int n, double rate){
        Cell.N = n;
        Cell.birthRate = rate;
    }

    private void init(){
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++){
                if(Math.random() < birthRate)
                    setAlive(i, j);
            }
        copyCells();
    }

    private void setAlive(int i, int j){
        cells[i][j] = 2;
    }

    private void setOld(int i, int j){
        cells[i][j] = 1;
    }

    private void setDead(int i, int j){
        cells[i][j] = 0;
    }

    private int getAliveNeighbor(int i, int j){
        int sum = 0;
        for(int m=i-1; m<=N-1 && m>=0 && m<=i+1; ++m)
            for(int n=j-1; n<=N-1 && n>=0 && n<=j+1; ++n){
                if(!(m == i && n == j) && getStatus(m, n) > 0)
                    sum++;
            }
        return sum;
    }

    private void copyCells(){
        for(int i = 0; i < N; ++i) {
            System.arraycopy(cells[i], 0, oldCells[i], 0, N);
        }
    }

    public int getStatus(int i, int j){
        return oldCells[i][j];
    }

    public void setClickStatus(int i, int j, int status){
        oldCells[i][j] = status;
    }

    public void scan(){
        for(int i=0; i<N; ++i)
            for(int j=0; j<N; ++j) {

                if (getStatus(i, j) == 0) {
                    if (getAliveNeighbor(i, j) == 3)
                        setAlive(i, j);
                    else
                        setDead(i, j);
                } else {    // alive
                    if (getAliveNeighbor(i, j) < 2 || getAliveNeighbor(i, j) > 3)
                        setDead(i, j);
                    else
                        setOld(i, j);
                }
            }
        copyCells();
    }
}
