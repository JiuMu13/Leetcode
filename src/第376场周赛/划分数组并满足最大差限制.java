package 第376场周赛;

import java.util.Arrays;

public class 划分数组并满足最大差限制 {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int[][] r=new int[n/3][3];
        int f=0;
        for (int i=0;i<n;i+=3){
            if (nums[i+2]-nums[i]>k)
                return new int[][]{};
            r[f][0]=nums[i];
            r[f][1]=nums[i+1];
            r[f++][2]=nums[i+2];
        }
        return r;
    }
}
