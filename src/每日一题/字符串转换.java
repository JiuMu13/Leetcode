package 每日一题;

public class 字符串转换 {
    public int numberOfWays(String s, String t, long k) {
        int count=0;
        char[] p=t.toCharArray();
        int n=p.length;
        char[] cs= (s+s.substring(0,s.length()-1)).toCharArray();
        //kmp构造next
        int[] next=new int[n];
        next[0]=-1;
        for (int i=1,j=-1;i<n;i++){
            while (j!=-1 && p[i]!=p[j+1])
                j=next[j];
            if (p[i]==p[j+1])
                j++;
            next[i]=j;
        }
        //查找出现次数
        for (int i=0,j=-1;i<cs.length;i++){
            while (j!=-1 && cs[i]!=p[j+1])
                j=next[j];
            if (cs[i]==p[j+1])
                j++;
            if (j==n-1){
                count++;
                j=next[j];
            }
        }
        long[][] m = {{count - 1, count},{s.length()- count, s.length() - 1 - count}};
        m=pow(m,k);
        return s.equals(t) ? (int) m[0][0] : (int) m[0][1];
    }
    private static final long MOD = (long) 1e9 + 7;
    private long[][] multiply(long[][] a, long[][] b) {
        long[][] c = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = (a[i][0] * b[0][j] + a[i][1] * b[1][j]) % MOD;
            }
        }
        return c;
    }
    private long[][] pow(long[][] a, long n) {
        long[][] res = {{1, 0}, {0, 1}};
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) {
                res = multiply(res, a);
            }
            a = multiply(a, a);
        }
        return res;
    }

    public static void main(String[] args) {
        字符串转换 t=new 字符串转换();
        System.out.println(t.numberOfWays("ababab","ababab",1));
    }
}
