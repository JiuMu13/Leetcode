package 第365场周赛;

import java.util.Arrays;
import java.util.logging.LogManager;

public class 有序三元组中的最大值一二 {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        long[] maxa=new long[n];
        maxa[0]=nums[0];
        long[] maxc=new long[n];
        maxc[n-1]=nums[n-1];
        for (int i=1;i<n;i++){
            maxa[i]=Math.max(maxa[i-1],nums[i]);
        }
        for (int i = n-2 ; i >=0 ; i--) {
            maxc[i]=Math.max(maxc[i+1],nums[i]);
        }
        long result=Long.MIN_VALUE;
        for (int i=1;i<nums.length-1;i++){
            if ((maxa[i-1]-nums[i])*maxc[i+1]>result)
                result=(maxa[i-1]-nums[i])*maxc[i+1];
        }
        return result>0?result:0;
    }
}
