package Application;

import CalculationSource.Matrix;

public class CommonInterface {
    public static void main(String args[]){
        double row1[] = {3,3,5};
        double row2[] = {1,5,2};
        double row3[] = {2,3,5};
        double mtx1[][] = {row1, row2,row3};


        Matrix mtx2 = new Matrix(mtx1);
        System.out.println(mtx2.getElement(1,3));




        System.out.println(mtx.mtx[0][2]);
        System.out.println("szia");

    }
}
