package 每日一题;

public class 形成目标数组的子数组最少增加次数 {
    public int minNumberOperations(int[] target) {
        int result=target[0];
        for (int i=1;i<target.length;i++){
            if (target[i]>target[i-1])
                result+=target[i]-target[i-1];
        }
        return result;
    }

    public static void main(String[] args) {
        形成目标数组的子数组最少增加次数 t=new 形成目标数组的子数组最少增加次数();
        int[] s={1,1,5,5,4,5,1,1};
        System.out.println(t.minNumberOperations(s));
        System.out.println("++++++++++++");
        int[] s1={5,5,3};
        System.out.println(t.minNumberOperations(s1));
    }
}
