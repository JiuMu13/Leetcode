package 每日一题;

import java.math.BigInteger;

public class 所有排列中的最大和 {
    public int maxSumRangeQuery(int[] nums, int[][] requests) {
        BigInteger sum=BigInteger.valueOf(0);
        long[] cf=new long[nums.length+1];
        for (int i=0;i<requests.length;i++){
            cf[requests[i][0]]++;
            cf[requests[i][1]+1]--;
        }//各个位置累加的次数
        long[] f=new long[nums.length];
        f[0]=cf[0];
        for (int i=1;i<nums.length;i++){
            f[i]+=f[i-1]+cf[i];
        }
        kp(f,0,nums.length-1);
        long[] numsl=new long[nums.length];
        for (int i=0;i<nums.length;i++)
            numsl[i]=nums[i];
        kp(numsl,0,nums.length-1);
        for (int i=0;i<nums.length;i++)
            sum=sum.add(BigInteger.valueOf(f[i] * numsl[i]));
        String result=sum.mod( BigInteger.valueOf((int)(1e9+7)) ).toString();
        int r=Integer.parseInt(result);
        return r;
    }
    private void kp(long[] s,int l,int r){
        if (l>=r)
            return;
        long f=s[l];
        int i=l-1,j=r+1;
        while (i<j){
            while (s[++i]>f);
            while (s[--j]<f);
            if (i<j){
                long temp=s[i]; s[i]=s[j]; s[j]=temp;
            }
        }
        kp(s,l,j);
        kp(s,j+1,r);
    }

    public static void main(String[] args) {
        所有排列中的最大和 t=new 所有排列中的最大和();
        int[] n= new int[]{1, 2, 3, 4, 5,6};
        int[][] re=new int[][]{{0,5},{2,3}};
        System.out.println(t.maxSumRangeQuery(n,re));
    }
}
