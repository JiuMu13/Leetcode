package 每日一题二;

import java.util.*;

public class 公交路线 {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source==target)
            return 0;
        int bn=routes.length;
        //构造映射
        Map<Integer, Set<Integer>> map=new HashMap<>();
        Map<Integer,Set<Integer>> bus=new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int s : routes[i]) {
                set.add(s);
                if (!bus.containsKey(s))
                    bus.put(s,new HashSet<>());
                Set<Integer> se = bus.get(s);
                se.add(i);
            }
            map.put(i,set);
        }
        int curr=1;
        int flag=-1;
        //存储车编号
        Queue<Integer> q=new ArrayDeque<>();
        boolean[] bf=new boolean[bn];
        Set<Integer> set = bus.getOrDefault(source,new HashSet<>());
        q.addAll(set);
        q.add(flag);
        Set<Integer> road=new HashSet<>();
        while (!q.isEmpty()){
            Integer e = q.poll();
            if (e==flag){
                curr++;
                //当前轮次结束
                Set<Integer> su=new HashSet<>();
                for (Integer i : road) {
                    su.addAll(bus.getOrDefault(i,new HashSet<>()));
                }
                for (Integer i : su) {
                    if (!bf[i])
                        q.add(i);
                }
                if (q.isEmpty())
                    return -1;
                road.clear();
                q.add(flag);
                continue;
            }
            bf[e]=true;
            Set<Integer> r = map.getOrDefault(e,new HashSet<>());
            if (r.contains(target)){
                return curr;
            }
            road.addAll(map.getOrDefault(e,new HashSet<>()));
        }
        return -1;
    }

    public static void main(String[] args) {
        公交路线 a = new 公交路线();
        int i = a.numBusesToDestination(new int[][]{{1,2,7},{3,6,7}}, 8, 6);
        System.out.println(i);
    }
}
