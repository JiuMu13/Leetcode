package 每日一题;

public class 拿硬币 {
    public int minCount(int[] coins) {
        int sum=0;
        for(int i=0;i<coins.length;i++){
            sum+=coins[i]%2==0?coins[i]/2:coins[i]/2+1;
        }
        return sum;
    }
}
