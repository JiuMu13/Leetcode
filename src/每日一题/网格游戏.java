package 每日一题;

public class 网格游戏 {
    public long gridGame(int[][] grid) {
        int n=grid[0].length;
        long sum1=-1;
        long sum2=-1;
        long bigger=0;
        long result=Long.MAX_VALUE;
        //维护第一个后缀和数组
        long[] suf1=new long[n+1];
        long[] suf2=new long[n+1];
        suf1[n-1]=grid[0][n-1];
        suf2[n-1]=grid[1][n-1];
        for (int i=n-2;i>=0;i--){
            suf1[i]=grid[0][i]+suf1[i+1];
            suf2[i]=grid[1][i]+suf2[i+1];
        }
        for (int i=0;i<n;i++){
            bigger=Math.max(suf1[i+1],suf2[0]-suf2[i]);
            result=Math.min(bigger,result);
        }
//        for (int i=0;i<=f;i++){
//            grid[0][i]=0;
//        }
//        for (int i=f;i<n;i++){
//            grid[1][i]=0;
//        }
//        suf1=new long[n+1];
//        suf2=new long[n+1];
//        suf1[n-1]=grid[0][n-1];
//        suf2[n-1]=grid[1][n-1];
//        for (int i=n-2;i>=0;i--){
//            suf1[i]=grid[0][i]+suf1[i+1];
//            suf2[i]=grid[1][i]+suf2[i+1];
//        }
//        for (int i=0;i<n;i++){
//            long sum=suf1[0]-suf1[i+1]+suf2[i];
//            if (sum2<sum) {
//                sum2 = sum;
//            }
//        }
        return result;
    }
}
