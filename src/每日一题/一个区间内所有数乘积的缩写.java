package 每日一题;

import java.math.BigInteger;
//超时
public class 一个区间内所有数乘积的缩写 {
    public String abbreviateProduct(int left, int right) {
        BigInteger sum=new BigInteger(String.valueOf(1));
        long zc=left;
        for (int i=left+1;i<=right;i++){
            if (zc<9e18/i){
                zc*=i;
            }else {
                sum=sum.multiply(BigInteger.valueOf(zc));
                zc=i;
            }
//            System.out.println(i);
        }
//        System.out.println(zc);
        sum=sum.multiply(BigInteger.valueOf(zc));
        String r=sum.toString();
        int i;
        for (i=r.length()-1;i>0;i--){
            if (r.charAt(i)!='0')
                break;
        }
        String s3="e"+(r.length()-i-1);
        if (i>=10){
            String s1=r.substring(0,5);
            String s2=r.substring(i-4,i+1);
            return s1+"..."+s2+s3;
        }
        return r.substring(0,i+1)+s3;
    }

    public static void main(String[] args) {
        一个区间内所有数乘积的缩写 t=new 一个区间内所有数乘积的缩写();
        System.out.println(t.abbreviateProduct(371,375));
    }
}
