package 第372场周赛;

public class 使三个字符串相等 {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int l=Math.min(s1.length(),Math.min(s2.length(),s3.length()));
        int c=0;
        for (int i=0;i<l;i++){
            if (s1.charAt(i)==s2.charAt(i) && s2.charAt(i)==s3.charAt(i)){
                c++;
            }else
                break;
        }
        if (c==0)
            return -1;
        return s1.length()-c+s2.length()-c+s3.length()-c;
    }
}
