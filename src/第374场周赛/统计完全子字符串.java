package 第374场周赛;

import 第373场周赛.统计美丽子字符串一;

import java.util.*;

public class 统计完全子字符串 {
    public int countCompleteSubstrings(String word, int k) {
        int n = word.length();
        int[][] count = new int[27][26];
        char[] cs = word.toCharArray();
        int result = 0;
        int curr=0;
        for (int i=0;i<n;i++){
            if (i!=0 && Math.abs(cs[i]-cs[i-1])>2){
                curr=i;
                for (int j=1;j<=26;j++){
                    Arrays.fill(count[j],0);
                }
            }
            for (int j=1;j<=26;j++){
                count[j][cs[i]-'a']++;
                if (i-curr>=j*k){
                    count[j][cs[i-j*k]-'a']--;
                }
            }
            for (int j=1;j<=26 && j*k<=i-curr+1;j++){
                int zmn=0;
                for (int h=0;h<26;h++){
                    if (count[j][h]==k){
                        zmn++;
                    }
                }
                if (zmn==j){
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        统计完全子字符串 t = new 统计完全子字符串();
        System.out.println(t.countCompleteSubstrings("igigee", 2));
    }
}
