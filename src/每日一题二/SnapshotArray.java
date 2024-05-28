package 每日一题二;

import java.util.*;

public class SnapshotArray {

    Map<Integer,Integer>[] kz;
    int count=0;

    public SnapshotArray(int length) {
        kz=new HashMap[50000];
        kz[0]=new HashMap<>();
        for(int i=0;i<length;i++) {
            kz[0].put(i,1);
        }
    }

    public void set(int index, int val) {
        kz[count].put(index,val);
    }

    public int snap() {
        kz[count+1]=new HashMap<>();
        return count++;
    }
    //更优方法是对每个位置维护一个修改历史，使用二分查找
    public int get(int index, int snap_id) {
        if(count==0)
            return 0;
        for (int i=snap_id;i>=0;i--){
            if (kz[i].containsKey(index)){
                int t= kz[i].get(index);
                for (int j=i+1;j<=snap_id;j++){
                    kz[j].put(index,t);
                }
                return t;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
