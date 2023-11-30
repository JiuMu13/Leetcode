package 每日一题;

import java.util.Arrays;

public class 确定两个字符串是否接近 {
    public boolean closeStrings(String word1, String word2) {
        int[] str1=new int[26];
        int[] str2=new int[26];
        char[] cs1=word1.toCharArray();
        char[] cs2=word2.toCharArray();
        if (cs1.length!=cs2.length)
            return false;

        for (int i=0;i<cs1.length;i++){
            str1[cs1[i]-'a']++;
            str2[cs2[i]-'a']++;
        }
        for (int i=0;i<26;i++){
            if (str1[i]+str2[i]!=0 && str1[i]*str2[i]==0)
                return false;
        }
        Arrays.sort(str1);
        Arrays.sort(str2);
        for (int i=0;i<26;i++){
            if (str1[i]!=str2[i])
                return false;
        }
        return true;
    }
}
