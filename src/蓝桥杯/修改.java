package 蓝桥杯;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class 修改 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int na=(int)st.nval;
        st.nextToken();
        int nb=(int)st.nval;
        st.nextToken();
        int d=(int )st.nval;
        int[] as=new int[na+1];
        for (int i = 1; i <= na; i++) {
            st.nextToken();
            as[i]=(int)st.nval;
        }
        int[] bs=new int[nb+1];
        for (int i = 1; i <= nb; i++) {
            st.nextToken();
            bs[i]=(int)st.nval;
        }
        Arrays.sort(as,1,na+1);
        Arrays.sort(bs,1,nb+1);
        double[][][] dp=new double[na+1][nb+1][2];//0为a道路，1为b道路
        for (double[][] e1 : dp) {
            for (double[] e2 : e1) {
                Arrays.fill(e2,Double.MAX_VALUE/2);
            }
        }
        dp[0][0][0]=0;
        for (int i = 0; i <= na; i++) {
            for (int j = 0; j <= nb; j++) {
                if (i<na)
                    dp[i+1][j][0]=Math.min(dp[i+1][j][0],
                            Math.min(dp[i][j][0]+as[i+1]-as[i],dp[i][j][1]+xb(bs[j],as[i+1],d)));
                if (j<nb)
                    dp[i][j+1][1]=Math.min(dp[i][j+1][1],
                            Math.min(dp[i][j][0]+xb(as[i],bs[j+1],d),dp[i][j][1]+bs[j+1]-bs[j]));
            }
        }
        System.out.printf("%.2f%n",Math.min(dp[na][nb][0],dp[na][nb][1]));
    }

    private static double xb(double a,double b,double d){
        double e1=Math.abs(a-b);
        return Math.sqrt(e1*e1+d*d);
    }
}
