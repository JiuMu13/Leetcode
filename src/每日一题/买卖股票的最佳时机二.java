package 每日一题;

public class 买卖股票的最佳时机二 {
    public int maxProfit(int[] prices) {
        int result=0,curr;
        curr=prices[0];
        for (int i=1;i<prices.length;i++){
            if (prices[i]>=curr){
                result+=prices[i]-curr;
                curr=prices[i];
            }else {
                curr=prices[i];
            }
        }
        return result;
    }
}
