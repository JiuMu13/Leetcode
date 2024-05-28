package 模板;

import java.util.Arrays;

public class 十大排序算法 {
    public static void main(String[] args) {
        int[] s = new int[10];
        s = Arrays.stream(s).map((e) -> (int) (Math.random() * 20)).toArray();
        System.out.println("原始数组为：" + Arrays.toString(s));
        System.out.println("排序后数组为：" + Arrays.toString(计数排序(s)));
    }

    /**
     * 排序一个长度为n的数组时，将待排序的数组分为两部分，
     * 数组前a（初始为0）个元素为已排序元素，后b个元素为未排序元素，循环n次：
     * 每次从未排序的部分选出最小值，追加到已排序部分的末尾
     * 时间复杂度O（n²）
     * 思想：1。贪心算法 2.减治思想（通过执行相似的任务，将问题范围不断缩小）
     * 优点：交换次数最小
     *
     * @param s 待排序数组
     * @return 排序后数组
     */
    private static int[] 选择排序(int[] s) {
        for (int i = 0; i < s.length; i++) {
            int min = i;
            for (int j = i; j < s.length; j++) {
                if (s[min] > s[j])
                    min = j;
            }
            if (min != i) {
                int t = s[min];
                s[min] = s[i];
                s[i] = t;
            }
        }
        return s;
    }

    /**
     * 排序一个长度为n的数组时，将待排序的数组分为两部分，
     * 数组前a（初始为0）个元素为已排序元素，后b个元素为未排序元素，循环n次：
     * 每次选择未排序部分的第一个元素，然后遍历已排序部分，将其按顺序插入到已排序部分
     * 时间复杂度：O（n²）
     * 优点：在对近乎有序的数组排列时时间复杂度可以达到O（n）
     *
     * @param s 待排序数组
     * @return 排序后数组
     */
    private static int[] 插入排序(int[] s) {
        for (int i = 0; i < s.length; i++) {
            int t = s[i];
            for (int j = i - 1; j >= 0; j--) {
                if (t < s[j]) {
                    s[j + 1] = s[j];
                } else {
                    s[j + 1] = t;
                    break;
                }
            }
        }
        return s;
    }


    /**
     * 排序一个长度为n的数组时，将待排序数组分为两部分：
     * 数组前a个元素为未排序元素，后b（初始为0）个元素为已排序元素，循环n次：
     * 每次从头开始两两比较，若较大元素在后面，则交换两元素位置，经过一次循环，
     * 最大的元素在未排序的末尾，已排序元素加一。
     * 时间复杂度：O（n²）
     * 优点：在排序的过程中，若检测到数组是有序的，直接结束排序
     *
     * @param s 待排序数组
     * @return 排序后数组
     */
    private static int[] 冒泡排序(int[] s) {
        for (int i = 0; i < s.length; i++) {
            boolean exch = false;
            for (int j = 1; j < s.length - i; j++) {
                if (s[j] < s[j - 1]) {
                    exch = true;
                    int t = s[j];
                    s[j] = s[j - 1];
                    s[j - 1] = t;
                }
            }
            if (!exch)
                break;
        }
        return s;
    }

    /**
     * 排序一个长为n的数组分为四步：
     * 1.将一个大数组一分为二化为两个小数组。
     * 2.将小数组重复执行1的操作，直至不可分割（此处可以优化，见优化1）
     * 3.将一分为二的小数组（此数组是有序的）进行组合为一个有序的大数组
     * 4.重复3，直至将所有小数组组合在一起为原数组的有序形态
     * 思想：分治思想
     * 时间复杂度：O（nlogn）
     * 优点：时间复杂度低
     * 优化1：
     *     // 小区间使用插入排序（INSERTION_SORT_THRESHOLD=7）
     *    if (right - left <= INSERTION_SORT_THRESHOLD) {
     *        insertionSort(nums, left, right);
     *        return;
     *    }
     *
     * @param s 待排序数组
     * @return 排序后数组
     */
    private static int[] 归并排序(int[] s) {
        merge(s,0,s.length-1,new int[s.length]);
        return s;
    }

    /**
     * 归并函数，用于将数组s的[left,right]区间的元素排序
     * @param s 原数组
     * @param left 排序左区间
     * @param right 排序右区间
     * @param temp 辅助数组（优化3：可以避免开辟空间对时间的浪费）
     */
    private static void merge(int[] s,int left,int right,int[] temp){
        //此处可优化（见优化1）
        if (left==right)
            return;

        int mid = (left+right) >> 1;
        merge(s,left,mid,temp);
        merge(s,mid+1,right,temp);

        //优化2
        if (s[mid] <= s[mid+1])
            return;

        int il=left,ir=mid+1,i=left;
        while (il<=mid && ir<=right){
            if (s[il]>s[ir]){
                temp[i++]=s[ir++];
            }else {
                temp[i++]=s[il++];
            }
        }
        while (il<=mid)
            temp[i++]=s[il++];
        while (ir<=right)
            temp[i++]=s[ir++];
        System.arraycopy(temp,left,s,left,right-left+1);
    }

