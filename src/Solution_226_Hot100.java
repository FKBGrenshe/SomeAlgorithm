import com.sun.source.tree.Tree;

public class Solution_226_Hot100 {
    public TreeNode invertTree(TreeNode root){
        invertFunc(root);
        return root;
    }

    private void invertFunc(TreeNode curNode) {
        // 终止条件：curNode == null
        if (curNode == null){
            return;
        }
        /**
         * 递归逻辑：中序遍历
         * 中：curNode.left <交换> curNode.right;
         * 左：func(curNode.left)
         * 右：func(curNode.right)
         */
        // 中
        TreeNode temp = curNode.left;
        curNode.left = curNode.right;
        curNode.right = temp;
        // 左
        invertFunc(curNode.left);
        // 右
        invertFunc(curNode.right);

    }
}
