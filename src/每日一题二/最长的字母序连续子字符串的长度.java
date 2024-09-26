package 每日一题二;

public class 最长的字母序连续子字符串的长度 {

    public int longestContinuousSubstring(String s) {
        int max=0;
        int last=-1;
        int curr=0;
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c==last+1){
                curr++;
            }else {
                curr=1;
            }
            max=Math.max(max,curr);
            last=c;
        }
        return max;
    }
}
