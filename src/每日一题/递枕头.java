package 每日一题;

public class 递枕头 {
    public int passThePillow(int n, int time) {
        int f=1;
        int result=1;
        while(time>0){
            if (result==n)
                f=-f;
            result+=f;
            time--;
            if (result==1)
                f=-f;
        }
        return result;
    }
}
