package 每日一题;

public class 下一个更大的数值平衡数 {
    int[] w;//0到6记录7个数的个数
    public int nextBeautifulNumber(int n) {
        for(int i=n+1;;i++){
            if (bl(i))
                return i;
        }
    }
    public boolean bl(int n){
        w=new int[10];
        while (n!=0){
            int t=n%10;
            n/=10;
            w[t]++;
        }
        for (int i=0;i<10;i++){
            if (w[i]==0)
                continue;
            if (w[i]!=i)
                return false;
        }
        return true;
    }
}
