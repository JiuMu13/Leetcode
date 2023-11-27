package 第371场周赛;

import java.util.Arrays;

public class 找出强数对的最大异或值一 {
    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);
        int result=0;
        for (int i=0;i<nums.length;i++){
            for (int j=i;j<nums.length;j++){
                if (nums[j]<=2*nums[i]){
                    result=Math.max(result,nums[i]^nums[j]);
                }
            }
        }
        return result;
    }
}
