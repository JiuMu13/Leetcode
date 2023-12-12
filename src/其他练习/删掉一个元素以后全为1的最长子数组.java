package 其他练习;

public class 删掉一个元素以后全为1的最长子数组 {
    public int longestSubarray(int[] nums) {
        int l=0,r;
        boolean f=false;
        int max=0;
        for (r=0;r<nums.length;r++){
            if (nums[r]==0){
                if (!f){
                    f=true;
                    max=r-l;
                }else {
                    while (nums[l]!=0)
                        l++;
                    l++;
                }
            }else {
                max=Math.max(max,r-l);
            }
        }
        return max;
    }
}
