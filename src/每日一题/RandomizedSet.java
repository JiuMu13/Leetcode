package 每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {
    private List<Integer> l;
    int N;
    private Map<Integer,Integer> map;
    public RandomizedSet() {
        l=new ArrayList<>();
        N=0;
        map=new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        l.add(val);
        map.put(val,N++);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }
        int temp=l.get(N-1);
        l.remove(N-1);
        int index=map.get(val);
        if (index!=N-1) {
            l.set(index, temp);
            map.remove(val);
            map.put(temp, index);
        }else {
            map.remove(val);
        }
        N--;
        return true;
    }

    public int getRandom() {
        int random=(int)(Math.random()*N);
        return l.get(random);
    }

    public static void main(String[] args) {
        RandomizedSet t=new RandomizedSet();
        t.insert(3);
        t.insert(3);
        t.insert(1);
        t.remove(3);
        t.insert(0);
        t.remove(0);

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
