package 第371场周赛;

import java.util.Map;

public class 最大化数组末位元素的最少操作次数 {
    public int minOperations(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int maxSmallf=0;
        int maxf=0;
        int count=0;
        int count2=0;
        int rsmall=Math.min(nums1[n-1],nums2[n-1]);
        int rsbig=Math.max(nums1[n-1],nums2[n-1]);
        for (int i=0;i<n-1;i++){
            if (nums1[i]>nums2[i]){
                maxSmallf=Math.max(maxSmallf,nums2[i]);
                if (nums1[i]>rsmall)
                    count++;
            }else {
                maxSmallf=Math.max(maxSmallf,nums1[i]);
                if (nums2[i]>rsmall)
                    count2++;
            }
            if (maxSmallf>rsmall)
                return -1;
            maxf=Math.max(maxf,Math.max(nums1[i],nums2[i]));
            if (maxf>rsbig)
                return -1;
        }
        if (nums1[n-1]>nums2[n-1]){
            count++;
        }else if (nums1[n-1]<nums2[n-1])
            count2++;
        return Math.min(count,count2);
    }
}
