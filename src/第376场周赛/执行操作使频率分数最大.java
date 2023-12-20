package 第376场周赛;


import java.util.Arrays;

//1   ,2   ,6   ,8   ,9   ,16
//  1    2    2    1    1    1
public class 执行操作使频率分数最大 {
    public int maxFrequencyScore(int[] nums, long k) {
        int n=nums.length;
        Arrays.sort(nums);
        long[] pre=new long[n+1];
        for (int i=1;i<=n;i++){
            pre[i]=nums[i-1]+pre[i-1];
        }
        int l=0,r=0,max=0,mid;
        for ( ; r<n ; r++){
            mid=(l+r)>>1;
            while ((long)nums[mid]*(mid-l)-(pre[mid]-pre[l]) + (pre[r+1]-pre[mid+1]) - (long)nums[mid]*(r-mid) >k){
                l++;
                mid=(l+r)>>1;
            }
            max=Math.max(max,r-l+1);
        }
        return max;
    }

    public static void main(String[] args) {
        执行操作使频率分数最大 t=new 执行操作使频率分数最大();
        System.out.println(t.maxFrequencyScore(new int[]{14,4,23,27,8,25,7,12,12,21,21,11,20,23,30,11,12,29,22},77));
    }
}
