package 其他练习.图论.拓扑排序;

import java.util.*;

public class 可以到达所有点的最少点数目 {
    public static void main(String[] args) {
        List<List<Integer>> edges=new ArrayList<>();
        for (int i = 0; i < 5; i++)
            edges.add(new ArrayList<>());
        edges.get(0).addAll(Arrays.asList(0,1));
        edges.get(1).addAll(Arrays.asList(0,2));
        edges.get(2).addAll(Arrays.asList(2,5));
        edges.get(3).addAll(Arrays.asList(3,4));
        edges.get(4).addAll(Arrays.asList(4,2));
        System.out.println(findSmallestSetOfVertices(6,edges));
    }
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] d = new int[n];
        for (List<Integer> edge : edges) {
            d[edge.get(1)]++;
        }
        List<Integer> r=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (d[i]==0)
                r.add(i);
        }
        return r;
    }
}
