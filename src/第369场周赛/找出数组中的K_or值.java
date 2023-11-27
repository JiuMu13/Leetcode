package 第369场周赛;

public class 找出数组中的K_or值 {
    public static int findKOr(int[] nums, int k) {
        int result=0;
        for (int i=0;i<31;i++){
            int sum=0;
            for (int j=0;j<nums.length;j++){
                if ((nums[j]&1<<i)==1<<i)
                    sum++;
                if (sum==k){
                    result+=(1<<i);
                    break;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(findKOr(new int[]{7,12,9,8,9,15},4));
    }
}
