package 第367场周赛;

import java.util.Arrays;
import java.util.Comparator;

public class 找出满足差值条件的下标二 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n=nums.length;
        int[] suf=new int[n+1];
        int[] sufi=new int[n+1];
        suf[n]=-1;
        int[] suf2=new int[n+1];
        int[] suf2i=new int[n+1];
        suf2[n]=(int)1e9+1;
        for (int i=n-1;i>=0;i--){
            if (suf[i+1]>nums[i]){
                suf[i]=suf[i+1];
                sufi[i]=sufi[i+1];
            }else {
                suf[i]=nums[i];
                sufi[i]=i;
            }
        }
        for (int i=n-1;i>=0;i--){
            if (suf2[i+1]<nums[i]){
                suf2[i]=suf2[i+1];
                suf2i[i]=suf2i[i+1];
            }else {
                suf2[i]=nums[i];
                suf2i[i]=i;
            }
        }
        for (int i=0;i+indexDifference<n;i++){
            if (suf[i+indexDifference]-nums[i]>=valueDifference )
                return new int[]{i,sufi[i+indexDifference]};
            if (nums[i]-suf2[i+indexDifference]>=valueDifference)
                return new int[]{i,suf2i[i+indexDifference]};
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        找出满足差值条件的下标二 t=new  找出满足差值条件的下标二();
        int[] s={5,1,4,1};
        System.out.println(t.findIndices(s,2,4));
    }
}
