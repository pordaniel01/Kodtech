package CalculationSource;

import java.util.ArrayList;

public class MatrixCalculator {
    ArrayList<Matrix> matrices = new ArrayList<Matrix>();
    public MatrixCalculator(Matrix[] matrixArr){
        for(int i = 0; i < matrixArr.length;i++){
            this.matrices.add(matrixArr[i]);
        }
    }
    public  MatrixCalculator(Matrix mtx){
        matrices.add(mtx);
    }
    public void add(Matrix mtx){
        matrices.add(mtx);
    }
    public Matrix get(int i){
        return matrices.get(i);
    }
    public void remove(int i){
        matrices.remove(i);
    }
    //osszeadja a két mátrixot
    public Matrix sum(int i, int j) throws Exception {
        Matrix mtx1 = matrices.get(i);
        Matrix mtx2 = matrices.get(j);
        if(mtx1.getRows() != mtx2.getRows() || mtx1.getColumns() != mtx2.getColumns()) {
            Exception exception = new Exception("Not equal size matrices, cant add them");
            throw exception;
        }
        Matrix output = new Matrix(mtx1.getRows(),mtx2.getColumns());
        for(int k = 0; i < mtx1.getColumns(); i++){
            for(int l = 0; l < mtx2.getRows(); l++){
                output.mtx[l][i] = mtx1.mtx[l][i] + mtx2.mtx[l][i];
            }
        }
        return  output;
    }
    public int multiplyMatricesCell(Matrix mtx1, Matrix mtx2, int row, int col){
        int cell = 0;
        for(int i = 0; i < mtx2.getRows();i++){
            cell += mtx1.mtx[row][i] * mtx2.mtx[i][col];
        }
        return cell;
    }
    //osszeszoroz két mátrixot, balrol az i jobbrol a j ik elem
    public Matrix mtxMultiply(int i, int j) throws Exception {
        Matrix mtx1 = matrices.get(i);
        Matrix mtx2 = matrices.get(j);
        Matrix output = new Matrix(mtx1.getRows(),mtx2.getColumns());
        if(mtx1.getColumns() != mtx2.getRows()){
            Exception e = new Exception("row count doesnt match");
            throw e;
        }
        for(int k = 0; k < output.getRows();k++){
            for(int l= 0 ; l < output.getColumns();l++){
                output.mtx[k][l] = multiplyMatricesCell(mtx1,mtx2,k,l);
            }
        }
        return output;

    }
    //transzponálja a paraméterként megadott mátrixot
    public Matrix transpose(int i){
        Matrix mtx = matrices.get(i);
        Matrix newMtx = new Matrix(mtx.getColumns(),mtx.getRows());
        for(int k = 0; k < newMtx.getRows(); k++){
            for(int j = 0; j < newMtx.getColumns(); j++){
                newMtx.mtx[k][j] = mtx.mtx[j][k];
            }
        }
        return newMtx;

    }
    //osszeadja a mtx osszes elemet (vektorsuly szamolásnál fulljó)
    public double calculateWight(int i ){
        Matrix mtx = matrices.get(i);
        double sum = 0;
        for(int k = 0 ; k < mtx.getColumns(); k++){
            for(int j = 0; j < mtx.getRows(); j++){
                sum += mtx.mtx[j][k];
            }
        }
        return sum;
    }
}
