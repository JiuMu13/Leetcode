package 第120场双周赛;

import java.util.Arrays;

public class 找到最大周长的多边形 {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int max=nums[n-1];
        long sum=0;
        long r=-1;
        for (int i=0;i<n;i++){
            if (sum>nums[i])
                r=sum+nums[i];
            sum+=nums[i];
        }
        return r;
    }
}
