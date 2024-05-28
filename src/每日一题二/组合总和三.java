package 每日一题二;

import java.util.ArrayList;
import java.util.List;

public class 组合总和三 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        result=new ArrayList<>();
        dg(new ArrayList<>(),0,1,n,k);
        return result;
    }
    List<List<Integer>> result;
    private void dg(List<Integer> l,int sum,int curr,int target,int k){
        if (sum==target && l.size()==k){
            result.add(l);
            return;
        }
        for (int i=curr;i<=9;i++){
            if (sum+i<=target && l.size()+1<=k){
                List<Integer> t = new ArrayList<>(l);
                t.add(i);
                dg(t,sum+i,i+1,target,k);
            }
        }
    }
}
