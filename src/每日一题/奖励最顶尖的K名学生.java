package 每日一题;

import java.util.*;

public class 奖励最顶尖的K名学生 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positiveSet=new HashSet<>();
        Set<String> negativeSet=new HashSet<>();
        for (String s:positive_feedback)  positiveSet.add(s);
        for (String s:negative_feedback)  negativeSet.add(s);
        int[][] r=new int[student_id.length][2];// 0表示id,1表示成绩
        for (int i=0;i<report.length;i++){
            r[i][0]=student_id[i];
            for (String e:report[i].split(" "))
                if (positiveSet.contains(e))  r[i][1]+=3;
                else if (negativeSet.contains(e))  r[i][1]-=1;
        }
        Arrays.sort(r, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                if (t1[1]==t2[1])
                    return t1[0]-t2[0];
                return t2[1]-t1[1];
            }
        });
        List<Integer> result=new ArrayList<>(k);
        for (int i=0;i<k;i++) result.add(r[i][0]);
        return result;
    }
}
