package 第378场周赛;

public class 检查按位或是否存在尾随零 {
    public boolean hasTrailingZeros(int[] nums) {
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                if (((nums[i] | nums[j])&1)==0){
                    return true;
                }
            }
        }
        return false;
    }
}
