package 第368场周赛;

import java.util.*;
//贪心+枚举
public class 合法分组的最少组数 {
    public int minGroupsForValidAssignment(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1);
            else
                map.put(nums[i],1);
        }
        List<Integer> list=new ArrayList<>(map.values());
        Collections.sort(list);
        int z=list.get(0);
        while (true){
            int result=0;
            for (int i=0;i<list.size();i++){
                int t=list.get(i);
                if (t%z>t/z) {
                    result = 0;
                    break;
                }else
                    result+=(t+z)/(z+1);
            }
            if (result>0)
                return result;
            z--;
        }
    }
    public static void main(String[] args) {
        合法分组的最少组数  t=new 合法分组的最少组数();
        int[] s={10,10,10,3,1,1};
        System.out.println(t.minGroupsForValidAssignment(s));
    }
}
