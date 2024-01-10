package 每日一题;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 字符串中的额外字符 {
    public int minExtraChar(String s, String[] dictionary) {
        int n=s.length();
        int[] dp=new int[n+1];
        for (int i=0;i<=n;i++)
            dp[i]=i;
        Map<String,Integer> map=new HashMap<>();
        for (String e:dictionary){
            map.put(e,1);
        }

        for (int i=1;i<=n;i++){
            for (int j=i;j>0;j--){
                if (map.containsKey(s.substring(j-1,i))){
                    dp[i]=Math.min(dp[j-1],dp[i]);
                }
            }
            dp[i]=Math.min(dp[i-1]+1,dp[i]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        字符串中的额外字符 t=new 字符串中的额外字符();
        System.out.println(t.minExtraChar("leetscode",new String[]{"leet","code","leetcode"}));
    }
}
