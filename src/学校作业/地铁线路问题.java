package 学校作业;

import java.util.*;

public class 地铁线路问题 {
    private static Map<String,Integer> map;
    private static List<Integer>[] g;
    private static boolean[] f;
    static {
        map=new HashMap<>();
        map.put("A10",1);
        map.put("A11",2);
        map.put("A12",3);
        map.put("A13",4);
        map.put("A14",5);
        map.put("A15",6);
        map.put("A16",7);
        map.put("A17",8);
        map.put("B1",9);
        map.put("B2",10);
        map.put("B3",11);
        map.put("B4",12);
        map.put("B5",13);
        map.put("B6",14);
        g=new ArrayList[15];
        for (int i = 0; i < g.length; i++) {
            g[i]=new ArrayList<>();
        }
        g[1].add(2);
        g[2].add(1);
        g[2].add(3);
        g[3].add(2);
        g[3].add(4);
        g[3].add(9);
        g[3].add(14);
        g[4].add(3);
        g[4].add(5);
        g[5].add(4);
        g[5].add(6);
        g[6].add(5);
        g[6].add(7);
        g[6].add(11);
        g[6].add(12);
        g[7].add(6);
        g[7].add(8);
        g[8].add(7);
        g[9].add(3);
        g[9].add(10);
        g[10].add(9);
        g[10].add(11);
        g[11].add(10);
        g[11].add(6);
        g[12].add(6);
        g[12].add(13);
        g[13].add(12);
        g[13].add(14);
        g[14].add(3);
        g[14].add(13);
        f=new boolean[15];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入出发点：");
        String a=sc.next();
        System.out.print("请输入结束点：");
        String b=sc.next();
        System.out.println(a+"到"+b+"的最短距离为："+fun(a,b));
    }

    private static int fun(String a,String b){
        if (a.equals(b))
            return 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(map.get(a));
        queue.add(-1);
        f[map.get(a)]=true;
        int c=0;
        while (!queue.isEmpty()){
            Integer e = queue.poll();
            if (e==-1){
                c++;
                queue.add(-1);
                continue;
            }
            if (e==map.get(b))
                return c;
            for (Integer i : g[e]) {
                if (!f[i]){
                    f[i]=true;
                    queue.add(i);
                }
            }
        }
        return -1;
    }
}
