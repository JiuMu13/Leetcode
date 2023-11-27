package 第372场周赛;

public class 区分黑球与白球 {
    public long minimumSteps(String s) {
        char[] cs=s.toCharArray();
        int rb=cs.length-1;
        long result=0;
        for (int i=cs.length-1;i>=0;i--){
            if (cs[i]=='1'){
                result+=rb-i;
                rb--;
            }
        }
        return result;
    }
}
