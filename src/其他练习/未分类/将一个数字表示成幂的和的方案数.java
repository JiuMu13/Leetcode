package 其他练习.未分类;

public class 将一个数字表示成幂的和的方案数 {
    public int numberOfWays(int n, int x) {
        long[] dp=new long[n+1];
        int mod=(int) 1e9+7;
        dp[0]=1;
        for (int i=1;pow(i,x)<n;i++){
            int t = pow(i,x);
            for (int j=n;j>=t;j--){
                dp[j]+=dp[j-t];
            }
        }
        return (int) (dp[n]%mod);
    }
    private int pow(int a,int b){
        int r=1;
        while (b>0){
            r*=a;
            b--;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new 将一个数字表示成幂的和的方案数().numberOfWays(10,2));
    }
}
