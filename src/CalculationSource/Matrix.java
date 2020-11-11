package CalculationSource;

public class Matrix {
    public int[][] mtx;
    private int rows;
    private int colums;
    public Matrix(int rows, int columns){
        mtx = new int[rows][columns];
        this.rows = rows;
        this.colums = columns;
    }
    public Matrix(int[][] mtx, int cols, int rows){
        this.mtx = mtx;
        this.rows = rows;
        this.colums =  cols;
    }

    public int getRows(){
        return rows;
    }

    public int getElement(int row, int column){
        return mtx[row-1][column-1];
    }
    public void setElement(int row, int col, int what){
        mtx[row - 1][col - 1] = what;
    }
    public int getColumns(){
        return colums;
    }
    public void printMtx(){
        for(int i = 0; i < rows; i ++) {
            for (int j = 0; j < colums; j++)
                System.out.print(this.mtx[i][j] + " ");
            System.out.println("");
        }
    }
    public Matrix getPartMtx(int k1, int k2, int n1,  int n2){
        Matrix newMtx = new Matrix(k2-k1+1,n2-n1+1);
        for(int i = n1 ; i <= n2; i++){
            for(int j = k1 ; j <= k2; j++){
                //System.out.println("geci");
                //System.out.println(this.getElement(i,j));
                newMtx.setElement(j-k1+1,i-n1+1,this.getElement(j,i));
            }
            System.out.println("");
        }
        return  newMtx;
    }

}
