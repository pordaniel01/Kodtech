package CalculationSource;

public class Matrix {
    public double[][] mtx;
    private int rows;
    private int colums;
    public Matrix(int k, int n){
        mtx = new double[k][n];
        rows = n;
        colums = k;
    }
    public Matrix(double[][] mtx){
        this.mtx = mtx;
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

}
