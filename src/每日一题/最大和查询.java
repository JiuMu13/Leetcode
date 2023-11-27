package 每日一题;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class 最大和查询 {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n=nums1.length;
        int[][] sum=new int[n][2];
        for (int i=0;i<n;i++){
            sum[i][0]=nums1[i];
            sum[i][1]=nums2[i];
        }
        int[][] qq=new int[queries.length][3];//0为查询原位置
        for(int i=0;i<queries.length;i++){
            qq[i][0]=i;
            qq[i][1]=queries[i][0];
            qq[i][2]=queries[i][1];
        }
        Arrays.sort(qq, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t2[1]-t1[1];
            }
        });
        Arrays.sort(sum, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t2[0]-t1[0];
            }
        });
        Stack<int[]> st=new Stack<>();//0为y,1为sum
        int[] result=new int[queries.length];
        for (int i=0,j=0;i<qq.length;i++){
            int rn=qq[i][0],x=qq[i][1],y=qq[i][2];
            for (;j<n && sum[j][0]>=x;j++){
                while (!st.isEmpty() && st.peek()[1]<=sum[j][0]+sum[j][1] ){
                    st.pop();
                }
                if (st.isEmpty() || st.peek()[0]<sum[j][1]){
                    st.push(new int[]{sum[j][1],sum[j][0]+sum[j][1]});
                }
            }
            result[rn]=ef(st,y);
        }
        return result;
    }
    private int ef(Stack<int[]> st,int n){
        int l=-1,r=st.size();
        while (l+1<r){
            int mid=(l+r)>>1;
            if (st.get(mid)[0]>=n){
                r=mid;
            }else {
                l=mid;
            }
        }
        if(r>=st.size())
            return -1;
        return st.get(r)[1];
    }
}
