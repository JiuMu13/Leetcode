package 每日一题;

import java.util.HashMap;
import java.util.Map;

public class 统计一个数组中好对子的数目 {
    int rev(int num){
        int result=0;
        while (num!=0){
            result*=10;
            result+=num%10;
            num/=10;
        }
        return result;
    }
    public int countNicePairs(int[] nums) {
        int n=nums.length;
        int y=1000000007;
        Map<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < n; i++) {
            int c=nums[i]-rev(nums[i]);
            if (map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }

        long result=0;
        for (Integer e:map.values())
            result=(result+(long)e * (e-1) / 2)%y;
        return (int)result;
    }

    public static void main(String[] args) {
        统计一个数组中好对子的数目 t=new 统计一个数组中好对子的数目();
        int[] s={432835222,112141211,5408045,456281503,283322436,414281561,37773,286505682};
        System.out.println(t.countNicePairs(s));
    }
}
