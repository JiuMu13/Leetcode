package 每日一题;

public class 经营摩天轮的最大利润 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        if (boardingCost*4<=runningCost)
            return -1;
        int max=0;
        int sum=0;
        int r=-1;
        int n=customers.length;
        int waitPeople=0;
        for (int i=0;i<n;i++){
            waitPeople+=customers[i];
            if (waitPeople>4){
                waitPeople-=4;
                sum+=4*boardingCost;
            }else {
                sum+=waitPeople*boardingCost;
                waitPeople=0;
            }
            sum-=runningCost;
            if (sum>max){
                max=sum;
                r=i+1;
            }
        }
        if (waitPeople>0){
            int c=waitPeople/4;
            sum+=4*c*boardingCost;
            sum-=c*runningCost;
            if (sum>max){
                max=sum;
                r=n+c;
            }
            int y=waitPeople%4;
            if (y*boardingCost>runningCost){
                sum+=y*boardingCost-runningCost;
                if (sum>max){
                    max=sum;
                    r=n+c+1;
                }
            }
        }
        return r;
    }
}
