package 每日一题;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 参加会议的最多员工数 {
    List<Integer>[] lists;
    public int maximumInvitations(int[] favorite) {
        lists=new List[favorite.length];
        for (int i=0;i<favorite.length;i++)
            lists[i]=new ArrayList<>();
        int[] rd=new int[favorite.length];
        for (int e:favorite)
            rd[e]++;
        Queue<Integer> q=new ArrayDeque<>();
        for (int i=0;i<rd.length;i++)
            if (rd[i]==0)  q.add(i);
        while(!q.isEmpty()){
            int x=q.poll();
            int y=favorite[x];
            lists[y].add(x);
            if (--rd[y]==0)
                q.add(y);
        }
        int maxRingSize = 0, sumChainSize = 0;
        for (int i = 0; i < favorite.length; i++) {
            if (rd[i] == 0) continue;
            rd[i] = 0;
            int ringSize = 1;
            for (int x = favorite[i]; x != i; x = favorite[x]) {
                rd[x] = 0;
                ringSize++;
            }
            if (ringSize == 2) {
                // 基环长度为 2
                sumChainSize += rdfs(i) + rdfs(favorite[i]);
            } else {
                maxRingSize = Math.max(maxRingSize, ringSize);
            }
        }
        return Math.max(maxRingSize, sumChainSize);
    }
    private int rdfs(int x) {
        int maxDepth = 1;
        for (int son : lists[x]) {
            maxDepth = Math.max(maxDepth, rdfs(son) + 1);
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        参加会议的最多员工数 t=new 参加会议的最多员工数();
        System.out.println(t.maximumInvitations(new int[]{3,0,1,4,1}));
    }
}
