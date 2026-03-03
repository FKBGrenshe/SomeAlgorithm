package backTracing;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-03-02
 * @Description: 组合总和3：指使用数字1~9，且仅能使用一次，相加之和为N的K个数
 */
public class Solution_216 {

    int n, k;
    List<List<Integer>> globalRes = new ArrayList<>();
    List<Integer> curRes = new ArrayList<>();
    int curSum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.n = n;
        this.k = k;
        // todo
        backTracing(1,9);
        return globalRes;
    }

    public void backTracing(int minVal, int maxVal){
        if (curSum == n && curRes.size()==k){
            globalRes.add(new ArrayList<>(curRes));
            return;
        }

        for (int curVal = minVal; curVal <= maxVal; curVal++) {
            curRes.add(curVal);
            curSum += curVal;
            backTracing(curVal+1, maxVal);
            curSum -= curVal;
            curRes.remove(Integer.valueOf(curVal));
        }
    }

    public static void main(String[] args) {
        Solution_216 solution216 = new Solution_216();
        List<List<Integer>> results = solution216.combinationSum3(3,7);
        Solution_77.printRes(results);
    }

}