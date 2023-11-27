package 每日一题;

public class 华为_数字序列比大小 {
    int fa=0;
    int fb=0,ffb=0;
    public int bdx(int begin,int length,int[] a,int[] b)
    {
        for (int i=0;i<length;i++){
            int min=i;
            for (int j=i+1;j<a.length;j++){
                if (a[j]<a[min])
                    min=j;
            }
            if (i!=min){
                int temp=a[i];
                a[i]=a[min];
                a[min]=temp;
            }
        }
        for (int i=0;i<length;i++){
            int min=i;
            for (int j=i+1;j<b.length;j++){
                if (b[j]<b[min])
                    min=j;
            }
            if (i!=min){
                int temp=b[i];
                b[i]=b[min];
                b[min]=temp;
            }
        }
        max(begin,length,a,b);
        return fa-fb;
    }

    public static void main(String[] args) {
        华为_数字序列比大小 test=new 华为_数字序列比大小();
        int[] a={4,8,10};
        int[] b={3,6,4};
        System.out.println(test.bdx(0,3,a,b));
    }
    public void max(int begin,int length,int[] a,int[] b){
        if (begin>=length || ffb>=length)
            return ;
        int i;
        for (i=begin;i<length;i++){
            if (a[i]>b[ffb++]){
                fa++;
                if (fb>0)
                    fb--;
            }else{
                fb++;
                if (fa>0)
                    fa--;
                max(i,length,a,b);
            }
        }//找到a>b的值
    }
}
