package 每日一题二;

import java.util.Arrays;

public class 摘樱桃 {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int[][][] dp=new int[2*n-1][n+1][n+1];//第一个值为当前走了几步，第二个值为先走的路线在第几行，第三个值为后走的路线在第几行
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt,Integer.MIN_VALUE);
            }
        }
        dp[0][1][1]=grid[0][0];
        for (int i=1;i<2*n-1;i++){
            for (int j=Math.max(1,i-n+2);j<=Math.min(n,i+1);j++){
                for (int h=Math.max(1,i-n+2);h<=Math.min(n,i+1);h++){
                    if (grid[j-1][i-j+1]==-1 || grid[h-1][i-h+1]==-1)
                        continue;
                    dp[i][j][h]=Math.max(
                            Math.max(dp[i-1][j][h],dp[i-1][j-1][h]),
                            Math.max(dp[i-1][j-1][h-1],dp[i-1][j][h-1]));
                    if (j==h){
                        dp[i][j][h]+=grid[j-1][i-j+1];
                    }else {
                        dp[i][j][h]+=grid[j-1][i-j+1]+grid[h-1][i-h+1];
                    }
                }
            }
        }
        return Math.max(0,dp[2*n-2][n][n]);
    }

    public static void main(String[] args) {
        int[][] g=new int[][]{{0,1,-1},{1,0,-1},{1,1,1}};
        System.out.println(new 摘樱桃().cherryPickup(g));;
    }
}
