package 每日一题;

import java.util.ArrayList;
import java.util.List;

public class 到达首都的最少油耗 {
    List<Integer>[] g;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n=roads.length+1;
        Seats=seats;
        g=new List[n];
        for(int i=0;i<n;i++)
            g[i]=new ArrayList<>();
        for (int[] e:roads) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        dfs(0,0);
        return sum;
    }
    long sum=0;
    int Seats;
    private int dfs(int n,int preN){
        int currPeople=1;
        for(Integer e:g[n]){
            if (e==preN)
                continue;
            int t=dfs(e,n);
            sum+=(Seats-1+t)/Seats;
            currPeople+=t;
        }
        return currPeople;
    }

    public static void main(String[] args) {
        到达首都的最少油耗 t=new 到达首都的最少油耗();
        int[][] s={{0,1},{0,2},{1,3},{1,4}};
        System.out.println(t.minimumFuelCost(s,5));
    }
}
