package 每日一题;

public class 无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0){
            return 0;
        }
        else {
            String news = "";
            int max = 0;
            for (int i = 1; i < s.length(); i++) {
                news += s.charAt(i - 1);
                int f = news.indexOf(s.charAt(i));
                if (f != -1) {
                    //存在相同字符
                    if (max < news.length()) {
                        max = news.length();
                    }
                    news = news.substring(f + 1);
                }
            }
            news += s.charAt(s.length() - 1);
            if (max < news.length()) {
                max = news.length();
            }
            return max;
        }
    }
    public static void main(String[] args) {
        String s="aaa";
        无重复字符的最长子串 test=new 无重复字符的最长子串();
        System.out.println(test.lengthOfLongestSubstring(s));
    }
}
