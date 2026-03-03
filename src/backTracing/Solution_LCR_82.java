package backTracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-03
 * @Description: 组合总和Ⅱ
 */
public class Solution_LCR_82 {

    List<List<Integer>> globalResult = new ArrayList<>();
    List<Integer> curResult = new ArrayList<>();
    int target;
    int[] candidates;
    int curSum = 0;
    boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        this.candidates = candidates;
        this.used = new boolean[candidates.length];
        Arrays.fill(used,false);
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
            if ( i-1 >= 0 && candidates[i] == candidates[i-1] && !used[i-1]){
                continue;
            }
            curResult.add(candidates[i]);
            curSum += candidates[i];
            used[i] = true;
            backTracing(i+1);
            curResult.remove(Integer.valueOf(candidates[i]));
            curSum -= candidates[i];
            used[i] = false;
        }

    }

    public static void main(String[] args) {
        Solution_LCR_82 solutionLcr82 = new Solution_LCR_82();


//        int[] candidates = {2,3,6,7};
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        List<List<Integer>> lists = solutionLcr82.combinationSum2(candidates, target);

        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }

    }
}
