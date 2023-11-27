package 每日一题;

import java.util.*;

public class 除法求值 {
    int[] bcj;
    double[] w;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Integer> ys=new HashMap<>();
        int f=0;
        double[] result=new double[queries.size()];
        for (List<String> l:equations) {
            if (!ys.containsKey(l.get(0)))
                ys.put(l.get(0),f++);
            if (!ys.containsKey(l.get(1)))
                ys.put(l.get(1),f++);
        }
        w=new double[ys.size()];
        Arrays.fill(w,1);
        bcj=new int[ys.size()];
        for (int i = 0; i <ys.size() ; i++) {
            bcj[i]=i;
        }
        for (int i=0;i<equations.size();i++){
            merge(ys.get(equations.get(i).get(0)),ys.get(equations.get(i).get(1)),values[i]);
        }
        for (int i=0;i<queries.size();i++){
            String a=queries.get(i).get(0),b=queries.get(i).get(1);
            if (ys.containsKey(a) && ys.containsKey(b)){
                if (find(ys.get(a))==find(ys.get(b))){
                    result[i]=w[ys.get(a)]/w[ys.get(b)];
                }
                else
                    result[i]=-1;
            }
            else
                result[i]=-1;

        }
        return result;
    }
    public int find(int x){
        if (bcj[x]!=x) {
            int f=bcj[x];
            bcj[x] = find(bcj[x]);
            w[x]*=w[f];
        }
        return bcj[x];
    }
    public void merge(int x,int y,double value){
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) {
            return;
        }
        bcj[rootX] = rootY;
        w[rootX] = w[y] * value / w[x];
    }

    public static void main(String[] args) {

    }
}
