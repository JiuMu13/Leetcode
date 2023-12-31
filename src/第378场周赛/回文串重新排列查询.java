package 第378场周赛;

import java.util.Arrays;

public class 回文串重新排列查询 {
    public boolean[] canMakePalindromeQueries(String s, int[][] queries) {
        int n=s.length();
        char[] lc=s.substring(0,n/2).toCharArray();
        char[] rc=new StringBuilder(s.substring(n/2)).reverse().toString().toCharArray();
        int[][] prel=new int[n/2+1][26];
        int[][] prer=new int[n/2+1][26];
        int[] predif=new int[n/2+1];
        for (int i=1;i<=n/2;i++){
            for (int j=0;j<26;j++){
                prel[i][j]=prel[i-1][j];
                prer[i][j]=prer[i-1][j];
            }
            prel[i][lc[i-1]-'a']++;
            prer[i][rc[i-1]-'a']++;
        }
        for (int i=1;i<n/2+1;i++){
            predif[i]=predif[i-1];
            if (lc[i-1]!=rc[i-1])
                predif[i]++;
        }
        boolean[] r=new boolean[queries.length];
        boolean exch=false;
        a:for (int i=0;i<queries.length;i++){
            if (exch){
                int[][] tt=prel;
                prel=prer;
                prer=tt;
                exch=false;
            }
            int l1=queries[i][0]+1,r1=queries[i][1]+1;
            int l2=n-queries[i][3],r2=n-queries[i][2];
            if (l1>l2){
                int t=l1; l1=l2; l2=t;
                t=r1; r1=r2; r2=t;
                int[][] tt=prel;
                prel=prer;
                prer=tt;
                exch=true;
            }
            //包含
            if (r1>=r2){
                if (predif[l1-1]+predif[n/2]-predif[r1]>0){
                    continue;
                }
                if (eq(l1,r1,prel,prer)){
                    r[i]=true;
                }
            }else if (r1<l2){
                //不相交
                if (predif[l1-1]+predif[l2-1]-predif[r1]+predif[n/2]-predif[r2]>0)
                    continue;
                if (eq(l1,r1,prel,prer) && eq(l2,r2,prel,prer))
                    r[i]=true;
            }else {
                //相交
                if (predif[l1-1]+predif[n/2]-predif[r2]>0)
                    continue;
                int[] t1=new int[26];
                for (int j=0;j<26;j++){
                    t1[j]=prel[r1][j]-prel[l1-1][j];
                    t1[j]-=prer[l2-1][j]-prer[l1-1][j];
                    if (t1[j]<0)
                        continue a;
                }
                int[] t2=new int[26];
                for (int j=0;j<26;j++){
                    t2[j]=prer[r2][j]-prer[l2-1][j];
                    t2[j]-=prel[r2][j]-prel[r1][j];
                    if (t2[j]<0)
                        continue a;
                }
                for (int j=0;j<26;j++){
                    if (t1[j]!=t2[j])
                        continue a;
                }
                r[i]=true;
            }
        }
        return r;
    }
    private boolean eq(int l1,int r1,int[][] prel,int[][] prer){
        int[] t=new int[26];
        for (int i=0;i<26;i++){
            t[i]=prel[r1][i]-prel[l1-1][i];
        }
        for (int i=0;i<26;i++){
            if (prer[r1][i]-prer[l1-1][i]!=t[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        回文串重新排列查询 t=new 回文串重新排列查询();
        String s="adceaecd";
        int[][] q={{3,3,5,5},{0,1,4,6}};
        System.out.println(Arrays.toString(t.canMakePalindromeQueries(s,q)));
    }
}
