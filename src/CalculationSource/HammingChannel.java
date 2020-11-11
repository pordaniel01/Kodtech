package CalculationSource;

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
            genMtx.printMtx();
            for(int i = k; i < n; i++){     //oszlop
                for(int j = 0; j < k; j++){ //sor
                    genMtx.mtx[j][i] = Atrans.mtx[j][i-k];
                }
            }

        }
    }
    //public static void calculateParChkMtx
}
