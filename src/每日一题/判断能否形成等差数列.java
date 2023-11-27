package 每日一题;

import java.util.Arrays;

public class 判断能否形成等差数列 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for (int i=2;i<arr.length;i++){
            if (arr[i-1]-arr[i-2]!=arr[i]-arr[i-1])
                return false;
        }
        return true;
    }
}
