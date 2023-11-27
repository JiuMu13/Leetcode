package 每日一题;

public class 宝石补给 {
    public int giveGem(int[] gem, int[][] operations) {
        for(int i=0;i<operations.length;i++){
            int give=gem[operations[i][0]]/2;
            gem[operations[i][0]]-=give;
            gem[operations[i][1]]+=give;
        }
        int max=gem[0];
        int min=gem[0];
        for (int i=0;i<gem.length;i++){
            if (max<gem[i]){
                max=gem[i];
            }
            if (min>gem[i]){
                min=gem[i];
            }
        }
        return max-min;
    }
}
