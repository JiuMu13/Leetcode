package 第375场周赛;

import java.util.*;
//元素排列组合时要考虑好排列组合的方式
public class 统计好分割方案的数目 {
    static int n=100010;
    static int mod=(int)1e9+7;
    static int[] jc=new int[n];
    static int[] ny=new int[n];
    static{
        jc[0]=1;
        for (int i=1;i<n;i++){
            jc[i]=(int)((long)jc[i-1]*i%mod);
        }
        ny[n-1]=ksm(jc[n-1],mod-2);
        for (int i=n-2;i>=0;i--){
            ny[i]=(int)((long)ny[i+1]*(i+1)%mod);
        }
    }
    private static int ksm(int a,int k){
        int result=1;
        while (k!=0){
            if ((k&1)==1) result=(int)((long)result*a%mod);
            k>>=1;
            a=(int)((long)a*a%mod);
        }
        return result;
    }
    private static int comb(int up,int down){
        return (int)((long)jc[down]*ny[up]%mod*ny[down-up]%mod);
    }
    public int numberOfGoodPartitions(int[] nums) {
        Map<Integer,Integer> head=new HashMap<>();
        Map<Integer,Integer> tail=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (!head.containsKey(nums[i]))
                head.put(nums[i],i);
            else {
                tail.put(nums[i],i);
            }
        }
        int[][] d=new int[head.size()][2];
        int f=0;
        for (Map.Entry<Integer,Integer> entry:head.entrySet()){
            if (tail.containsKey(entry.getKey())){
                d[f][0]=entry.getValue();
                d[f++][1]=tail.get(entry.getKey());
            }
        }
        int[][] dd=new int[f][2];
        for (int i=0;i<f;i++){
            dd[i][0]=d[i][0];
            dd[i][1]=d[i][1];
        }
        Arrays.sort(dd, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int count=0;
        int curr=0,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for (int i=0;i<f;i++){
            min=Math.min(min,dd[i][0]);
            max=Math.max(max,dd[i][1]);
            if (curr<dd[i][0]){
                count+=dd[i][0]-curr;
                curr=dd[i][1];
            }else {
                curr=Math.max(curr,dd[i][1]);
            }
        }
        count++;
        if (f==0)
            count=nums.length;
        else {
            count+=nums.length-(max+1);
        }
        long result=0;
        for (int i=0;i<count;i++){
            result+=comb(i,count-1);
        }
        return (int)result%mod;
    }

    public int numberOfGoodPartitions2(int[] nums) {
        Map<Integer,Integer> head=new HashMap<>();
        Map<Integer,Integer> tail=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (!head.containsKey(nums[i]))
                head.put(nums[i],i);
            else {
                tail.put(nums[i],i);
            }
        }
        int[][] d=new int[head.size()][2];
        int f=0;
        for (Map.Entry<Integer,Integer> entry:head.entrySet()){
            if (tail.containsKey(entry.getKey())){
                d[f][0]=entry.getValue();
                d[f++][1]=tail.get(entry.getKey());
            }
        }
        int[][] dd=new int[f][2];
        for (int i=0;i<f;i++){
            dd[i][0]=d[i][0];
            dd[i][1]=d[i][1];
        }
        Arrays.sort(dd, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int count=0;
        int curr=0,max=Integer.MIN_VALUE;
        for (int i=0;i<f;i++){
            max=Math.max(max,dd[i][1]);
            if (curr<dd[i][0]){
                count+=dd[i][0]-curr;
                curr=dd[i][1];
            }else {
                curr=Math.max(curr,dd[i][1]);
            }
        }
        count++;
        if (f==0)
            count=nums.length;
        else {
            count+=nums.length-(max+1);
        }
        return ksm(2,count);
    }
    public static void main(String[] args) {
        统计好分割方案的数目 t=new 统计好分割方案的数目();
        int[] s={6,6,5,5,8};
        System.out.println(t.numberOfGoodPartitions(s));
    }
}
