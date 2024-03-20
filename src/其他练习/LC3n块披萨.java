package 其他练习;

public class LC3n块披萨 {
    public int maxSizeSlices(int[] slices) {
        int n= slices.length;
        int[][] dp=new int[n][n];
        dp[0][1]=slices[0];
        dp[1][1]=Math.max(slices[0],slices[1]);
        for (int i=2;i<n;i++){
            for (int j=1;j<=i;j++){
                dp[i][j]=Math.max(dp[i-2][j-1]+slices[i],dp[i-1][j]);
            }
        }
        int r=dp[n-2][n/3];
        dp[0][1]=slices[1];
        dp[1][1]=Math.max(slices[1],slices[2]);
        for (int i=2;i<n-1;i++){
            for (int j=1;j<=i;j++){
                dp[i][j]=Math.max(dp[i-2][j-1]+slices[i+1],dp[i-1][j]);
            }
        }
        r=Math.max(r,dp[n-2][n/3]);
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new LC3n块披萨().maxSizeSlices(new int[]{4,1,2,5,8,3,1,9,7}));
    }
}
