package 第376场周赛;

import java.util.HashSet;
import java.util.Set;

public class 找出缺失和重复的数字 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        Set set=new HashSet();
        int sum=0;
        int[] result=new int[2];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (set.contains(grid[i][j])){
                    result[0]=grid[i][j];
                }else {
                    set.add(grid[i][j]);
                    sum+=grid[i][j];
                }
            }
        }
        result[1]=(1+n*n)*n*n/2-sum;
        return result;
    }
}
