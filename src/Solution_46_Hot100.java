import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Solution_46_Hot100 {

    List<List<Integer>> results = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backTracing(nums);
        return results;
    }

    private void backTracing(int[] nums){
        // ending point
        if (path.size() == nums.length){
            results.add(new ArrayList<>(path));
            return;
        }
        // 单层递归
        for (int i = 0; i < nums.length; i++) {
            if (!path.contains(nums[i])) {
                path.add(nums[i]);
                backTracing(nums);
                path.remove(path.size()-1);
            }
        }
    }
}
