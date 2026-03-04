package backTracing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-04
 * @Description: 子集
 */
public class Solution_78 {

    List<List<Integer>> globalResult = new ArrayList<>();
    List<Integer> curResult = new ArrayList<>();
    int[] globalNums;

    public List<List<Integer>> subsets(int[] nums) {
        globalNums = nums;
        backTracing(0);
        return globalResult;
    }

    private void backTracing(int beginIdx) {
        globalResult.add(new ArrayList<>(curResult));

        for (int i = beginIdx; i < globalNums.length; i++) {
            curResult.add(globalNums[i]);
            backTracing(i+1);
            curResult.remove(Integer.valueOf(globalNums[i]));
        }
    }

    public static void main(String[] args) {
        Solution_78 solution78 = new Solution_78();
        List<List<Integer>> res = solution78.subsets(new int[]{
            1,2,3
        });
        res.forEach(x -> System.out.println(x.toString()));

    }

}
