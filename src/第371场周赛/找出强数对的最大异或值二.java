package 第371场周赛;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//与  数组中两个数的最大异或值  相似
public class 找出强数对的最大异或值二 {
    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);
        int result=0;
        int t=0;
        Map<Integer,Integer> map=new HashMap<>();
        int high=31-Integer.numberOfLeadingZeros(nums[nums.length-1]);
        for (int i=high;i>=0;i--){
            t=t | 1<<i;
            map.clear();
            int f=result | 1<<i;
            for (int e:nums){
                int mask=e & t;
                if (map.containsKey(mask^f) && e<=2*map.get(mask^f) ){
                    result=f;
                    break;
                }
                map.put(mask,e);
            }
        }
        return result;
    }
}
