package 第365场周赛;

public class 无限数组的最短子数组 {
    public int minSizeSubarray(int[] nums, int target) {
        int sum=0;
        int n=nums.length;
        int f=0,s=0;
        for (int i = 0; i <n ; i++) {
            sum+=nums[i];
        }
        int result=0,resultLength=Integer.MAX_VALUE;
        int l=target/sum+2;
        for ( s=0;s<l*n;s++){
            result+=nums[s%n];
            while (result>target && f<s){
                result-=nums[f%n];
                f++;
            }
            if (result==target)
                resultLength=Math.min(s-f+1,resultLength);
        }
        return resultLength==Integer.MAX_VALUE?-1:resultLength;
    }

    public static void main(String[] args) {
        无限数组的最短子数组 t= new 无限数组的最短子数组();

        System.out.println(t.minSizeSubarray(new int[]{5,5,4,1,2,2,2,3,2,4,2,5},56));
    }
}
