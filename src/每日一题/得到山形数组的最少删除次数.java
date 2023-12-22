package 每日一题;

import java.util.*;

public class 得到山形数组的最少删除次数 {
    //法一：动态规划+记忆化搜索
    int[] nums;
    int N;
    public int minimumMountainRemovals(int[] nums) {
        this.nums=nums;
        N=nums.length;
        left=new int[N];
        right=new int[N];
        int max=0;
        for (int i=0;i<N;i++){
            int tl=left(i);
            int tr=right(i);
            if (tl>1 && tr>1)
                max=Math.max(max,tl+tr-1);
        }
        return N-max;
    }
    int[] left;
    private int left(int n){
        if (left[n]!=0)
            return left[n];
        for (int i=0;i<n;i++){
            if (nums[i]<nums[n])
                left[n]=Math.max(left[n],left(i));
        }
        return ++left[n];
    }
    int[] right;
    private int right(int n){
        if (right[n]!=0)
            return right[n];
        for (int i=N-1;i>n;i--){
            if (nums[i]<nums[n])
                right[n]=Math.max(right[n],right(i));
        }
        return ++right[n];
    }
    //用数组递推实现动态规划

    //贪心+二分
    public int minimumMountainRemovals2(int[] nums){
        int n=nums.length;
        List<Integer> l=new ArrayList<>();
        int[] pre=new int[n];
        int[] suf=new int[n];
        for (int i=0;i<n;i++){
            int t=binarySearch(nums[i],l);
            if (l.isEmpty() || t==l.size()-1 && nums[i]>l.get(t)){
                l.add(nums[i]);
            }else {
                l.set(t,nums[i]);
            }
            pre[i]=l.size();
        }
        l.clear();
        for (int i=n-1;i>=0;i--){
            int t=binarySearch(nums[i],l);
            if (l.isEmpty() || t==l.size()-1 && nums[i]>l.get(t)){
                l.add(nums[i]);
            }else {
                l.set(t,nums[i]);
            }
            suf[i]=l.size();
        }
        int max=0;
        for (int i=0;i<n;i++){
            if (pre[i]!=1 && suf[i]!=1)
                max=Math.max(max,pre[i]+suf[i]-1);
        }
        return n-max;
    }
    private int binarySearch(int n,List<Integer> list){
        int l=0,r=list.size()-1;
        while (l<r){
            int mid=(l+r)>>1;
            if (list.get(mid)<n){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        return l;
    }


    public static void main(String[] args) {
        得到山形数组的最少删除次数 t=new 得到山形数组的最少删除次数();
//        System.out.println(t.minimumMountainRemovals(new int[]{100,92,89,77,74,66,64,66,64}));
        System.out.println(t.minimumMountainRemovals2(new int[]{100,92,89,77,74,66,64,66,64}));
//        List<Integer> list=new ArrayList<>();
//        list.add(1);
//        list.add(4);
//        list.add(6);
//        list.add(8);
//        list.add(8);
//        list.add(10);
//        System.out.println(t.binarySearch(9,list));
    }
}
