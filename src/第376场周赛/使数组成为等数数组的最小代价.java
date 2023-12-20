package 第376场周赛;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
//此题也可先枚举出所有范围内的回文数，然后通过二分找到与中位数距离最近的回文数，最后求和
public class 使数组成为等数数组的最小代价 {
    public long minimumCost(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        //选取中位数
        int t=nums[n/2];

        int p=getpal(t);
        long r1=0;
        for (int e:nums)
            r1+=Math.abs(p-e);
        if (t==p)
            return r1;
        long r2=0;
        if (p>t){
            p=getpalless(t);
            for (int e:nums)
                r2+=Math.abs(p-e);
        }else {
            p=getpalmore(t);
            for (int e:nums)
                r2+=Math.abs(p-e);
        }
        return Math.min(r1,r2);
    }
    private int getpal(int n){
        Deque<Integer> st=new ArrayDeque<>();
        while (n!=0){
            st.push(n%10);
            n/=10;
        }
        int l=st.size();
        for (int i=0;i<l/2;i++)
            st.removeLast();
        StringBuilder sb=new StringBuilder();
        if (l%2!=0){
            sb.append(st.removeLast());
        }
        l=st.size();
        for (int i=0;i<l;i++){
            int t=st.removeLast();
            sb.append(t);
            sb.insert(0,t);
        }
        return Integer.parseInt(sb.toString());
    }
    private int getpalmore(int n){
        if (n<9)
            return n+1;
        if(n==9)
            return 11;
        Deque<Integer> st=new ArrayDeque<>();
        int t=n,f=0;
        while (n!=0){
            f++;
            n/=10;
        }
        t+=Math.pow(10,f/2);
        while (t!=0){
            st.push(t%10);
            t/=10;
        }
        int l=st.size();
        for (int i=0;i<l/2;i++)
            st.removeLast();
        StringBuilder sb=new StringBuilder();
        if (l%2!=0){
            sb.append(st.removeLast());
        }
        l=st.size();
        for (int i=0;i<l;i++){
            int tt=st.removeLast();
            sb.append(tt);
            sb.insert(0,tt);
        }
        return Integer.parseInt(sb.toString());
    }
    private int getpalless(int n){
        if (n<11)
            return n-1;
        Deque<Integer> st=new ArrayDeque<>();
        int t=n,f=0;
        while (n!=0){
            f++;
            n/=10;
        }
        t-=Math.pow(10,f/2);
        while (t!=0){
            st.push(t%10);
            t/=10;
        }
        int l=st.size();
        for (int i=0;i<l/2;i++)
            st.removeLast();
        StringBuilder sb=new StringBuilder();
        if (l%2!=0){
            sb.append(st.removeLast());
        }
        l=st.size();
        for (int i=0;i<l;i++){
            int tt=st.removeLast();
            sb.append(tt);
            sb.insert(0,tt);
        }
        return Integer.parseInt(sb.toString());
    }
    public static void main(String[] args) {
        使数组成为等数数组的最小代价 t=new 使数组成为等数数组的最小代价();
        System.out.println(t.minimumCost(new int[]{9,10,10}));
    }
}
