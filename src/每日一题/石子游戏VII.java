package 每日一题;

public class 石子游戏VII {
    int[] pre;
    int[][] dp;
    public int stoneGameVII(int[] stones) {
        int n=stones.length;
        dp=new int[n][n];
        int[] pre=new int[n+1];
        this.pre=pre;
        for (int i=1;i<n+1;i++){
            pre[i]=pre[i-1]+stones[i-1];
        }
        return dp(0,n-1);
    }

    public int dp(int l,int r){
        if (l==r)
            return 0;
        if (dp[l][r]!=0)
            return dp[l][r];
        return dp[l][r]=Math.max(pre[r]-pre[l]-dp(l,r-1),pre[r+1]-pre[l+1]-dp(l+1,r));
    }

    public static void main(String[] args) {
        石子游戏VII t=new 石子游戏VII();
        System.out.println(t.stoneGameVII(new int[]{5,3,1,4,2}));
    }
}
