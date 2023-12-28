package 每日一题;

public class 收集巧克力 {
    public long minCost(int[] nums, int x) {
        int n=nums.length;
        int[] min=new int[n];
        long r=0;
        for (int i=0;i<n;i++)
            min[i]=nums[i];
        for (int e:min)
            r+=e;
        long fx=0;
        for (int i=1;i<=n;i++){
            fx+=x;
            long del=0;
            int t=nums[0];
            for (int j=0;j<n-1;j++){
                nums[j]=nums[j+1];
                if (min[j]>nums[j]){
                    del+=min[j]-nums[j];
                    min[j]=nums[j];
                }
            }
            nums[n-1]=t;
            if (min[n-1]>nums[n-1]) {
                del+=min[n-1]-nums[n-1];
                min[n-1] = nums[n - 1];
            }
            if (fx<del) {
                r -= del - fx;
                fx=0;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        收集巧克力 t=new 收集巧克力();
        System.out.println(t.minCost(new int[]{20,1,15},5));
    }
}
