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
        genCells();
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

    private void genCells(){
        cells = new int[N][N];
        oldCells = new int[N][N];
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

    public void empty(){
        genCells();
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++){
                setDead(i, j);
            }
        copyCells();
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

    public void generate(String instance){
        if("Glider".equals(instance)) {
            int[] x = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2, 6, 6, 6, 6, 7, 7, 7, 8, 8, 8};
            int[] y = {1, 2, 7, 0, 2, 8, 2, 6, 7, 8, 0, 1, 2, 6, 0, 6, 8, 1, 6, 7};
            empty();
            for (int i = 0; i < 20; ++i) {
                oldCells[x[i] + 20][y[i] + 20] = 2;
            }
        } else if("Acorn".equals(instance)){
            int[] x = {0, 1, 2, 2, 2, 2, 2};
            int[] y = {1, 3, 0, 1, 4, 5, 6};
            empty();
            for(int i = 0; i < 7; ++i){
                oldCells[y[i] + 32][x[i] + 24] = 2;
            }
        } else if("Gun".equals(instance)){

            int[] x = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 7, 7, 8, 8, 9, 12, 12, 12, 13, 14};
            int[] y = {23, 24, 34, 35, 22, 24, 34, 35, 0, 1, 9, 10, 22, 23, 0, 1, 8, 10, 8, 9, 16, 17, 16, 18, 16, 35, 36, 35, 37, 35, 24, 25, 26, 24, 25};
            empty();
            for(int i = 0; i < 35; ++i){
                oldCells[y[i] + 6][x[i] + 14] = 2;
            }
        }
    }
}
