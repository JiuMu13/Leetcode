package 第375场周赛;

import java.util.ArrayList;
import java.util.List;

public class 双模幂运算 {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> result=new ArrayList<>();
        for (int i=0;i<variables.length;i++){
            if (ksm(modTen(variables[i][0],variables[i][1]),variables[i][2],variables[i][3])==target)
                result.add(i);
        }
        return result;
    }
    private int modTen(int a,int b){
         return (int)((long)Math.pow(a,(b-1)%4+1)%10);
    }
    private int ksm(int n,int k,int m){
        long r=1;
        while (k!=0){
            if ((k & 1)==1) r=r*n%m;
            k>>=1;
            n=n*n%m;
        }
        return (int)r;
    }
}
