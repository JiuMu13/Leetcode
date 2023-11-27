package 每日一题;

public class IndexPriorityQueue<T extends Comparable<T>> {
    private T[] items;
    //存储元素在Items中的索引，有序，堆
    private int[] pq;
    //pq的逆序列
    private int[] qp;
    private int N;
    public IndexPriorityQueue(int capacity){
        items=(T[])new Comparable[capacity+1];
        pq=new int[capacity+1];
        qp=new int[capacity+1];
        N=0;
        //默认情况下，队列中没有数据
        for (int i=0;i<qp.length;i++){
            qp[i]=-1;
        }
    }
    private boolean less(int i,int j){
        return items[pq[i]].compareTo(items[pq[j]])>0;
    }
    private void exch(int i,int j){
        int temp=pq[i];
        pq[i]=pq[j];
        pq[j]=temp;
        qp[pq[i]]=i;
        qp[pq[j]]=j;
    }
    public int delMin(){
        int minIndex=pq[1];
        exch(1,N);
        qp[minIndex]=-1;
        pq[N]=-1;
        items[minIndex]=null;
        N--;
        sink(1);
        return minIndex;
    }
    public void insert(int i,T t){
        if (contains(i))
            return;
        N++;
        items[i]=t;
        pq[N]=i;
        qp[i]=N;
        swim(N);
    }
    private void swim(int k){
        while (k>1){
            if (less(k,k/2))
                exch(k,k/2);
            k=k/2;
        }
    }
    private void sink(int k){
        while (2*k<=N){
            int min;
            if (2*k+1<=N){
                if(less(2*k,2*k+1))
                    min=2*k;
                else
                    min=2*k+1;
            }else
                min=2*k;
            if (less(k,min)){
                break;
            }
            exch(k,min);
            k=min;
        }
    }
    public int size(){
        return N;
    }
    public boolean isEmpty(){
        return N==0;
    }
    //此处k为items的索引
    public boolean contains(int k){
        return qp[k]!=-1;
    }
    public void change(int i,T t){
        items[i]=t;
        int k=qp[i];
        sink(k);
        swim(k);
    }
    public int minIndex(){
        return pq[1];
    }
    public void delete(int i){
        int k=qp[i];
        exch(k,N);
        qp[pq[N]]=-1;
        pq[N]=-1;
        items[i]=null;
        N--;
        sink(k);
        swim(k);
    }
    public T get(int i){
        return items[i];
    }
}
