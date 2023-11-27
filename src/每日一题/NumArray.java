package 每日一题;

public class NumArray {
    int[] t;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums=nums;
        t=new int[nums.length+1];
        for (int i=1;i<t.length;i++){
            add(i,nums[i-1]);
        }
    }

    public void update(int index, int val) {
        int add=val-nums[index];
        nums[index]=val;
        add(index+1,add);
    }

    public int sumRange(int left, int right) {
        return sum(right+1)-sum(left);
    }
    private int sum(int x){
        int sum=0;
        for (int i=x;i>0;i-=lowbit(i)){
            sum+=t[i];
        }
        return sum;
    }
    private void add(int n,int k){
        for (int i=n;i<t.length;i+=lowbit(i)){
            t[i]+=k;
        }
    }
    private int lowbit(int x){
        return x&(-x);
    }
}
