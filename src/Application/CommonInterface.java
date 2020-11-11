package Application;

import CalculationSource.HammingChannel;
import CalculationSource.Matrix;
import CalculationSource.MatrixCalculator;

public class CommonInterface {
    public static void main(String args[]){
        int row1[] = {3,3,5};
        int row2[] = {1,5,2};
        int row3[] = {2,3,5};
        int mtx1[][] = {row1, row2,row3};

        int row4[] = {1,1,1};
        int row5[] = {2,2,2};
        int row6[] = {3,3,3};
        int mtx3[][] = {row4,row5,row6};

        Matrix mtx2 = new Matrix(mtx1,3,3);
        Matrix mtx4 = new Matrix(mtx3,3,3);
        System.out.println("mtx 1:");
        mtx2.printMtx();
        System.out.println("");
        System.out.println("mtx 2:");

        mtx4.printMtx();
        System.out.println("");

        MatrixCalculator calculator = new MatrixCalculator(mtx2);
        calculator.add(mtx4);
        System.out.println("");
        System.out.println("adding to matrices");
        try {
            Matrix mtx5 = calculator.sum(0,1);
            mtx5.printMtx();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("transpose first mtx");
        Matrix mtx6 = calculator.transpose(0);
        System.out.println("");
        mtx6.printMtx();
        int mtx8[][] =  {{3,3,3,3},{4,4,4,4},{6,6,6,6}};
        Matrix mtx7 = new Matrix(mtx8,4,3);
        System.out.println("new mtx");
        mtx7.printMtx();
        MatrixCalculator mc = new MatrixCalculator(mtx7);
        System.out.println("transposing it");
        mc.transpose(0).printMtx();
        System.out.println("weight: " + mc.calculateWight(0));
        //System.out.println(mtx.mtx[0][2]);
        //System.out.println("szia");


        System.out.println("multiply these two:");
        int[][] mtxmltply1 ={{1,2,3},
                             {4,5,6},
                             {7,8,9}};
        Matrix mtxmltM= new Matrix(mtxmltply1,3,3);
        int[][] mtxmltply2 ={{1,4},{2,5},{3,6}};
        Matrix mtxmltM2 = new Matrix(mtxmltply2,2,3);
        System.out.println("changing 1 number");
        mtxmltM2.setElement(1,2,69);
        mtxmltM2.printMtx();
        MatrixCalculator mlt = new MatrixCalculator(mtxmltM);
        System.out.println("multiply this:");
        mtxmltM.printMtx();
        System.out.println("with this:");
        mtxmltM2.printMtx();
        mlt.add(mtxmltM2);
        try {
            System.out.println("result:");
            mlt.mtxMultiply(0,1).printMtx();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("get part of this matrix");
        mtxmltM.printMtx();
        System.out.println(" ");
        mtxmltM.getPartMtx(1,3,2,3).printMtx();



        //HAMMING
        System.out.println("calc gen from this parchk:");
        int h1[] = {1,1,1,0,0,0};
        int h2[] = {1,1,0,1,0,0};
        int h3[] = {0,1,0,0,1,0};
        int h4[] = {0,1,0,0,0,1};
        int parMtx[][] = {h1,h2,h3,h4};
        Matrix ParMtx = new Matrix(parMtx,6,4);
        //ParMtx.printMtx();
        HammingChannel hc = new HammingChannel();
        hc.setParChkMtx(ParMtx);
        hc.getParChkMtx().printMtx();
        hc.getParams();
        hc.calculateGenMtx();
        hc.getGenMtx().printMtx();

        System.out.println("calc parchek from genmtx");
        int g1[] = {1,0,1,1,0,0};
        int g2[] = {0,1,1,1,1,1};
        int gen[][] = {g1,g2};
        Matrix genMtx = new Matrix(gen,6,2);
        HammingChannel hc2 = new HammingChannel();
        hc2.setGenMtx(genMtx);
        hc2.calculateParChkMtx();
        hc2.getParChkMtx().printMtx();
    }
}
