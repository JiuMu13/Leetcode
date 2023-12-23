package 其他练习;

public class 最长递增子序列 {

    //动态规划做法
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int r=0;
        for (int i=0;i<n;i++){
            for (int j=0;j<i;j++){
                if (nums[j]<nums[i])
                    dp[i]=Math.max(dp[i],dp[j]);
            }
            dp[i]++;
            r=Math.max(dp[i],r);
        }
        return r;
    }
    //贪心+二分
    //如果我们要使上升子序列尽可能的长，则我们需要让序列上升得尽可能慢，
    //因此我们希望每次在上升子序列最后加上的那个数尽可能的小。
    //定义r[i]为长度为i+1的递增子序列的最大元素值
    public int lengthOfLIS2(int[] nums) {
        int n=nums.length;
        int[] r=new int[n];
        int f=0;
        for (int i=0;i<n;i++){
            int t=more(nums[i],r,f);
            if (t==f){
                r[f++]=nums[i];
            }else {
                r[t]=nums[i];
            }
        }
        return f;
    }
    private int more(int n,int[] s,int f){
        int l=0,r=f-1;
        while (l<r){
            int mid=(l+r)>>1;
            if (s[mid]<n){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        if (l==r && n>s[l])
            return l + 1;
        return l;
    }
}
