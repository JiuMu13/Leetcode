package 每日一题;

public class 美化数组的最少删除数 {
    public int minDeletion(int[] nums) {
        if (nums.length==0)
            return 0;
        int delCount=0;
        for(int i=1;i<nums.length;){
            if (nums[i]==nums[i-1]){
                delCount++;
                i++;
            }else {
                i+=2;
            }
        }
        if ((nums.length-delCount)%2==0)
            return delCount;
        else
            return delCount+1;
    }
}
