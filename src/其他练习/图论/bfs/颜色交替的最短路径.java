package 其他练习.图论.bfs;

import java.util.*;

public class 颜色交替的最短路径 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 颜色交替的最短路径().shortestAlternatingPaths(3, new int[][]{{0, 1}, {1, 2}}, new int[][]{})));
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] rg = new List[n];
        List<Integer>[] bg = new List[n];
        Arrays.setAll(rg, e -> new ArrayList<>());
        Arrays.setAll(bg, e -> new ArrayList<>());
        for (int[] redEdge : redEdges) {
            rg[redEdge[0]].add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            bg[blueEdge[0]].add(blueEdge[1]);
        }
        int[] r = new int[n];
        Set<Integer> set = new HashSet<>();
        Arrays.fill(r, Integer.MAX_VALUE);
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] t = q.remove();
            int v = t[0], w = t[1];
            r[Math.abs(v)]=Math.min(r[Math.abs(v)],w);
            if (v <= 0)
                for (Integer e : rg[-v]) {
                    if (!set.contains(e)) {
                        set.add(e);
                        q.add(new int[]{e, w + 1});
                    }
                }
            if (v >= 0)
                for (Integer e : bg[v]) {
                    if (!set.contains(-e)) {
                        set.add(-e);
                        q.add(new int[]{-e, w + 1});
                    }
                }
        }
        for (int i = 0; i < r.length; i++) {
            if (r[i]==Integer.MAX_VALUE)
                r[i]=-1;
        }
        return r;
    }
}
