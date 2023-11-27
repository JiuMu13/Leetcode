package 每日一题;

public class 计数质数 {
    public int countPrimes(int n) {
        if (n<2)
            return 0;
        boolean[] st=new boolean[n];
        int result=0;
        for (int i=2;i<n;i++)
            if (!st[i]){
                st[i]=true;
                result++;
                for (int j=2;j*i<n;j++){
                    st[j*i]=true;
                }
            }
        return result;
    }

    public static void main(String[] args) {
        计数质数 t=new 计数质数();
        System.out.println(t.countPrimes(10));
    }
}
