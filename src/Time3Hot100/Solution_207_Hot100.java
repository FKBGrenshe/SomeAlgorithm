package Time3Hot100;

import java.util.*;

public class Solution_207_Hot100 {

    Map<Integer, List<Integer>> request = new HashMap<>();
    boolean[] finish;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        finish = new boolean[numCourses];

        Arrays.fill(finish, true);

        boolean stillHavepreCourse = false;
        for (int[] prereque : prerequisites) {

            int curCourse = prereque[0];
            int needPre = prereque[1];

//            request[curCourse] = needPre;
            if (request.containsKey(curCourse)){
                request.get(curCourse).addLast(needPre);
            }else{
                ArrayList<Integer> needCourese = new ArrayList<>();
                needCourese.add(needPre);
                request.put(curCourse, needCourese);
            }
            finish[curCourse] = false;
            stillHavepreCourse = true;
        }
        int curTimeChanges = -1;
        while (stillHavepreCourse && curTimeChanges != 0){
            curTimeChanges = 0;
            stillHavepreCourse = false;
            for (int curCourse = 0; curCourse < finish.length; curCourse++) {
                if (!finish[curCourse]){
                    List<Integer> needCourese = request.get(curCourse);
                    needCourese.removeIf(preReq -> finish[preReq]);
                    if (needCourese.isEmpty()){
                        // can study curCourse
                        request.remove(curCourse);
                        finish[curCourse] = true;
                        curTimeChanges++;
                    }else{
                        // cannot study curCourse
                        stillHavepreCourse = true;
                    }
                }
            }
        }
        return !stillHavepreCourse;
    }


    public static void main(String[] args) {
        Solution_207_Hot100 solution207Hot100 = new Solution_207_Hot100();
        System.out.println(solution207Hot100.canFinish(
                3,
                new int[][]{
                        {1, 0},
                        {1, 2},
                        {0, 1}
                }
        ));
        System.out.println(solution207Hot100.canFinish(
                2,
                new int[][]{
                        {1, 0}
                }
        ));
    }

}
