package 每日一题;

import java.util.Arrays;

public class 重新排列字符串 {
    public String restoreString(String s, int[] indices) {
        char[] cs=s.toCharArray();
        char[] result=new char[s.length()];
        for (int i=0;i<s.length();i++){
            result[indices[i]]=cs[i];
        }
        return String.valueOf(result);
    }
}
