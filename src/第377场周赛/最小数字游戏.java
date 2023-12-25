package 第377场周赛;

import java.util.Arrays;

public class 最小数字游戏 {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] r=new int[nums.length];
        for (int i=0;i<nums.length;i+=2){
            r[i]=nums[i+1];
            r[i+1]=nums[i];
        }
        return r;
    }
}
