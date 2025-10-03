import java.util.ArrayList;
import java.util.List;

public class Solution_39_Hot100 {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> results = new ArrayList<>();
    int curTarget = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        curTarget = target;
        backTracing(candidates,0);
        return results;
    }

    void backTracing( int[] candidates, int startIndex){
        // endPoint curTarget=0
        if (curTarget == 0){
            results.add(new ArrayList<>(path));
            return;
        }
        // 单层递归

        for (int i = startIndex; i < candidates.length; i++) {
            if (curTarget >= candidates[i]){
                path.add(candidates[i]);
                curTarget -= candidates[i];
                backTracing(candidates, i);
                curTarget += path.remove(path.size() - 1);
            }/*else {
                curTarget += path.remove(path.size() - 1);
            }*/

            /*if (curTarget > 0){
                path.add(candidates[i]);
                curTarget -= candidates[i];
                backTracing(candidates, i);
            }
            if (curTarget < 0){
                Integer removed = path.remove(path.size() - 1);
                curTarget += removed;
            }*/
        }

    }
}
