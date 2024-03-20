package 每日一题二;

public class 数组元素的最小非零乘积 {
    public int minNonZeroProduct(int p) {
        if (p==1)
            return 1;
        int MOD=(int) 1e9+7;
        long num=ksm(2,p,Long.MAX_VALUE)-1;
        return (int)((ksm(num-1,(num-1)/2,MOD)*(num%MOD))%MOD);
    }
    public long ksm(long a,long p,long mod){
        a=a%mod;
        long r=1;
        while (p>0){
            if ((p&1)==1)
                r=(r*a)%mod;
            p>>=1;
            a=(a*a)%mod;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new 数组元素的最小非零乘积().minNonZeroProduct(32));
    }
}
