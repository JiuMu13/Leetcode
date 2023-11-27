package 每日一题;

public class 只出现一次的数字三 {
    public int[] singleNumber(int[] nums) {
        int sum=0;
        for(int e:nums)
            sum^=e;
        int f=0;
        while ( (sum&1) != 1){
            f++;
            sum>>>=1;
        }
        int x=0,y=0;
        for (int e:nums){
            if ((e>>>f&1)==1)
                x^=e;
            else
                y^=e;
        }
        return new int[]{x,y};
    }
}
