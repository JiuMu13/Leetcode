package 每日一题;

public class 最短回文串 {
    public String shortestPalindrome(String s) {
        if(s.length()<=1)
            return s;
        char[] cs=s.toCharArray();
        int p=131,mod=1000000007;
        long l=0,n=0;
        int result=0;
        for (int i=0;i<s.length();i++){
            l=(l*p+cs[i])%mod;
            n=(ksm(131,i)*cs[i]+n)%mod;
            if (l==n)
                result = i;
        }
        return new StringBuffer(s).reverse().toString()+s.substring(result+1);
    }
    private long ksm(long a,long k){
        long result=1;
        while (k!=0){
            if ((k&1)!=0)  result=result*a%1000000007;
            k>>=1;
            a=a*a%1000000007;
        }
        return result;
    }

    public static void main(String[] args) {
        最短回文串 t=new 最短回文串();
        System.out.println(t.shortestPalindrome("aacecaaa"));
    }
}
