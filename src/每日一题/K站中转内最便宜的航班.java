package 每日一题;

import java.util.Arrays;

public class K站中转内最便宜的航班 {
    private class Edge{
        int from;
        int to;
        int price;

        public Edge(int from, int to, int price) {
            this.from = from;
            this.to = to;
            this.price = price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] sumPrice=new int[n];
        int[] bf;
        Edge[] g=new Edge[flights.length];
        for (int i = 0; i <flights.length ; i++) {
            g[i]=new Edge(flights[i][0],flights[i][1],flights[i][2]);
        }
        Arrays.fill(sumPrice,Integer.MAX_VALUE/2);
        sumPrice[src]=0;
        for (int i=0;i<k+1;i++){
            bf=Arrays.copyOfRange(sumPrice,0,n);
            for (int j=0;j<flights.length;j++){
                sumPrice[g[j].to]=Math.min(sumPrice[g[j].to],bf[g[j].from]+g[j].price);
            }
        }
        return sumPrice[dst]>=Integer.MAX_VALUE/2?-1:sumPrice[dst];
    }

    public static void main(String[] args) {
        K站中转内最便宜的航班 t=new K站中转内最便宜的航班();
        int[][] s={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        System.out.println(t.findCheapestPrice(4,s,0,3,1));
    }
}
