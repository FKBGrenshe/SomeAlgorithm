import java.util.ArrayList;
import java.util.List;

public class Solution_77 {
    List<List<Integer>> results = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTracing(n,k,1);
        return results;
    }
    private void backTracing(int n, int k, int startIndex ){
        // 终止条件：到达叶子节点 -- path.len == k
        if (path.size() == k){
            results.add(new ArrayList<>(path));
            return;
        }
        // for循环：横向便利
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            //  递归
            backTracing(n,k,i+1);
            // todo 回溯操作
            path.remove(path.size()-1);
        }
    }
}
