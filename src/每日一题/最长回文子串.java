package 每日一题;

public class 最长回文子串 {
    public String longestPalindrome(String s) {
        int n=s.length();
        char[] cs=s.toCharArray();
        boolean[][] f=new boolean[n+1][n+1];
        int maxi=1,maxj=1;
        for (int i=1;i<=n;i++)
            f[i][i]=true;
        for (int l=2;l<=n;l++){
            for (int i=1;i<=n;i++){
                int j=l+i-1;
                if (j>n)
                    break;
                if (j==i+1)
                    f[i][j]=cs[i-1]==cs[j-1];
                else
                    f[i][j]= f[i+1][j-1] && cs[i-1]==cs[j-1] ;
            }
        }
        for (int i=1;i<=n;i++)
            for (int j=i;j<=n;j++)
                if (f[i][j] && maxj-maxi<j-i){
                    maxi=i;
                    maxj=j;
                }
        return s.substring(maxi-1,maxj);
    }

    public static void main(String[] args) {
        最长回文子串 t=new 最长回文子串();
        System.out.println(t.longestPalindrome("xaabacxcabaaxcabaax"));
    }
}
