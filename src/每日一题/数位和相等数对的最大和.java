package 每日一题;

import java.util.HashMap;
import java.util.Map;

public class 数位和相等数对的最大和 {
    public int maximumSum(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int result=-1;
        for (int e:nums){
            int sum=0,f=e;
            while (f!=0){
                sum+=f%10;
                f/=10;
            }
            if (map.containsKey(sum)){
                result=Math.max(result,map.get(sum)+e);
                map.put(sum,Math.max(map.get(sum),e));
            }else {
                map.put(sum,e);
            }
        }
        return result;
    }
}
