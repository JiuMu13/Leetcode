package 每日一题;


/**
 * 法一：动态开点线段树
 */
//class CountIntervals {
//
//    CountIntervals left,right;//左右子节点
//    int l,r;//定义当前节点所代表的区间
//    int cnt;//记录当前区间存在的整数个数
//
//    public CountIntervals() {
//        cnt=0;
//        l=1;
//        r=(int)1e9;
//    }
//    public CountIntervals(int l,int r){
//        this.l=l;
//        this.r=r;
//    }
//
//    public void add(int L, int R) {
//        if (cnt==r-l+1) return;
//        if(L<=l && R>=r){
//            cnt=r-l+1;
//            return;
//        }
//        int mid=(l+r)/2;
//        if (left==null) left=new CountIntervals(l,mid);
//        if (right==null) right=new CountIntervals(mid+1,r);
//        if (L<=mid) left.add(L,R);
//        if (R>=mid+1) right.add(L,R);
//        cnt=left.cnt+right.cnt;
//    }
//
//    public int count() {
//        return cnt;
//    }
//}

import java.util.Map;
import java.util.TreeMap;

/**
 * 法二：平衡树
 * 珂朵莉树：
 * 用一颗平衡树维护不相交的区间，每次 add(left,right) 时，删除被该区间覆盖到的区间（部分覆盖也算），
 * 然后将被删除的区间与 [left,right]合并成一个新的大区间（并集），插入平衡树中。
 * 代码实现时，为方便找到第一个被 [left,right]覆盖到的区间，我们可以用平衡树的 key存区间右端点，
 * value存区间左端点。我们要找的就是第一个 key≥left的区间。
 */
class CountIntervals {
    int size;
    TreeMap<Integer,Integer> map;
    public CountIntervals() {
        map=new TreeMap<>();
        size=0;
    }

    public void add(int left, int right) {
        Map.Entry<Integer,Integer> e;
        //遍历并删除所有[left,right]覆盖到的区间（包括部分覆盖）
        for (e=map.ceilingEntry(left);e!=null && e.getValue()<=right;e=map.ceilingEntry(left)){
            int l=e.getValue(),r=e.getKey();
            //将小区间整合成一个大区间
            left=Math.min(left,l);
            right=Math.max(right,r);
            size-=r-l+1;//删除时需将该区间记录的整数个数也删除
            map.remove(r);
        }
        size+=right-left+1;
        map.put(right,left);
    }

    public int count() {
        return size;
    }
}
