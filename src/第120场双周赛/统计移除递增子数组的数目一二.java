package 第120场双周赛;

public class 统计移除递增子数组的数目一二 {
    public long incremovableSubarrayCount(int[] nums) {
        int l=0,r=nums.length-1;
        //找到最长前缀
        for (int i=1;i<nums.length;i++){
            if (nums[i]>nums[i-1])
                l=i;
            else
                break;
        }
        if (l== nums.length-1)
            return (long)(l+2)*(l+1)/2;
        long result=l+2;
        while (l<r){
            while (l!=-1 && nums[l]>=nums[r]){
                l--;
            }
            result+=l+2;
            r--;
            if (nums[r]>=nums[r+1])
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        统计移除递增子数组的数目一二 t=new 统计移除递增子数组的数目一二();
        System.out.println(t.incremovableSubarrayCount(new int[]{9,2,5}));
    }
}
