package 每日一题;

import java.util.Collections;

public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        for (int i=0;i<nums.length;i++){
            nums[i]=target-nums[i];
        }
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length;j++){
                if (j!=i){
                    if (nums[i]+nums[j]==target){
                        return new int[]{i,j};
                    }
                }
            }
        }
        return null;
        //法二：使用哈希表
    }
}
