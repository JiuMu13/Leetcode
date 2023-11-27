package 每日一题;

public class 只出现一次的数字 {
    //    public int singleNumber(int[] nums) {
//        Set<Integer> s=new HashSet(nums.length/2);
//        for(int e:nums){
//            if(s.contains(e)){
//                s.remove(e);
//            }else{
//                s.add(e);
//            }
//        }
//        return s.iterator().next();
//    }
    //利用异或运算的特性
    public int singleNumber(int[] nums) {
        int r = 0;
        for (int e : nums) {
            r = r ^ e;
        }
        return r;
    }
}
