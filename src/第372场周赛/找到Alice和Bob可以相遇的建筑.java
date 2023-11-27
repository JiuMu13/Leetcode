package 第372场周赛;

import java.util.*;

public class 找到Alice和Bob可以相遇的建筑 {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        //离线做法：按照自定义的顺序回答queries
        int n=heights.length;
        int[] res=new int[queries.length];
        Arrays.fill(res,-1);
        List<int[]>[] lists=new ArrayList[n];
        Arrays.setAll(lists,a->new ArrayList<>());
        for (int i=0;i<queries.length;i++){
            int a=queries[i][0],b=queries[i][1];
            if (a>b){ int temp=a; a=b; b=temp; }
            if (a==b || heights[a]<heights[b])
                res[i]=b;
            else {
                lists[b].add(new int[]{heights[a],i});//0为房屋高度，1为询问索引
            }
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0]-t2[0];
            }
        });
        for (int i=0;i<n;i++){
            while (!pq.isEmpty() && pq.peek()[0]<heights[i]){
                res[pq.poll()[1]]=i;
            }
            for (int[] e:lists[i]){
                pq.offer(e);
            }
        }
        return res;
    }
}
