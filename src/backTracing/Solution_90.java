package backTracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-04
 * @Description: 子集Ⅱ
 */
public class Solution_90 {
    List<List<Integer>> globalResult = new ArrayList<>();
    List<Integer> curResult = new ArrayList<>();
    int[] nums;
    boolean[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.used = new boolean[nums.length];
        backTracing(0);
        return globalResult;
    }

    private void backTracing(int beginIdx) {
        int curIdx = beginIdx-1;
        if ( curIdx > 0 && curIdx < nums.length && nums[curIdx] == nums[curIdx-1] && !used[curIdx - 1]){
            return;
        }

        globalResult.add(new ArrayList<>(curResult));
        for (int i = beginIdx; i < nums.length; i++) {
            curResult.add(nums[i]);
            used[i] = true;
            backTracing(i+1);
            used[i] = false;
            curResult.remove(Integer.valueOf(nums[i]));
        }


    }

    public static void main(String[] args) {
        Solution_90 solution90 = new Solution_90();
        List<List<Integer>> lists = solution90.subsetsWithDup(new int[]{
            1,1
        });

        lists.forEach(s -> System.out.printf(s.toString()));

    }


}
