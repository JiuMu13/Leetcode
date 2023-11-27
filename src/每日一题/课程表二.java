package 每日一题;

import java.util.LinkedList;
import java.util.Queue;

public class 课程表二 {
    private LinkedList<Integer>[] list;
    int[] fs;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        fs=new int[numCourses];//记录点的入度
        list=new LinkedList[numCourses];
        int result=0;
        int[] r=new int[numCourses];
        //构造邻接表
        for (int i=0;i<numCourses;i++) {
            list[i] = new LinkedList<Integer>();
        }
        for (int i=0;i<prerequisites.length;i++){
            list[prerequisites[i][1]].add(prerequisites[i][0]);
            fs[prerequisites[i][0]]++;
        }
        //
        Queue<Integer> q=new LinkedList<>();
        for (int i=0;i<numCourses;i++) {
            if (fs[i]==0) {
                q.offer(i);
                while (!q.isEmpty()) {
                    if (fs[q.peek()]!=0){
                        return new int[0];
                    }
                    int curr=q.poll();
                    fs[curr]--;
                    r[result++]=curr;
                    for (int e:list[curr]) {
                        if (fs[e]==1) {
                            q.offer(e);
                        }
                        fs[e]--;
                    }
                }
            }

        }
        for (int i=0;i<numCourses;i++)
            if (fs[i]!=-1)
                return new int[0];
        return r;
    }

    public static void main(String[] args) {
        课程表二 t=new 课程表二();
        int[][] s={{1,0}};
        t.findOrder(2,s);
    }

}
