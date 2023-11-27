package 第369场周赛;

public class 数组的最小相等和 {
    public static long minSum(int[] nums1, int[] nums2) {
        long sum1=0,sum2=0;
        long f1=0,f2=0;
        for (int e:nums1){
            if (e==0)
                f1++;
            sum1+=e;
        }
        System.out.println(sum1);
        for (int e:nums2){
            if (e==0)
                f2++;
            sum2+=e;
        }
        System.out.println(sum2);
        if (f1==0){
            if (f2==0)
                return sum1==sum2?sum1:-1;
            else {
                if (sum2+f2>sum1)
                    return -1;
                else
                    return sum1;
            }
        }else{
            if (f2==0){
                if (sum1+f1>sum2)
                    return -1;
                else
                    return sum2;
            }
            else {
                return Math.max(sum1+f1,sum2+f2);
            }
        }
    }

    public static void main(String[] args) {
        int[] s1={0,17,20,17,5,0,14,19,7,8,16,18,6};
        int[] s2={21,1,27,19,2,2,24,21,16,1,13,27,8,5,3,11,13,7,29,7};
        System.out.println(minSum(s1,s2));
    }
}
