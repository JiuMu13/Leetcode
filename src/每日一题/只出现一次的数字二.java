package 每日一题;

public class 只出现一次的数字二 {
    public int singleNumber(int[] nums) {
        int[] bs=new int[32];
        int f=0;
        int fs=0;
        for (long e:nums) {
            f=0;
            if (e<0){
                e=-e;
                fs++;
            }
//            System.out.println(e);
            while(e!=0){
//                System.out.println(e);
                bs[f++]+=e&1;
                e>>=1;
            }
        }
        long result=0;
        for(int i=0;i<32;i++){
            result+=bs[i]%3<<i;
        }
        if (fs%3!=0)
            return (int)-result;
        return (int)result;
    }

    public static void main(String[] args) {
        只出现一次的数字二 t=new 只出现一次的数字二();
        int[] s={16,89,-2147483648,2147483646,-2147483647,-2147483648,2147483647,-2147483646,-2147483648,89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,16,16,2147483646};
        System.out.println(t.singleNumber(s));

    }
}
