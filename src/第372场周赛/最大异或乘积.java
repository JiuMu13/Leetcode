package 第372场周赛;

import java.math.BigInteger;
//o(1)解法：
/*
利用位运算技巧
若a=11101,b=00001;
此时a和b最后两位相同，而其余位都不同
则此时取x=_ _ _ 1 0;
无论x前三位怎么取，a^x+b^x的值不变
根据和定近积大，应让a^x与b^x尽可能接近
可将最高位的1分给a,将其余位的1给b;
 */
public class 最大异或乘积 {
    public int maximumXorProduct(long a, long b, int n) {
        //丑陋的大数运算
        long mod=(long)1e9+7;
        long rn=0;
        BigInteger biga0;
        BigInteger bigb0;
        BigInteger biga1;
        BigInteger bigb1;
        long fa=0,fb=0;
        for (int i=50;i>=0;i--){
            fa+=(a&(1l<<i));
            fb+=(b&(1l<<i));
            if (i<n){
                long t0=rn;
                long t1=rn+(1l<<i);
//                System.out.println("i:"+i);
                long fx0a=fa^t0,fx0b=fb^t0;
                long fx1a=fa^t1,fx1b=fb^t1;
                biga0=new BigInteger(String.valueOf(fx0a));
                bigb0=new BigInteger(String.valueOf(fx0b));
                biga1=new BigInteger(String.valueOf(fx1a));
                bigb1=new BigInteger(String.valueOf(fx1b));
//                System.out.println("11:   "+biga1.multiply(bigb1));
//                System.out.println("00:   "+biga0.multiply(bigb0));
                if (biga0.multiply(bigb0).compareTo(biga1.multiply(bigb1))<0){
                    rn=rn+(1l<<i);
//                    System.out.println(rn);
                }
            }
        }
//        System.out.println(rn);
//        System.out.println((a^rn)%mod);
//        System.out.println((b^rn)%mod);
        long result=(((a^rn)%mod)*((b^rn)%mod))%mod;
        return (int)result;
    }

    public static void main(String[] args) {
        最大异或乘积 t=new 最大异或乘积();
        System.out.println(t.maximumXorProduct(570713374625622l,553376364476768l,35));
    }
}
