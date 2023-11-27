package 每日一题;

public class 加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        int start=0,end=0;
        int dqgas=0;
        while (true){
            if (dqgas+gas[end]>=cost[end]){
                dqgas+=gas[end]-cost[end];
                end++;
                if (end==n)
                    return start;

            }else {
                if (start==0)
                    start=n-1;
                else
                    start--;
                while (dqgas+gas[start]-cost[start]<cost[end]-gas[end]){
                    dqgas+=gas[start]-cost[start];
                    if (start==0)
                        start=n-1;
                    else
                        start--;
                    if (start==end)
                        return -1;
                }
                dqgas+=gas[start]-cost[start]-(cost[end]-gas[end]);
                end++;
                if (end==n)
                    return start;
            }
        }
    }

    public static void main(String[] args) {
        加油站 t=new 加油站();
        int[] a={5,1,2,3,4};
        int[] b={4,4,1,5,1};
        System.out.println(t.canCompleteCircuit(a,b));
    }
}
