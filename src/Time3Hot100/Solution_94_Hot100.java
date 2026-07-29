package Time3Hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution_94_Hot100 {

    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root){
        if (root == null){
            return ans;
        }

        doTraversal(root);
        return ans;
    }

    private void doTraversal(TreeNode curNode) {
        if (curNode == null){
            return;
        }

        doTraversal(curNode.left);
        ans.add(curNode.val);
        doTraversal(curNode.right);
    }

}


