package 每日一题二;

public class 字符串中最多数目的子序列 {
    public long maximumSubsequenceCount(String text, String pattern) {
        char[] cs=text.toCharArray();
        long sum=0;
        long c1=0,c2=0;
        for (char c : cs) {
            if (c==pattern.charAt(0)) {
                c1++;
            }else if (c==pattern.charAt(1)) {
                sum+=c1;
                c2++;
            }
        }
        if (pattern.charAt(0)==pattern.charAt(1)) {
            return (c1+1)*(c1)/2;
        }
        sum+=Math.max(c1,c2);
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(new 字符串中最多数目的子序列().maximumSubsequenceCount("iekbksdsmuuzwxbpmcngsfkjvpzuknqguzvzik","mp"));
    }
}
