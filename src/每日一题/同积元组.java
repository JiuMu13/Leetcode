package 每日一题;

import java.util.*;

public class 同积元组 {
    public int tupleSameProduct(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int count=0;
        for (int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                int t=nums[i]*nums[j];
                if (map.containsKey(t))
                    map.put(t,map.get(t)+1);
                else
                    map.put(t,1);
            }
        }
        List<Integer> l=new ArrayList<>(map.values());
        for (Integer e:l)
            count+=e*(e-1)/2;
        return count*8;
    }
}
