package CalculationSource;

import java.util.ArrayList;
import java.util.Stack;

public class HammingChannel {
    private int n;
    private int k;
    private int dmin;
    public Matrix genMtx;
    public Matrix parChkMtx;
    public HammingChannel(){
        //genMtx = new Matrix(k,n);
        //parChkMtx = new Matrix(k-n,n);
    }
    public int[] getParams(){
        int params[] = {n,k};
        System.out.println("n: "+n+" k: "+k);
        return params;
    }
    public void setGenMtx(Matrix genMtx) {
        this.genMtx = genMtx;
        k = genMtx.getRows();
        n = genMtx.getColumns();
    }
    public void setParChkMtx(Matrix parChkMtx){
        this.parChkMtx = parChkMtx;
        n = parChkMtx.getColumns();
        k =  n - parChkMtx.getRows();
    }
    public Matrix getParChkMtx(){
        return parChkMtx;
    }
    public Matrix getGenMtx(){
        return genMtx;
    }
    public void calculateGenMtx(){
        if(parChkMtx != null){
            System.out.println("calculating genmtx");
            genMtx = new Matrix(k,n);
            Matrix A = parChkMtx.getPartMtx(1,n-k,1,k);
            MatrixCalculator mc = new MatrixCalculator(parChkMtx);
            mc.add(A);
            Matrix Atrans = mc.transpose(1);
            for(int i = 0; i < k; i++){
                for(int j = 0; j < k; j++){
                    if(i == j)
                        genMtx.mtx[i][j] = 1;
                    else
                        genMtx.mtx[i][j] = 0;
                }
            }
            for(int i = k; i < n; i++){     //oszlop
                for(int j = 0; j < k; j++){ //sor
                    genMtx.mtx[j][i] = Atrans.mtx[j][i-k];
                }
            }

        }
    }
    public void calculateParChkMtx(){
        parChkMtx = new Matrix(n-k,n);
        MatrixCalculator mc = new MatrixCalculator(parChkMtx);
        mc.add(genMtx);
        Matrix A = genMtx.getPartMtx(1,k,k+1,n);
        mc.add(A);
        Matrix Atrans = mc.transpose(2);
        for(int i = 0; i < k; i++){ //oszlop
            for(int j = 0; j < n-k; j++){  //sor
                parChkMtx.mtx[j][i] = Atrans.mtx[j][i];
            }
        }
        for(int i = k; i < n ; i++) {//osszlop
            for (int j = 0; j < n - k; j++) { //sor
                if (j == (i - k))
                    parChkMtx.mtx[j][i] = 1;
                else
                    parChkMtx.mtx[j][i] = 0;
            }
        }
    }
    private int[] binaryConverter(int decimal, int bits){
        int binary[] = new int[bits+1];
        int index = bits - 1;
        while(decimal  > 0){
            binary[index--] = decimal % 2;
            decimal = decimal/2;
        }
        return binary;
    }
    public ArrayList<Matrix> getErrorGroup(Matrix sindromeVector){

        ArrayList<Matrix> possibleErrorVectors = new ArrayList<Matrix>();
        for(int i = 0; i < Math.pow(2,n); i++){
            Matrix errorVector = new Matrix(1,n);
            int binary[] = binaryConverter(i,n);
            for(int j = 0; j < n; j++){
                errorVector.mtx[0][j] = binary[j];
            }
            MatrixCalculator mc = new MatrixCalculator(errorVector);
            possibleErrorVectors.add(errorVector);
        }
        ArrayList<Matrix> goodErrorVectors = new ArrayList<Matrix>();
        for(int i = 0; i < possibleErrorVectors.size();i++){
            MatrixCalculator mc = new MatrixCalculator(parChkMtx);
            mc.add(possibleErrorVectors.get(i));
            Matrix errTrans = mc.transpose(1);
            mc.add(errTrans);
            try {
                Matrix gottenSindromeVector = mc.mtxMultiply(0,2);
                mc.add(gottenSindromeVector);
                Matrix gottenSindromeVectorTransposed = mc.transpose(3);
                if (gottenSindromeVectorTransposed.compareMatrix(sindromeVector)) {
                    goodErrorVectors.add(errTrans);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            mc.matrices.clear();


        }
        return goodErrorVectors;

    }
}
