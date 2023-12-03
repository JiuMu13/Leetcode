package 第374场周赛;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 需要添加的硬币的最小数量 {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        Set<Integer> set=new HashSet<>();
        int f=0;
        long max=0;
        int cf=0;
        for (int i=1;i<=target;i++){
            if (f<coins.length &&coins[f]==i){
                set.add(i);
                max+=i;
                f++;
                while (f<coins.length && coins[f]==i){
                    max+=i;
                    f++;
                    cf++;
                }
            }
            if (max>=i)
                continue;
            else {
                set.add(i);
                max+=i;
            }
        }
        return set.size()+cf-coins.length;
    }

    public static void main(String[] args) {
        需要添加的硬币的最小数量 t=new 需要添加的硬币的最小数量();
        int[] s={1,1,1};
        System.out.println(t.minimumAddedCoins(s,5));
    }
}