    /**
     * 排序一个长为n的数组分为四步：
     * 1.在大数组中选择一个基准值
     * 2.根据这个基准值将大数组一分为二，左侧元素小于等于基准值，右侧元素大于等于基准值
     * 3.分别对这两个小数组进行1，2操作，直至数组不可再分
     * 4.此时数组即为有序数组
     * 时间复杂度：O（nlogn）(注意：必须是在随机选择基准值的情况下)
     * @param s 待排序数组
     * @return 排序后数组
     */
    private static int[] 快速排序(int[] s){
        quicksort(s,0,s.length-1);
        return s;
    }

    /**
     * 快排函数，用于将数组s的[left,right]区间的元素排序
     * @param s 原数组
     * @param left 排序左区间
     * @param right 排序右区间
     */
    private static void quicksort(int[] s,int left,int right){
        if (right<=left)
            return;
        //此处优化随机取基准值，否则在输入数组是有序数组或者是逆序数组的时候，快速排序会变得非常慢
        int f=s[(int)(Math.random()*(right-left+1)+left)],l=left-1,r=right+1;
        while (l<r){
            while (s[++l]<f);
            while (s[--r]>f);
            if (l<r){
                int t=s[l]; s[l]=s[r]; s[r]=t;
            }
        }
        quicksort(s,left,r);
        quicksort(s,r+1,right);
    }

    /**
     * 堆排序实际上是一种选择排序的优化，
     * 把未排序的部分构造成堆的形式，这样就可以在O（logn）的时间内选出最值
     * 1.将未排序数组构造成一个堆（若从小到大排序则需构造大根堆，反之构造小根堆）
     * 2.将堆顶元素与堆尾元素交换，然后将堆的长度减一（此时，就相当于将堆尾的元素加到已排序的序列中）
     * 3.重复2操作n次
     * @param s 待排序数组
     * @return 排序后数组
     */
    private static int[] 堆排序(int[] s){
        init(s);
        for (int i=s.length-1;i>0;){
            int t=s[i]; s[i]=s[0]; s[0]=t;
            sink(s,0,--i);
        }
        return s;
    }

    /**
     * 初始化未排序数组
     * @param s 待排序数组
     */
    private static void init(int[] s){
        for (int i=(s.length-1)/2;i>=0;i--){
            sink(s,i,s.length-1);
        }
    }

    /**
     * 下沉元素
     * @param s 原数组
     * @param k 排序的位置
     * @param end 排序长度
     */
    private static void sink(int[] s,int k,int end){
        while (2*k+1 <= end){
            int c=2*k+1;
            if (c+1 <= end && s[c+1]>s[c])
                c++;
            if (s[c]>s[k]){
                int t=s[k]; s[k]=s[c]; s[c]=t;
            }else {
                break;
            }
            k=c;
        }
    }


    /**
     * 希尔排序是插入排序的一种优化，它是带间隔的使用插入排序，
     * 1.设置最大间隔值h（不能超过数组长度）
     * 2.以间隔h把原数组分为h个长度为length/h的子数组，进行h次插入排序
     * 3.减小间隔h，重复2操作，直至h为1
     * 时间复杂度：约为O(n^1.3)
     * @param s 待排序数组
     * @return 排序后数组
     */
    private static int[] 希尔排序(int[] s){
        int h=1;
        while (h*3+1<s.length){
            h=h*3+1;
        }
        while (h>=1){
            for (int i=h;i<s.length;i++) {
                int t=s[i];
                int j=i;
                while (j>=h && s[j-h]>t){
                    s[j]=s[j-h];
                    j-=h;
                }
                s[j]=t;
            }
            h/=3;
        }
        return s;
    }

    /*
      下面三种是非比较的排序算法，主要使用的是哈希的思想，以空间换时间。
      限制是：这三种方法都限制输入数据的范围
     */

    /**
     * 需事先知道数组中元素的范围n，
     * 开辟n大小的空间，count[n]记录值为n的元素出现的次数
     * @param s 待排序数组
     * @return 排序后数组
     */
    private static int[] 计数排序(int[] s){
        int max= Arrays.stream(s).max().getAsInt();
        int min=Arrays.stream(s).min().getAsInt();
        if (min<0){
            min=-min;
            max+=min;
        }else {
            min=0;
        }
        int[] count=new int[max+1];
        for (int i : s) {
            count[i+min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] temp = new int[s.length];
        System.arraycopy(s, 0, temp, 0, s.length);
        for (int i = s.length - 1; i >= 0; i--) {
            int index = count[temp[i] + min] - 1;
            s[index] = temp[i];
            count[temp[i] + min]--;
        }
        return s;
    }


    /*
      基数排序：针对关键字的排序（如：个位，十位）
     */
    /*
        桶排序：先根据数组长度划分出k个桶，
        将元素根据大小分配到各个桶中，对每个桶排序
        将每个桶的元素连起来即为排序数组
     */
}
