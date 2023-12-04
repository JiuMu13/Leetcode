package 第374场周赛;

public class 统计感冒序列的数目 {
    static int size=100010;
    static int m=(int)1e9+7;
    static long[] JC=new long[size];
    static long[] invJC=new long[size];
    static{
        JC[0]=1;
        for (int i=1;i<size;i++){
            JC[i]=JC[i-1]*i%m;
        }
        invJC[size-1]=ksm((int)JC[size-1],m-2);
        for (int i=size-1;i>=1;i--){
            invJC[i-1]=invJC[i]*i%m;
        }
    }
    static long ksm(int a,int k){
        long result=1;
        long t=a;
        while (k!=0){
            if ((k&1)==1)
                result=result*t%m;
            k >>= 1;
            t=t*t%m;
        }
        return result;
    }
    static int comb(int d,int u){
        return (int)(JC[d]*invJC[d-u]%m*invJC[u]%m);
    }
    public int numberOfSequence(int n, int[] sick) {
        int xl=1,f=0;//f为当前遍历到感冒序列第f个元素
        long result=1;
        int curr=n-sick.length;
        result=result*comb(curr,sick[0])%m;
        curr-=sick[0];
        for (int i=1;i<sick.length;i++){
            int t=sick[i]-sick[i-1]-1;
            if (t==0)
                continue;
            result=result*comb(curr,t)%m*ksm(2,t-1)%m;
            curr-=t;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        统计感冒序列的数目 t=new 统计感冒序列的数目();
        System.out.println(t.numberOfSequence(5,new int[]{0,1}));
    }
}

