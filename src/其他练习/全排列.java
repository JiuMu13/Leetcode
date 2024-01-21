package 其他练习;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class 全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> t = new LinkedList<>();
        for (int e : nums) {
            t.add(e);
        }
        return dg(t);
    }
    private List<List<Integer>> dg(List<Integer> nums){
        if (nums.size()==1){
            List<List<Integer>> r=new LinkedList<>();
            LinkedList<Integer> t = new LinkedList<>();
            t.add(nums.get(0));
            r.add(t);
            return r;
        }
        List<List<Integer>> r=new LinkedList<>();
        for (int i=0;i<nums.size();i++){
            List<Integer> f=new LinkedList<>(nums);
            f.remove(i);
            List<List<Integer>> t=dg(f);
            for (List<Integer> l : t) {
                l.add(0,nums.get(i));
            }
            r.addAll(t);
        }
        return r;
    }
}
