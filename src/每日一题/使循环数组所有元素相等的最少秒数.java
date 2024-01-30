package 每日一题;

import java.util.*;

public class 使循环数组所有元素相等的最少秒数 {
    public static int minimumSeconds(List<Integer> nums) {
        int n=nums.size();
        Map<Integer,int[]> map=new HashMap<>();
        int r=Integer.MAX_VALUE;
        for (int i=0;i<n;i++){
            int t=nums.get(i);
            if (map.containsKey(t)){
                int[] s=map.get(t);
                s[2]=Math.max(s[2],i-s[1]);
                s[1]=i;
                r=Math.min(r,Math.max(s[2],s[0]-i+n));
            }else {
                map.put(t,new int[]{i,i,-1});
            }
        }
        return r==Integer.MAX_VALUE?n/2:r/2;
    }

    public static void main(String[] args) {
        List<Integer> l=Arrays.asList(2,1,3,3,2);
        System.out.println(minimumSeconds(l));
    }
}
