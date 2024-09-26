package 其他练习.未分类;

import java.util.Arrays;

public class 心算挑战 {
    public static int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int sum=0;
        int lastJ=-1;
        int lastO=-1;
        for (int i=cards.length-1;i>=cards.length-cnt;i--){
            if ((cards[i]&1)==0)
                lastO=cards[i];
            else
                lastJ=cards[i];
            sum+=cards[i];
        }
        if ((sum&1)==1){
            int c=Integer.MAX_VALUE;
            for (int i=cards.length-cnt-1;i>=0;i--){
                if ((cards[i]&1)==0){
                    c=lastJ-cards[i];
                    break;
                }
            }
            if (lastO!=-1){
                for (int i=cards.length-cnt-1;i>=0;i--){
                    if ((cards[i]&1)==1){
                        c=Math.min(c,lastO-cards[i]);
                        break;
                    }
                }
            }
            if (c==Integer.MAX_VALUE)
                return 0;
            return sum-c;
        }else
            return sum;
    }

    public static void main(String[] args) {
        System.out.println(maxmiumScore(new int[]{1,2,8,9},3));
    }
}
