import java.util.ArrayList;
import java.util.List;

public class Solution_94_Hot100 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> treeNodeList = new ArrayList<>();
        inorder(root, treeNodeList);
        return treeNodeList;
    }

    private void inorder(TreeNode curNode, List<Integer> treeNodeList) {
        // 终止条件 -- 当前节点为空，则到底，返回
        if (curNode == null){
            return;
        }
        // 递归逻辑 -- left -> mid -> right
        // left
        inorder(curNode.left, treeNodeList);
        // mid
        treeNodeList.add(curNode.val);
        // right
        inorder(curNode.right, treeNodeList);
    }
}
