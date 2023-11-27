package 第367场周赛;

public class 找出满足差值条件的下标一 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        for (int i=0;i<nums.length;i++){
            for (int j=i+indexDifference;j<nums.length;j++){
                if (Math.abs(nums[i]-nums[j])>=valueDifference)
                    return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
}
