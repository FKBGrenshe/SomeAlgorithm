package Time3Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_39_Hot100 {

    List<List<Integer>> globalans = new ArrayList<>();
    List<Integer> curpath = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTracing(candidates, target);
        return globalans;
    }

    void backTracing(int[] candidates, int res){
        if (res <= 0){
            if (res == 0){
                globalans.add(new ArrayList<>(curpath));
            }
            return;
        }


        int prevNumber = curpath.isEmpty() ? candidates[0] : curpath.get(curpath.size()-1);
        int startIdx = 0;
        while (candidates[startIdx] != prevNumber){
            startIdx++;
        }

        for (; startIdx < candidates.length; startIdx++){
            curpath.add(candidates[startIdx]);
            backTracing(candidates, res-candidates[startIdx]);
            curpath.remove(Integer.valueOf(candidates[startIdx]));
        }
    }

    public static void main(String[] args) {
        Solution_39_Hot100 solution39Hot100 = new Solution_39_Hot100();
        List<List<Integer>> lists = solution39Hot100.combinationSum(
                new int[]{2, 3, 6, 7},
                7
        );
        for (List<Integer> list : lists) {
            System.out.printf(list.toString());
        }
    }

}
