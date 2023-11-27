package 第367场周赛;

import java.math.BigInteger;

public class 构造乘积矩阵 {
    public int[][] constructProductMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] pre=new int[n*m+1];
        int[] suf=new int[n*m+1];
        suf[n*m]=1;
        int MOD=12345;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (i==0 &&j==0)
                    pre[0]=grid[0][0]%MOD;
                else
                    pre[i*m+j]=grid[i][j]%MOD*pre[i*m+j-1]%MOD;
            }
        }
        for (int i=n-1;i>=0;i--){
            for (int j=m-1;j>=0;j--){
                suf[i*m+j]=grid[i][j]%MOD*suf[i*m+j+1]%MOD;
            }
        }
        int[][] p=new int[n][m];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                if (i==0 && j==0)
                    p[i][j]=suf[1]%MOD;
                else
                    p[i][j]=pre[i*m+j-1]%MOD*suf[i*m+j+1]%MOD;
            }
        }
        return p;
    }
}
