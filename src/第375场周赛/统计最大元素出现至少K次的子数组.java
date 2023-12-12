package 第375场周赛;

import java.util.ArrayList;
import java.util.List;

public class 统计最大元素出现至少K次的子数组 {
    public long countSubarrays(int[] nums, int k) {
        int n=nums.length;
        int max=0;
        for (int e:nums) max=e>max?e:max;
        List<Integer> list=new ArrayList<>();
        for (int i=0;i<n;i++){
            if (nums[i]==max)
                list.add(i);
        }
        long result=0;
        int last=-1;
        for (int i=0;i+k<=list.size();i++){
            result+=(long)(list.get(i)-last)*(n-list.get(i+k-1)+1);
            last=list.get(i);
        }
        return result;
    }
}
