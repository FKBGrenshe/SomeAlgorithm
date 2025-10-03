import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历 && 递归
 */

public class Solution_145 {

    /**
     *  后序： 左节点 - 右节点 - 中节点
     * @param root 当前遍历时的根节点
     * @return List
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> treeNodeList = new ArrayList<>();
        postOrder(root,treeNodeList);
        return treeNodeList;
    }

    public void postOrder(TreeNode curNode, List list){
        // 确定终止条件：当前节点为空时，表示遍历到底
        if (curNode == null){
            return;
        }
        // 递归逻辑：left -> right -> mid
        //left
        postOrder(curNode.left,list);
        // right
        postOrder(curNode.right,list);
        // mid
        list.add(curNode.val);
    }


}
