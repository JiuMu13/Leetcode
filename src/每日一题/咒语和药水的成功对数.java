package 每日一题;

import java.util.Arrays;

public class 咒语和药水的成功对数 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n=potions.length;
        int[] result=new int[spells.length];
        for (int i=0;i<potions.length;i++){
            potions[i]=(int)(success/potions[i]+(success%potions[i]==0?0:1));
            System.out.println(potions[i]);
        }
        for (int i=0;i<spells.length;i++){
            result[i]=ef(spells[i],potions);
        }
        return result;
    }
    private int ef(int x,int[] po){
        int l=0,r=po.length-1;
        while (l<r){
            int mid=(l+r+1)/2;
            if (po[mid]>x){
                l=mid;
            }else {
                r=mid-1;
            }
        }
        if (x>=po[l])
            l--;
        return po.length-l-1;
    }

    public static void main(String[] args) {
        咒语和药水的成功对数 t=new 咒语和药水的成功对数();
        System.out.println(Arrays.toString(t.successfulPairs(new int[]{15,8,19},new int[]{38,36,23},328)));
    }
}
