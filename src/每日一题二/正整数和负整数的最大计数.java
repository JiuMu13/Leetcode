package 每日一题二;

public class 正整数和负整数的最大计数 {
    public int maximumCount(int[] nums) {
        int n=nums.length;
        int l=0,r=n-1;
        while(l<r){
            int mid=(l+r+1)>>1;
            if(nums[mid]>0){
                r=mid-1;
            }else{
                l=mid;
            }
        }
        if (nums[l]<=0)
            l++;
        int l2=0,r2=n-1;
        while(l2<r2){
            int mid=(l2+r2)>>1;
            if(nums[mid]>=0){
                r2=mid;
            }else {
                l2=mid+1;
            }
        }
        if (nums[l2]<0)
            l2++;
        return Math.max(l2,n-l);
    }

    public static void main(String[] args) {
        System.out.println(new 正整数和负整数的最大计数().maximumCount(new int[]{-1,-1,-1,-1,-1,0,0,0,1,1,1,1,1,1}));
    }
}
