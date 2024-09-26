package 其他练习.未分类;

public class 统计放置房子的方式数 {
    public int countHousePlacements(int n) {
        int mod=(int) 1e9+7;
        long[][] dp=new long[n][4];
        dp[0][0]=1;dp[0][1]=1;dp[0][2]=1;dp[0][3]=1;
        for (int i=1;i<n;i++){
            dp[i][0]=(dp[i-1][0]+dp[i-1][1]+dp[i-1][2]+dp[i-1][3])%mod;
            dp[i][1]=(dp[i-1][0]+dp[i-1][2])%mod;
            dp[i][2]=(dp[i-1][0]+dp[i-1][1])%mod;
            dp[i][3]=(dp[i-1][0])%mod;
        }
        return (int)((dp[n-1][0]+dp[n-1][1]+dp[n-1][2]+dp[n-1][3])%mod);
    }

    public static void main(String[] args) {
        System.out.println(new 统计放置房子的方式数().countHousePlacements(1000));
    }
}
