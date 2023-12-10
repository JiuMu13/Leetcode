package 每日一题;

public class 爬楼梯 {
    public int climbStairs(int n) {
        int la1=2,la2=1;
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        for(int i=2;i<n;i++){
            int t=la1;
            la1=la1+la2;
            la2=t;
        }
        return la1;
    }

    public static void main(String[] args) {
        爬楼梯 t=new 爬楼梯();
        t.climbStairs(4);
    }
}
