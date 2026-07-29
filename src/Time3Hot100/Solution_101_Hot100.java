package Time3Hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution_101_Hot100 {

    List<TreeNode> curLevelNode = new ArrayList<>();
    TreeNode nullNode = new TreeNode(-999);


    public boolean isSymmetric(TreeNode root) {
        return doSymmetric(root.left, root.right);
    }

    private boolean doSymmetric(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null){
            return true;
        }
        if (leftRoot == null || rightRoot == null){
            return false;
        }

        boolean compareFlag = leftRoot.val == rightRoot.val;

        // 对比left 和 right-right
        compareFlag  = compareFlag && doSymmetric(leftRoot.left, rightRoot.right)&& doSymmetric(leftRoot.right, rightRoot.left);
        return compareFlag;
    }

    /*
    *   1
    *  2  2
    *   3   3
    * */

}
