package Application;

import CalculationSource.Matrix;
import CalculationSource.MatrixCalculator;

public class CommonInterface {
    public static void main(String args[]){
        double row1[] = {3,3,5};
        double row2[] = {1,5,2};
        double row3[] = {2,3,5};
        double mtx1[][] = {row1, row2,row3};

        double row4[] = {1,1,1};
        double row5[] = {2,2,2};
        double row6[] = {3,3,3};
        double mtx3[][] = {row4,row5,row6};

        Matrix mtx2 = new Matrix(mtx1,3,3);
        Matrix mtx4 = new Matrix(mtx3,3,3);
        mtx2.printMtx();
        System.out.println("");
        mtx4.printMtx();
        System.out.println("");

        MatrixCalculator calculator = new MatrixCalculator(mtx2);
        calculator.add(mtx4);
        System.out.println("");

        try {
            Matrix mtx5 = calculator.sum(0,1);
            mtx5.printMtx();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //calculator.transpose(0);
        //System.out.println("");
        //System.out.println(mtx2.getElement(1,3));




        //System.out.println(mtx.mtx[0][2]);
        //System.out.println("szia");

    }
}
