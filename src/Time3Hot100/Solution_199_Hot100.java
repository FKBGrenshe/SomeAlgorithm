package Time3Hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution_199_Hot100 {

    public List<TreeNode> curLevelNode = new ArrayList<>();
    public List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        curLevelNode.addLast(root);
        doSearch();
        return ans;
    }

    private void doSearch() {
        if (curLevelNode.isEmpty()){
            return;
        }

        ans.addLast(curLevelNode.getLast().val);

        int length = curLevelNode.size();
        for (int i = 0; i < length; i++) {
            TreeNode removeNode = curLevelNode.removeFirst();
            if (removeNode.left != null){
                curLevelNode.addLast(removeNode.left);
            }
            if (removeNode.right != null){
                curLevelNode.addLast(removeNode.right);
            }
        }

    }
}
