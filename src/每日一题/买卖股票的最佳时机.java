package 每日一题;

public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
//        int[] min=new int[prices.length]; //前缀和
//        int[] max=new int[prices.length]; //后缀和
//        min[0]=prices[0];
//        max[prices.length-1]=prices[prices.length-1];
//        max[prices.length-1]=prices[prices.length-1];
//        for (int i=1;i<prices.length;i++){
//            min[i]=Math.min(min[i-1],prices[i]);
//            max[prices.length-1-i]=Math.max(max[prices.length-i],prices[prices.length-1-i]);
//        }
//        int result=0;
//        for (int i=0;i<prices.length-1;i++){
//            result=Math.max(max[i+1]-min[i],result);
//        }
//        return result;
        int min=prices[0],result=0;
        for (int i=1;i<prices.length;i++){
            if (prices[i]-min>result)
                result=prices[i]-min;
            if (prices[i]<min)
                min=prices[i];
        }
        return result;
    }

    public static void main(String[] args) {
        买卖股票的最佳时机 t=new 买卖股票的最佳时机();
        int[] s={7,1,5,3,6,4};
        System.out.println(t.maxProfit(s));
    }
}
