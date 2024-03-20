package 每日一题二;

import java.util.HashSet;
import java.util.Set;

public class 找出美丽数组的最小和 {
    public static int minimumPossibleSum(int n, int target) {
        long N=n,Target=target;
        long r;
        if (Target%2==0){
            //Target为偶数
            if (N<=Target/2){
                r= (1+N)*N/2;
            }else {
                r= (1+Target/2)*Target/2/2+(Target+Target+N-Target/2-1)*(N-Target/2)/2;
            }
        }else {
            //Target为奇数
            if (N<=Target/2){
                r= (1+N)*N/2;
            }else {
                r= (1+Target/2)*(Target/2)/2+(Target+Target+(N-Target/2)-1)*(N-Target/2)/2;
            }
        }
        return (int)(r%(long)(1e9+7));
    }

    public static void main(String[] args) {
        System.out.println(minimumPossibleSum(1000000000,1000000000));
    }
}
