package Time2Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-02-02
 * @Description:
 */
public class Solution_94_Hot100 {

    ArrayList<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {

        doMiddle(root);
        return result ;
    }

    private void doMiddle(TreeNode curNode) {
        if (curNode == null){
            return;
        }

        // mid - left - right
        doMiddle(curNode.left);
        result.add(curNode.val);
        doMiddle(curNode.right);
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
