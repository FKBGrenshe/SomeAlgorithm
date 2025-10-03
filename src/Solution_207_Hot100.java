import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2025-03-22
 * @Description: 207课程表
 */
public class Solution_207_Hot100 {


    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[][] dp = new int[numCourses][numCourses];
        // 0-可读，>0表示需要几门前置课程
        int[] course = new int[numCourses];
        Arrays.fill(course, 0);
        // dp -- dp[i][j]代表第i个课程是否需要j课程为前置课程
        for (int i = 0; i < prerequisites.length; i++) {
            dp[prerequisites[i][0]][prerequisites[i][1]] = 1;
            course[prerequisites[i][0]]++;
        }

        // 遍历dp数组，找到第i门可读的课程，进行深搜，将所有第i门课程作为前置课程的课均设为可读
        for (int i = 0; i < numCourses; i++) {
            boolean canLearnFlag = true;
            for (int j = 0; j < dp[i].length; j++) {
                if (dp[i][j] == 1){
                    canLearnFlag = false;
                    break;
                }
            }
            if (canLearnFlag){
                learn(dp, course, i);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (course[i] > 0){
                return false;
            }
        }
        return true;

    }


    public void learn(int[][] dp, int[] course, int i){
        // 表示第i门课已读 -- 需要第i门课的第j门课可读
        for (int j = 0; j < dp.length; j++) {
            if (dp[j][i] == 1){
                dp[j][i] = 0;
                course[j]--;
                if (course[j] == 0){
                    learn(dp, course, j);
                }
            }
        }
    }



    public static void main(String[] args) {
        Solution_207_Hot100 solution207Hot100 = new Solution_207_Hot100();

        int numCourses = 3;
        int[][] prerequisites = new int[][]{
                {1,0},
                {1,2},
                {0,1}
        };

        //[[1,0],[1,2],[0,1]]

        System.out.println(solution207Hot100.canFinish(numCourses, prerequisites));

    }


}
