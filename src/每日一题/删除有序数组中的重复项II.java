package 每日一题;

public class 删除有序数组中的重复项II {
    public int removeDuplicates(int[] nums) {
        int f=0,l=0;
        int length=nums.length;
        for (int i=1;i<length;i++){
            nums[i]=nums[i+l];
            if (nums[i]==nums[i-1]){
                f++;
            }else {
                f=0;
            }
            if (f==2){
                l++;
                length--;
                i--;
                f=1;
            }
        }
        return length;
    }
}
