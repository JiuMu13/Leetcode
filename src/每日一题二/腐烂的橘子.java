package 每日一题二;

import java.util.Arrays;

/**
 * 更优方法：bfs
 */
public class 腐烂的橘子 {
    public static int orangesRotting(int[][] grid) {
        int n= grid.length;
        int m=grid[0].length;
        int[][] g=new int[n+2][m+2];
        for (int i=0;i<n;i++){
            System.arraycopy(grid[i], 0, g[i + 1], 1, m);
        }
        int[][] t=new int[n+2][m+2];
        for (int[] ints : t) {
            Arrays.fill(ints,Integer.MAX_VALUE/2);
        }
        for (int i=1;i<=n;i++) {
            for (int j = 1; j <= m; j++) {
                if (g[i][j]==2)
                    t[i][j]=0;
            }
        }
        int[][] f=new int[n+2][m+2];
        for (int h=0;h<n*m;h++){
            for (int i = 0; i <= n; i++) {
                System.arraycopy(g[i], 0, f[i], 0, m + 1);
            }
            for (int i=1;i<=n;i++){
                for (int j=1;j<=m;j++){
                    if (g[i][j]==2){
                        if (g[i-1][j]==1){
                            t[i-1][j]=Math.min(t[i][j]+1,t[i-1][j]);
                            f[i-1][j]=2;
                        }
                        if (g[i+1][j]==1){
                            t[i+1][j]=Math.min(t[i][j]+1,t[i+1][j]);
                            f[i+1][j]=2;
                        }
                        if (g[i][j-1]==1){
                            t[i][j-1]=Math.min(t[i][j]+1,t[i][j-1]);
                            f[i][j-1]=2;
                        }if (g[i][j+1]==1){
                            t[i][j+1]=Math.min(t[i][j]+1,t[i][j+1]);
                            f[i][j+1]=2;
                        }
                    }else if (g[i][j]==1){
                        if (g[i-1][j]+g[i+1][j]+g[i][j-1]+g[i][j+1]==0){
                            return -1;
                        }
                    }
                }
            }
            for (int i = 0; i <= n; i++) {
                System.arraycopy(f[i], 0, g[i], 0, m + 1);
            }
        }
        int r=0;
        for (int i=1;i<=n;i++) {
            for (int j = 1; j <= m; j++) {
                if (g[i][j]==1)
                    return -1;
                if (t[i][j] < Integer.MAX_VALUE/2)
                    r=Math.max(r,t[i][j]);
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[][] s=new int[][]{{0,1}};
        System.out.println(orangesRotting(s));
    }
}
