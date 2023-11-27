package 每日一题;

public class 最长奇偶子数组 {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int count=0;
        int result=0;
        boolean f=false;//没开头
        for (int i=0;i<nums.length;i++){
            //判断开头
            if(!f){
                if (nums[i]%2==0 && nums[i]<=threshold){
                    f=true;
                    count=1;
                }
            }else {
                //有开头的情况
                if (nums[i]%2!=nums[i-1]%2 && nums[i]<=threshold){
                    count++;
                }else {
                    result=Math.max(result,count);
                    if (nums[i]%2==0 && nums[i]<=threshold) {
                        count = 1;
                        continue;
                    }
                    f=false;
                }
            }
        }
        result=Math.max(result,count);
        return result;
    }
}
