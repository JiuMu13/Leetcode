package 每日一题;

public class 网格中的最小路径代价 {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m=grid.length;//行数
        int n=grid[0].length;//列数
        int[][] dp=new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        for (int i=0;i<n;i++){
            dp[0][i]=grid[0][i];
        }
        for (int i=1;i<m;i++){
            for (int j=0;j<n;j++){
                for (int k=0;k<n;k++){
                    dp[i][j]=Math.min(dp[i][j],moveCost[grid[i-1][k]][j]+dp[i-1][k]);
                }
                dp[i][j]+=grid[i][j];
            }
        }
        int result=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            result= Math.min(result,dp[m-1][i]);
        }
        return result;
    }

}
