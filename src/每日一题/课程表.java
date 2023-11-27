package 每日一题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class 课程表 {
    private LinkedList<Integer>[] list;
    boolean result=true;
    int[] fs;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        fs=new int[numCourses];//0代表没有被遍历过，1代表当前深度搜索遍历过，2代表通过搜索
        list=new LinkedList[numCourses];
        //构造邻接表
        for (int i=0;i<numCourses;i++) {
                list[i] = new LinkedList<Integer>();
        }
        for (int i=0;i<prerequisites.length;i++){
            list[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        //遍历dfs数组
        for (int i=0;i<numCourses;i++){
            if(fs[i]==0){
                dfs(i);
            }
        }
        return result;
    }
    private void dfs(int i){
        fs[i]=1;
        for (int e:list[i]) {
            if (fs[e]==0){
                dfs(e);
            }else if(fs[e]==1){
                result=false;
                return;
            }
        }
        fs[i]=2;
    }
}
