package 每日一题;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class 水壶问题 {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (jug1Capacity+jug2Capacity<targetCapacity)
            return false;
        Set<Long> set=new HashSet<>();
        set.add(trans(0,0));
        Deque<Long> stack=new ArrayDeque<>();
        stack.addFirst(trans(0,0));
        while (!stack.isEmpty()){
            int[] t=get(stack.removeLast());
            long fl;
            if (!set.contains(fl=trans(0,t[1]))){
                if (0+t[1]==targetCapacity)
                    return true;
                else {
                    set.add(fl);
                    stack.addFirst(fl);
                }
            }
            if (!set.contains(fl=trans(t[0],0))){
                if (t[0]+0==targetCapacity)
                    return true;
                else {
                    set.add(fl);
                    stack.addFirst(fl);
                }
            }
            if (!set.contains(fl=trans(jug1Capacity,t[1]))){
                if (jug1Capacity+t[1]==targetCapacity)
                    return true;
                else {
                    set.add(fl);
                    stack.addFirst(fl);
                }
            }
            if (!set.contains(fl=trans(t[0],jug2Capacity))){
                if (t[0]+jug2Capacity==targetCapacity)
                    return true;
                else {
                    set.add(fl);
                    stack.addFirst(fl);
                }
            }
            if (!set.contains(fl=trans(t[1]+t[0]<=jug2Capacity?0:t[1]+t[0]-jug2Capacity,t[1]+t[0]<=jug2Capacity?t[1]+t[0]:jug2Capacity))){
                if ((t[1]+t[0]<=jug2Capacity?t[1]+t[0]:jug2Capacity)+(t[1]+t[0]<=jug2Capacity?0:t[1]+t[0]-jug2Capacity)==targetCapacity)
                    return true;
                else {
                    set.add(fl);
                    stack.addFirst(fl);
                }
            }
            if (!set.contains(fl=trans(t[1]+t[0]<=jug1Capacity?t[1]+t[0]:jug1Capacity,t[1]+t[0]<=jug1Capacity?0:t[1]+t[0]-jug1Capacity))){
                if ((t[1]+t[0]<=jug1Capacity?t[1]+t[0]:jug1Capacity)+(t[1]+t[0]<=jug1Capacity?0:t[1]+t[0]-jug1Capacity)==targetCapacity)
                    return true;
                else {
                    set.add(fl);
                    stack.addFirst(fl);
                }
            }
        }
        return false;
    }
    private long trans(int a,int b){
        long r=0;
        r+=b;
        r+=a<<22;
        return r;
    }
    private int[] get(long l){
        int b=(int)(l&((1<<22)-1));
        int a=(int)(l>>22);
        return new int[]{a,b};
    }

    public static void main(String[] args) {
        水壶问题 t=new 水壶问题();
        System.out.println(t.canMeasureWater(3,5,4));
    }
}
