package model;

public class Cell {

    private int[][] cells;
    public static  int N = 30;
    private static double birthRate = 0.2;

    private Cell(){
        cells = new int[N][N];
        init();
    }

    private static Cell cell = null;

    public static Cell getCells(){
        if(cell == null)
            cell = new Cell();
        return cell;
    }
    /*
    after the new size and new birthRate was set,
    this method will be called to redefine the cells
     */
    public void resetCells(){
        cells = new int[N][N];
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
    }

    private void setAlive(int i, int j){
        cells[i][j] = 1;
    }

    private void setDead(int i, int j){
        cells[i][j] = 0;
    }

    private int getAliveNeighbor(int i, int j){
        int sum = 0;
        for(int m=i-1; m<=N-1 && m>=0 && m<=i+1; ++m)
            for(int n=j-1; n<=N-1 && n>=0 && n<=j+1; ++n){
                if(!(m == i && n == j) && getStatus(m, n) == 1)
                    sum++;
            }
        return sum;
    }

    public int getStatus(int i, int j){
        return cells[i][j];
    }

    public void scan(){
        for(int i=0; i<N; ++i)
            for(int j=0; j<N; ++j){
                if(getStatus(i, j) == 0 && getAliveNeighbor(i, j) == 3)
                    setAlive(i, j);
                if(getStatus(i, j) == 1 && (getAliveNeighbor(i, j) < 2 || getAliveNeighbor(i, j) > 3))
                    setDead(i, j);
            }
    }
}
