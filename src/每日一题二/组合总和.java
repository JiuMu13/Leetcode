package 每日一题二;

import java.util.ArrayList;
import java.util.List;

public class 组合总和 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList<>();
        dg(new ArrayList<>(),0,candidates,target,0);
        return result;
    }
    private List<List<Integer>> result;
    public void dg(List<Integer> l,int sum,int[] cand,int target,int curri){
        if (sum==target){
            result.add(l);
            return;
        }
        for (int i=curri;i<cand.length;i++){
            if (sum+cand[i]<=target){
                List<Integer> c=new ArrayList<>(l);
                c.add(cand[i]);
                dg(c,sum+cand[i],cand,target,i);
            }
        }
    }

    public static void main(String[] args) {
        int h=1;
        System.out.println(h >>> 16);
    }
}
