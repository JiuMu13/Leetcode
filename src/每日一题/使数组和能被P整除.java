package 每日一题;

import java.util.HashMap;
import java.util.Map;

public class 使数组和能被P整除 {
    public static int minSubarray(int[] nums, int p) {
        int min=nums.length;
        int[] sumpre=new int[nums.length+1];
        for (int i=1;i<=nums.length;i++){
            sumpre[i]=(sumpre[i-1]+nums[i-1])%p;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<=nums.length;i++){
            map.put(sumpre[i],i);
            int j=map.getOrDefault(((sumpre[i]-sumpre[nums.length])%p+p)%p,-nums.length);
            min=Math.min(min,i-j);
        }
        return min<nums.length?min:-1;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{6,3,5,2};
        System.out.println(minSubarray(nums,9));
    }
}
