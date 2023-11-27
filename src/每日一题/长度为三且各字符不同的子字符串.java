package 每日一题;

public class 长度为三且各字符不同的子字符串 {
    public int countGoodSubstrings(String s) {
        int sum=0;
        int fi=0,se=1,th=2;
        char[] ss=s.toCharArray();
        for (;th<ss.length;fi++,se++,th++){
            if (ss[fi]!=ss[se] && ss[fi]!=ss[th] && ss[se]!=ss[th])
                sum++;
        }
        return sum;
    }
}
