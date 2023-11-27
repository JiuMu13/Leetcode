package 每日一题;

import java.util.Collections;
import java.util.List;

public class 统计和小于目标的下标对数目 {
    public int countPairs(List<Integer> nums, int target) {
        if (nums.size()<=1)
            return 0;
        int result=0;
        Collections.sort(nums);
        int f=nums.size()-1;
        for(int i=0;i<nums.size()-1 && i<f;i++){
            while (nums.get(i)+nums.get(f)>=target && i<f){
                f--;
            }
            result+=f-i;
        }
        return result;
    }
}
