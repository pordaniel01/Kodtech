package CalculationSource;

public class Matrix {
    public double[][] mtx;
    private int rows;
    private int colums;
    public Matrix(int rows, int columns){
        mtx = new double[rows][columns];
        this.rows = rows;
        this.colums = columns;
    }
    public Matrix(double[][] mtx, int cols, int rows){
        this.mtx = mtx;
        this.rows = rows;
        this.colums =  cols;
    }

    public int getRows(){
        return rows;
    }
    public double getElement(int row, int column){
        return mtx[row-1][column-1];
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

}
