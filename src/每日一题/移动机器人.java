package 每日一题;

import java.util.Arrays;

public class 移动机器人 {
    public int sumDistance(int[] nums, String s, int d) {
        int MOD=(int)1e9+7;
        for (int i=0;i<nums.length;i++){
            if (s.charAt(i)=='L'){
                nums[i]=(int)((long)(nums[i]-d)%MOD);
            }else{
                nums[i]=(int)((long)(nums[i]+d)%MOD);
            }
        }
        Arrays.sort(nums);
        long[] pre=new long[nums.length];
        for (int i=1;i<nums.length;i++){
            pre[i]=(pre[i-1]+Math.abs((long)nums[i-1]-nums[i])*i)%MOD;
        }
//        long[] suf=new long[nums.length];
//        for (int i=nums.length-2;i>=0;i--){
//            suf[i]=(suf[i+1]+Math.abs((long)nums[i]-nums[i+1])*(nums.length-1-i))%MOD;
//        }
        long result=0;
        for (int i=0;i<nums.length;i++) {
            result = (result + pre[i]) % MOD;
            System.out.println("pre"+pre[i]);
//            System.out.println("suf"+suf[i]);
            System.out.println("+++++++++++++++++");
        }
        return (int)result;
    }

    public static void main(String[] args) {
        移动机器人 t=new 移动机器人();
        int[] s={-2,0,2};
        System.out.println(t.sumDistance(s,"RLL",3));
    }
}
