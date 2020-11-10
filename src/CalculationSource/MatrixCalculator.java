package CalculationSource;

import java.util.ArrayList;

public class MatrixCalculator {
    ArrayList<Matrix> matrices;
    public MatrixCalculator(Matrix[] matrices){
        for(int i = 0; i < matrices.length;i++){
            this.matrices.add(matrices[i]);
        }
    }
    //osszeadja a két mátrixot
    public void add(int i, int j){

    }
    //osszeszoroz két mátrixot, balrol az i jobbrol a j ik elem
    public void mtxMultiply(int i, int j){

    }
    //transzponálja a paraméterként megadott mátrixot
    public void transpose(int i){

    }
    //osszeadja a mtx osszes elemet (vektorsuly szamolásnál fulljó)
    public double calculateWight(int i ){
        Matrix mtx = matrices.get(i);
        double sum = 0;
        for(int k = 0 ; k < mtx.getColumns(); k++){
            for(int j = 0; j < mtx.getRows(); j++){
                sum += mtx.getElement(j,k);
            }
        }
        return sum;
    }
}
