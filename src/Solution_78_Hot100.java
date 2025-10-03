import java.util.ArrayList;
import java.util.List;

public class Solution_78_Hot100 {

    List<Integer> path = new ArrayList<>();
    List<List<Integer>> resutls = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            backTracing(i,nums,0);
        }
        return resutls;
    }

    private void backTracing(int i, int[] nums, int startIndex){
        // 终止条件：叶子节点
        if (i == path.size()){
            resutls.add(new ArrayList<>(path));
            return;
        }
        // 单层递归
        for (int j = startIndex; j < nums.length; j++) {
            if (!path.contains(nums[j])) {
                path.add(nums[j]);
                backTracing(i, nums, j + 1);
                path.remove(path.size() - 1);
            }
        }
    }
}
