package 每日一题;

import java.util.*;

public class 每棵子树内缺失的最小基因值 {
    int[] nums;
    int[] res;
    List<Integer>[] l;
    Set<Integer>[] geneSet;
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        this.nums=nums;
        res=new int[n];
        l = new List[n];
        for (int i = 0; i < n; i++) {
            l[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i < n; i++) {
            l[parents[i]].add(i);
        }
        Arrays.fill(res, 1);
        geneSet = new Set[n];
        for (int i = 0; i < n; i++) {
            geneSet[i] = new HashSet<Integer>();
        }
        dfs(0);
        return res;
    }

    public int dfs(int node) {
        geneSet[node].add(nums[node]);
        for (int child : l[node]) {
            res[node] = Math.max(res[node], dfs(child));
            if (geneSet[node].size() < geneSet[child].size()) {
                Set<Integer> temp = geneSet[node];
                geneSet[node] = geneSet[child];
                geneSet[child] = temp;
            }
            geneSet[node].addAll(geneSet[child]);
        }
        while (geneSet[node].contains(res[node])) {
            res[node]++;
        }
        return res[node];
    }
}
