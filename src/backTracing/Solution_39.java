package backTracing;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-03
 * @Description: 组合总和
 */
public class Solution_39 {

    List<List<Integer>> globalResult = new ArrayList<>();
    List<Integer> curResult = new ArrayList<>();
    int target;
    int[] candidates;
    int curSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        backTracing(0);

        return globalResult;
    }


    void backTracing(int curIdx){
        if (curSum == target){
            globalResult.add(new ArrayList<>(curResult));
            return;
        }
        if (curSum > target){
            return;
        }

        for (int i = curIdx; i < candidates.length; i++) {
            curResult.add(candidates[i]);
            curSum += candidates[i];
            backTracing(i);
            curResult.remove(Integer.valueOf(candidates[i]));
            curSum -= candidates[i];
        }

        /*for (int candidate : candidates) {
            curResult.add(candidate);
            curSum += candidate;
            backTracing();
            curResult.remove(Integer.valueOf(candidate));
            curSum -= candidate;
        }*/
    }

    public static void main(String[] args) {
        Solution_LCR_81 solutionLcr81 = new Solution_LCR_81();


        int[] candidates = {2,3,6,7};
        int target = 7;

        List<List<Integer>> lists = solutionLcr81.combinationSum(candidates, target);

        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }

    }

}
