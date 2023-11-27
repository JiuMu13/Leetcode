package 每日一题;

public class 将钱分给最多的儿童 {
    public int distMoney(int money, int children) {
        int df=children;
        int y;
        int s;
        if (money<children)
            return -1;
        money-=children;
        s=money/7;
        df-=s;
        y=money%7;
        if (y==3 && df==1)
            s--;
        if (df==0 && y>0)
            s--;
        if (df<0){
            s=children-1;
        }
        return s;
    }
}
