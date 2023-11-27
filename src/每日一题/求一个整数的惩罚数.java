package 每日一题;

public class 求一个整数的惩罚数 {
    public int punishmentNumber(int n) {
        int result=0;
        for (int i=1;i<=n;i++){
            if (check(i*i,i))
                result+=i*i;
        }
        return result;
    }
    private boolean check(int xx,int x){
        if (xx==x)
            return true;
        int count=10;
        while (xx>count && xx%count<=x){
            if (check(xx/count,x-xx%count))
                return true;
            count*=10;
        }
        return false;
    }
    public static void main(String[] args) {
        求一个整数的惩罚数 t=new 求一个整数的惩罚数();
        System.out.println(t.punishmentNumber(45));
    }
}
