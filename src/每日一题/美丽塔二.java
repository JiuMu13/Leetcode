package 每日一题;

import java.util.*;

public class 美丽塔二 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n=maxHeights.size();
        Deque<Integer> st=new ArrayDeque<>();
        long[] pre=new long[n];
        long[] suf=new long[n+1];
        long curr=0;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && maxHeights.get(st.peek()) > maxHeights.get(i)) {
                int f=-1;
                int t=st.pop();
                if (!st.isEmpty()){
                    f=st.peek();
                }
                curr -= (long)(t - f) * (maxHeights.get(t) - maxHeights.get(i));
            }
            st.push(i);
            curr += maxHeights.get(i);
            pre[i] = curr;
        }
        curr=0;
        st.clear();
        for (int i = n-1; i >=0; i--) {
            while (!st.isEmpty() && maxHeights.get(st.peek()) > maxHeights.get(i)) {
                int f=n;
                int t=st.pop();
                if (!st.isEmpty()){
                    f=st.peek();
                }
                curr -= (long)(f-t) * (maxHeights.get(t) - maxHeights.get(i));
            }
            st.push(i);
            curr += maxHeights.get(i);
            suf[i] = curr;
        }
        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(suf));

        long r=0;
        for (int i=0;i<n;i++)
            r=Math.max(r,pre[i]+suf[i+1]);
        return r;
    }

    public static void main(String[] args) {
        美丽塔二 t=new 美丽塔二();
        //1,6,4,3,5
        List<Integer> list=new ArrayList<Integer>(Arrays.asList(new Integer[]{5,3,4,1,1}));
        System.out.println(t.maximumSumOfHeights(list));
    }
}
