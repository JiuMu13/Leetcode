package 每日一题;

import java.util.HashSet;
import java.util.Set;
//关键 a^b=c 则a^c=b b^c=a
public class 数组中两个数的最大异或值 {
    public int findMaximumXOR(int[] nums) {
        int t=0;
        int result=0;
        for (int i=30;i>=0;i--){
            Set<Integer> set=new HashSet<>();
            t=t | 1<<i;
            for (int e:nums){
                set.add( t & e );//构造前缀
            }
            int f= result | 1<<i;
            for (Integer e:set){
                if (set.contains( f ^ e )){
                    result=f;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        数组中两个数的最大异或值 t=new 数组中两个数的最大异或值();
        System.out.println(t.findMaximumXOR(new int[]{3,10,5,25,2,8}));
    }
}
